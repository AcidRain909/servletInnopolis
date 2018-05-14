package ru.innopolis.stc9.lesson20ee2.controller;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.lesson20ee2.db.dao.SubjectDaoImpl;
import ru.innopolis.stc9.lesson20ee2.pojo.Grades;
import ru.innopolis.stc9.lesson20ee2.pojo.Subject;
import ru.innopolis.stc9.lesson20ee2.pojo.User;
import ru.innopolis.stc9.lesson20ee2.service.GradesService;
import ru.innopolis.stc9.lesson20ee2.service.SubjectService;
import ru.innopolis.stc9.lesson20ee2.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/** Класс для обработки dashboard профессоров
 * @version 1.0
 * @author Acid_Rain909
 */
public class AdminDashboardController extends HttpServlet {
    /** Подключаем логгер */
    private static Logger logger = Logger.getLogger(AdminDashboardController.class);

    /**
     * Функция для обработки серверных данных на странице
     * @param req
     * @param resp
     *
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /** Атрибут с массивом объектов Grades */
        GradesService gradesService = new GradesService();
        ArrayList<Grades> gradesList = gradesService.getAllGrades();
        req.setAttribute("gradesList", gradesList);

        /** Атрибут с массивом объектов Subject */
        SubjectService subjectService = new SubjectService();
        ArrayList<Subject> subjectsList = subjectService.getAllSubjects();
        req.setAttribute("subjectsList", subjectsList);

        /** Атрибут с массивом объектов User */
        UserService userService = new UserService();
        ArrayList<User> studentsList = userService.getUsersByRole(1);
        req.setAttribute("studentsList", studentsList);

        req.getRequestDispatcher("/professor-dashboard.jsp").forward(req, resp);
    }

    /**
     * Функция для добавления новой оценки
     * @param req
     * @param resp
     *
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException. Message = " + e.getMessage());
            e.printStackTrace();
        }
        resp.setCharacterEncoding("UTF-8");

        /** Собираем данные с формы */
        Integer professorId = (Integer) req.getSession().getAttribute("userId");
        Integer studentId = Integer.valueOf(req.getParameter("studentName"));
        Integer subjectId = Integer.valueOf(req.getParameter("subjectName"));
        Integer rating = Integer.valueOf(req.getParameter("rating"));

        /** Логируем данные с формы */
        logger.info("Parameters: professorId, studentId, subjectId, rating = (" + professorId +
        ", " + studentId + ", " + subjectId + ", " + rating + ") was added to Grade constructor.");

        GradesService gradesService = new GradesService();
        Grades gradeToDB = new Grades(professorId, studentId, subjectId, rating);

        logger.info("Object sent to gradesService");
        gradesService.addGrade(gradeToDB);

        try {
            doGet(req, resp);
        } catch (ServletException e) {
            logger.error("ServletException. Message = " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("IOException. Message = " + e.getMessage());
            e.printStackTrace();
        }
    }
}
