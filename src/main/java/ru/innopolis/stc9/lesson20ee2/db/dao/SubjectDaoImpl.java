package ru.innopolis.stc9.lesson20ee2.db.dao;

import ru.innopolis.stc9.lesson20ee2.db.connection.ConnectionManagerImpl;
import ru.innopolis.stc9.lesson20ee2.pojo.Subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubjectDaoImpl implements SubjectDao{

    @Override
    public ArrayList getAllSubjects() throws SQLException {
        ArrayList<Subject> subjectsList = new ArrayList<>();
        Subject result = null;
        Connection connection = new ConnectionManagerImpl().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT " +
                "* FROM subjects");
        ResultSet resultSet = preparedStatement.executeQuery();
        connection.close();
        while (resultSet.next()) {
            result = new Subject(resultSet.getInt(1),
                    resultSet.getString(2));
                subjectsList.add(result);
        }
        return subjectsList;
    }
}
