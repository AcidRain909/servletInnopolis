package ru.innopolis.stc9.lesson20ee2.pojo;

/** Класс для пользователей
 * @version 1.0
 * @author Acid_Rain909
 */

public class User {

    /** Инкрементный id */
    private int id;

    /** Логин */
    private String login;

    /** Пароль */
    private String password;

    /** ID прав/роли */
    private int roleId;

    /** Имя пользователя */
    private String name;

    /** Создает объект User со значениями
     * @param id - id
     * @param login - логин пользователя
     * @param password - пароль пользователя
     * @param roleId - роль/права пользователя
     * @param name - имя пользователя
     * @see Subject#Subject(int, String)
     */
    public User(int id, String login, String password, int roleId, String name) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int role) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
