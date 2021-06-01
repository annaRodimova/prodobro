package Registration;

public class User {
    public static int id = 5;
    private String surname = "";
    private String name = "";
    private String patronymic = "";
    private String password = "";
    private String email = "";
    private String login = "";
    private long phone = 0;
    private String birthday = "";

    public User() {

    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    public String getBirthday() {
        return birthday;
    }


    public User (int id,String password, String email, String login, long phone, String surname, String name,
                     String patronymic, String birthday) {
        this.id = ++id;
        this.password = password;
        this.email = email;
        this.login = login;
        this.phone = phone;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthday = birthday;
    }

}
