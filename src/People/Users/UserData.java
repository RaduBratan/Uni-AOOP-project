package People.Users;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserData {

    private final int userId;
    private String name, email, password, phone;
    private Date birthDate;

    public UserData(int userId, String name, String email, String password, String phone, Date birthDate) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public UserData(int userId, Scanner in) throws ParseException {
        this.userId = userId;
        this.read(in);
    }

    public void read(Scanner in) throws ParseException {
        System.out.println("Your full name: ");
        this.name = in.nextLine();
        System.out.println("Your email address: ");
        this.email = in.nextLine();
        System.out.println("Your password: ");
        this.password = in.nextLine();
        System.out.println("Your phone number with country code: ");
        this.phone = in.nextLine();
        System.out.println("Your date of birth (in yyyy-mm-dd format): ");
        this.birthDate = new SimpleDateFormat("yyyy-mm-dd").parse(in.nextLine());
    }

    @Override
    public String toString() {
        return "{" +
                "\n" +
                " userId=" + userId + "', " +
                "\n" +
                " name='" + name + "', " +
                "\n" +
                " email='" + email + "', " +
                "\n" +
                " password='" + password + "', " +
                "\n" +
                " phone='" + phone + "', " +
                "\n" +
                " birthDate=" + (new SimpleDateFormat("yyyy-mm-dd")).format(birthDate) + ", " +
                "\n" +
                "}";
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
