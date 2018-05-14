package ru.innopolis.stc9.lesson20ee2.db.dao;

import ru.innopolis.stc9.lesson20ee2.pojo.User;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao {
    public User getUserByLogin(String login) throws SQLException;
    public ArrayList<User> getUsersByRole(int roleId) throws SQLException;
}
