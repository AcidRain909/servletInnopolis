package ru.innopolis.stc9.lesson20ee2.service;


import org.apache.log4j.Logger;
import ru.innopolis.stc9.lesson20ee2.db.dao.SubjectDao;
import ru.innopolis.stc9.lesson20ee2.db.dao.SubjectDaoImpl;
import ru.innopolis.stc9.lesson20ee2.pojo.Subject;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Сервис для предметов
 *
 * @author Acid_Rain909
 * @version 1.0
 * @see Subject
 * @see SubjectDaoImpl
 */
public class SubjectService {
    /**
     * Подключенние логгера
     */
    private static Logger logger = Logger.getLogger(SubjectService.class);

    /**
     * Объект
     *
     * @see SubjectDaoImpl
     */
    private static SubjectDao subjectDao = new SubjectDaoImpl();


    /**
     * Функция для получения всех предметов/наук
     *
     * @return Возвращает массив объектов
     * @see SubjectDaoImpl#getAllSubjects()
     */
    public ArrayList getAllSubjects() {
        ArrayList<Subject> subjectsList = null;
        try {
            subjectsList = subjectDao.getAllSubjects();
        } catch (SQLException e) {
            logger.error("SQLException. Message = " + e.getMessage());
            e.printStackTrace();
        }

        return subjectsList;
    }
}
