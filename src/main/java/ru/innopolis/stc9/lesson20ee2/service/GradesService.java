package ru.innopolis.stc9.lesson20ee2.service;

import org.apache.log4j.Logger;
import ru.innopolis.stc9.lesson20ee2.db.dao.GradesDao;
import ru.innopolis.stc9.lesson20ee2.db.dao.GradesDaoImpl;
import ru.innopolis.stc9.lesson20ee2.pojo.Grades;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Сервис Grades
 *
 * @author Acid_Rain909
 * @version 1.0
 * @see Grades
 * @see GradesDaoImpl
 */
public class GradesService {
    /**
     * Подключение логгера
     */
    private static Logger logger = Logger.getLogger(GradesService.class);

    /**
     * Объект
     *
     * @see GradesDaoImpl
     */
    private static GradesDao gradesDao = new GradesDaoImpl();


    /**
     * Функция для получения всех оценок и данных по ним
     *
     * @return Возвращает массив объектов
     * @see GradesDaoImpl#getGrades()
     */
    public ArrayList getAllGrades() {
        ArrayList<Grades> gradesList = null;
        try {
            gradesList = gradesDao.getGrades();
        } catch (SQLException e) {
            logger.error("SQLException. Message = " + e.getMessage());
            e.printStackTrace();
        }
        return gradesList;
    }

    /**
     * Функция для получения всех оценок и данных по имени студента
     *
     * @param id студента
     * @return Возвращает массив объектов
     * @see GradesDaoImpl#getGradesByStudent(int)
     */
    public ArrayList getAllGradesByStudent(int id) {
        ArrayList<Grades> gradesList = null;
        try {
            gradesList = gradesDao.getGradesByStudent(id);
        } catch (SQLException e) {
            logger.error("SQLException. Message = " + e.getMessage());
            e.printStackTrace();
        }

        return gradesList;
    }

    /**
     * Функция добавления новой оценки
     *
     * @param grade объект
     * @return boolean
     * @see GradesDaoImpl#addGrade(Grades)
     */
    public boolean addGrade(Grades grade) {
        try {
            gradesDao.addGrade(grade);
        } catch (SQLException e) {
            logger.error("SQLException. Message = " + e.getMessage());
            e.printStackTrace();
        }
        return true;
    }
}
