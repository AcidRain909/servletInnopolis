package ru.innopolis.stc9.lesson20ee2.pojo;

/** Класс для наук
 * @version 1.0
 * @author Acid_Rain909
 */
public class Subject {
    /** Инкрементный id */
    private int id;

    /** Имя предмета id */
    private String subjectName;

    /** Создает объект Subject со значениями
     * @param id - id
     * @param subjectName - название предмета
     * @see Subject#Subject(int, String)
     */
    public Subject(int id, String subjectName) {
        this.id = id;
        this.subjectName = subjectName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
