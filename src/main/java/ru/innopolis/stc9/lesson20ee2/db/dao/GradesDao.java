package ru.innopolis.stc9.lesson20ee2.db.dao;


import ru.innopolis.stc9.lesson20ee2.pojo.Grades;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GradesDao {
    public ArrayList getGrades() throws SQLException;
    public ArrayList getGradesByStudent(int id) throws SQLException;
    public boolean addGrade(Grades grade) throws SQLException;
}
