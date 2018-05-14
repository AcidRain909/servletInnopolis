package ru.innopolis.stc9.lesson20ee2.db.dao;

import ru.innopolis.stc9.lesson20ee2.pojo.Subject;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SubjectDao {
    public ArrayList<Subject> getAllSubjects() throws SQLException;
}
