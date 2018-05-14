package ru.innopolis.stc9.lesson20ee2.controller;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.lesson20ee2.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/** Класс для проверки логина/пароля
 * @version 1.0
 * @author Acid_Rain909
 */
public class LoginController extends HttpServlet {
    /** Подключаем логгер */
    private static Logger logger = Logger.getLogger(LoginController.class);

    /** Объект сервиса пользователей
     * @see UserService
     * */
    private UserService userService = new UserService();

    /**
     * Функция для обработки страницы входа
     * @param req
     * @param resp
     *
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("logout".equals(action)) {

            logger.info(req.getSession().getAttribute("login") + " session was aborted");
            req.getSession().invalidate();

        }
        logger.info("Received request for login page");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    /**
     * Функция для проверки логина/пароля
     * @param req
     * @param resp
     *
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("UTF-8");
        String login = req.getParameter("userName");
        String password = req.getParameter("userPassword");

        logger.info("Trying to log in");

        if (userService.checkAuth(login, password)) {
            Integer role = userService.getRole(login);
            String name = userService.getName(login);
            Integer userId = userService.getUserId(login);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);
            req.getSession().setAttribute("name", name);
            req.getSession().setAttribute("userId", userId);
            if (role == 2) {
                try {
                    resp.sendRedirect(req.getContextPath() + "/professor/dashboard");
                } catch (IOException e) {
                    logger.error("Professor LOGIN = " + login + " FAILED!\n " + e.getMessage());
                    e.printStackTrace();
                }

                logger.info("Professor with LOGIN = " + login + " successfully entered.");
            } else if (role == 1) {
                try {
                    resp.sendRedirect(req.getContextPath() + "/student/dashboard");
                } catch (IOException e) {
                    logger.error("Student LOGIN = " + login + " FAILED!\n " + e.getMessage());
                    e.printStackTrace();
                }
                logger.info("Student with LOGIN = " + login + " successfully entered");
            }
        } else {
            try {
                resp.sendRedirect(req.getContextPath() + "/login?errorMsg=authErr");
            } catch (IOException e) {
                logger.error("Log in authorization ERROR with LOGIN = " + login);
                e.printStackTrace();
            }
            logger.info("Log in authorization failed with LOGIN = " + login);
        }
    }
}
