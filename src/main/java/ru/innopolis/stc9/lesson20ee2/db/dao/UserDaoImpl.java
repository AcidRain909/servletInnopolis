package ru.innopolis.stc9.lesson20ee2.db.dao;


import ru.innopolis.stc9.lesson20ee2.db.connection.ConnectionManagerImpl;
import ru.innopolis.stc9.lesson20ee2.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserByLogin(String login) throws SQLException {
        User result = null;
        Connection connection = new ConnectionManagerImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "* FROM users " +
                "WHERE login = ?");
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        connection.close();

        if (resultSet.next()) {
            result = new User(resultSet.getInt("id"), resultSet.getString("login"),
                    resultSet.getString("password"), resultSet.getInt("role_id"),
                    resultSet.getString("name"));
        }

        return result;
    }

    @Override
    public ArrayList<User> getUsersByRole(int roleId) throws SQLException {
        ArrayList<User> studentsList = new ArrayList<>();
        User student = null;
        Connection connection = new ConnectionManagerImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "* FROM users " +
                "WHERE role_id = ?");

        preparedStatement.setInt(1, roleId);
        ResultSet resultSet = preparedStatement.executeQuery();
        connection.close();

        while (resultSet.next()) {
            student = new User(resultSet.getInt("id"), resultSet.getString("login"),
                    resultSet.getString("password"), resultSet.getInt("role_id"),
                    resultSet.getString("name"));
                studentsList.add(student);
        }

        return studentsList;
    }
}
