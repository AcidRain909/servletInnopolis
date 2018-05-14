
package ru.innopolis.stc9.lesson20ee2.service;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.lesson20ee2.db.dao.UserDao;
import ru.innopolis.stc9.lesson20ee2.db.dao.UserDaoImpl;
import ru.innopolis.stc9.lesson20ee2.pojo.User;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Сервис для пользователей
 *
 * @author Acid_Rain909
 * @version 1.0
 * @see User
 * @see UserDaoImpl
 */
public class UserService {
    /** Подключение логгера */
    private static Logger logger = Logger.getLogger(UserService.class);

    /**
     * Объект
     *
     * @see UserDao
     */
    private static UserDao userDao = new UserDaoImpl();


    /**
     * Функция для проверки авторизации
     *
     * @param login логин пользователя
     * @param password пароль пользователя
     * @return Возвращает boolean
     * @see UserDaoImpl#getUserByLogin(String)
     */
    public boolean checkAuth(String login, String password) {
        User user = null;
        try {
            logger.info("User login = " + login + " | " + password);
            user = userDao.getUserByLogin(login);
        } catch (SQLException e) {
            logger.error("SQLException. Message = " + e.getMessage());
            e.printStackTrace();
        }
        return (user != null) && (user.getPassword().equals(password));
    }

    /**
     * Функция для получения роли пользователя
     *
     * @param login логин пользователя
     * @return Integer роли
     * @see UserDaoImpl#getUserByLogin(String)
     */
    public Integer getRole(String login) {
        User user = null;
        try {
            user = userDao.getUserByLogin(login);
        } catch (SQLException e) {
            logger.error("SQLException. Message = " + e.getMessage());
            e.printStackTrace();
        }
        return (user != null) ? user.getRoleId() : 0;
    }

    /**
     * Функция для получения имени пользователя
     *
     * @param login логин пользователя
     * @return String имени
     * @see UserDaoImpl#getUserByLogin(String)
     */
    public String getName(String login) {
        User user = null;
        try {

            user = userDao.getUserByLogin(login);
        } catch (SQLException e) {
            logger.error("SQLException. Message = " + e.getMessage());
            e.printStackTrace();
        }
        return (user != null) ? user.getName() : "";
    }

    /**
     * Функция для получения роли id пользователя
     *
     * @param login логин пользователя
     * @return Integer id пользователя
     * @see UserDaoImpl#getUserByLogin(String)
     */
    public Integer getUserId(String login) {
        User user = null;
        try {
            user = userDao.getUserByLogin(login);
        } catch (SQLException e) {
            logger.error("SQLException. Message = " + e.getMessage());
            e.printStackTrace();
        }
        return (user != null) ? user.getId() : 0;
    }

    /**
     * Функция для получения пользователей по id
     *
     * @param roleId id по которому фильтруются пользователи
     * @return Integer id пользователя
     * @see UserDaoImpl#getUserByLogin(String)
     */
    public ArrayList getUsersByRole(int roleId) {
        ArrayList<User> usersList = null;
        try {
            logger.info("roleId = " + roleId);
            usersList = userDao.getUsersByRole(roleId);
        } catch (SQLException e) {
            logger.error("SQLException. Message = " + e.getMessage());
            e.printStackTrace();
        }

        return usersList;
    }
}

