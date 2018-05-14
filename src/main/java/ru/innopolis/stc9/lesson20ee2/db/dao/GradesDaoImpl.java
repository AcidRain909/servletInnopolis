package ru.innopolis.stc9.lesson20ee2.db.dao;

import ru.innopolis.stc9.lesson20ee2.db.connection.ConnectionManagerImpl;
import ru.innopolis.stc9.lesson20ee2.pojo.Grades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradesDaoImpl implements GradesDao {

    @Override
    public ArrayList getGrades() throws SQLException {
        ArrayList<Grades> gradesList = new ArrayList<>();
        Grades result = null;
        Connection connection = new ConnectionManagerImpl().getConnection();

        PreparedStatement statement = null;

            statement = connection.prepareStatement("SELECT grades.id, c1.name, c2.name, c3.subject_name, rating " +
                    "FROM grades " +
                    "INNER JOIN users c1 ON grades.professor_id = c1.id " +
                    "INNER JOIN users c2 ON grades.student_id = c2.id " +
                    "INNER JOIN subjects c3 ON grades.subject_id = c3.id ");

            ResultSet resultSet = statement.executeQuery();

            connection.close();
        while (resultSet.next()) {
            result = new Grades(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5));
            gradesList.add(result);
        }
        connection.close();

        return gradesList;
    }

    @Override
    public ArrayList getGradesByStudent(int id) throws SQLException {
        ArrayList<Grades> gradesList = new ArrayList<>();
        Grades result = null;
        Connection connection = new ConnectionManagerImpl().getConnection();

        PreparedStatement statement = null;

        statement = connection.prepareStatement("SELECT " +
                "grades.id, c1.name, c2.name, c3.subject_name, rating " +
                "FROM grades " +
                "INNER JOIN users c1 ON grades.professor_id = c1.id " +
                "INNER JOIN users c2 ON grades.student_id = c2.id " +
                "INNER JOIN subjects c3 ON grades.subject_id = c3.id " +
                "WHERE c2.id = ?");
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        connection.close();
        while (resultSet.next()) {
            result = new Grades(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5));
            gradesList.add(result);
        }
        return gradesList;
    }


    @Override
    public boolean addGrade(Grades grade) throws SQLException {

        Connection connection = new ConnectionManagerImpl().getConnection();

        PreparedStatement statement = null;

        statement = connection.prepareStatement("INSERT INTO " +
                "grades (professor_id, student_id, subject_id, rating) " +
                "VALUES (?, ?, ?, ?)");

        statement.setInt(1, grade.getProfessorId());
        statement.setInt(2, grade.getStudentId());
        statement.setInt(3, grade.getSubjectId());
        statement.setInt(4, grade.getRating());

        statement.executeQuery();

        connection.close();

        return true;
    }

}
