package ua.simpleproject.entity;

public class User {
    private int id;
    private String position;
    private String name;
    private String login;
    private String password;
    private String checkWord;
    private int salary;
    private int numberMastake;
    private int experience;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public String getCheckWord() {
        return checkWord;
    }
    public void setCheckWord(String checkWord) {
        this.checkWord = checkWord;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public int getNumberMastake() {
        return numberMastake;
    }
    public void setNumberMastake(int numberMastake) {
        this.numberMastake = numberMastake;
    }
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
}
