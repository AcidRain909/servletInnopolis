package ru.innopolis.stc9.lesson20ee2.pojo;

/** Класс для оценок.
 * @version 1.0
 * @author Acid_Rain909
 */
public class Grades {
    /** Инкрементный id */
    private int id;

    /** Поле хранения имени профессора. */
    private String professorName;

    /** Поле хранения имени студента. */
    private String studentName;

    /** Поле хранения названия предмета. */
    private String subjectName;


    /** Поле хранения ID профессора. */
    private int professorId;

    /** Поле хранения ID студента. */
    private int studentId;

    /** Поле хранения ID предмета. */
    private int subjectId;

    /** Поле для оценки.*/
    private int rating;

    /** Создает объект Grades со значениями
     * @param id - id
     * @param professorName - имя профессора
     * @param studentName - имя студента
     * @param subjectName - название предмета
     * @param rating - оценка
     * @see Grades#Grades(int, String, String, String, int)
     */
    public Grades(int id, String professorName, String studentName, String subjectName, int rating) {
        this.id = id;
        this.professorName = professorName;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.rating = rating;
    }


    /** Создает объект Grades со значениями
     * @param professorId - id профессора
     * @param studentId - id студента
     * @param subjectId - id предмета
     * @param rating - оценка
     * @see Grades#Grades(int, int, int, int)
     */
    public Grades(int professorId, int studentId, int subjectId, int rating) {
        this.professorId = professorId;
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
