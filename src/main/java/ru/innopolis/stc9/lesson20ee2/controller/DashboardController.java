package ru.innopolis.stc9.lesson20ee2.controller;

import ru.innopolis.stc9.lesson20ee2.pojo.Grades;
import ru.innopolis.stc9.lesson20ee2.service.GradesService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/** Класс для обработки dashboard студентов
 * @version 1.0
 * @author Acid_Rain909
 */
public class DashboardController extends HttpServlet {
    /**
     * Функция для обработки серверных данных на странице
     * @param req
     * @param resp
     *
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GradesService gradesService = new GradesService();
        int studentId = (int) req.getSession().getAttribute("userId");
        ArrayList<Grades> gradesList = gradesService.getAllGradesByStudent(studentId);
        req.setAttribute("gradesList", gradesList);
        req.getRequestDispatcher("/student-dashboard.jsp").forward(req, resp);
    }
}
