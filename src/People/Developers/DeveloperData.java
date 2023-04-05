package People.Developers;

import Games.Game;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DeveloperData {

    private final int devId;
    private String name, email, password, cnp, phone;
    private Date birthDate;
    private Address address;
    private Game game;

    public DeveloperData(int devId, String name, String email, String password, String cnp, String phone, Date birthDate, Address address, Game game) {
        this.devId = devId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cnp = cnp;
        this.phone = phone;
        this.birthDate = birthDate;
        this.address = address;
        this.game = game;
    }

    public DeveloperData(int devId, Scanner in) throws ParseException {
        this.devId = devId;
        this.read(in);
    }

    public void read(Scanner in) throws ParseException {
        System.out.println("Your name: ");
        this.name = in.nextLine();
        System.out.println("Your email address: ");
        this.email = in.nextLine();
        System.out.println("Your password: ");
        this.password = in.nextLine();
        System.out.println("Your CNP: ");
        this.cnp = in.nextLine();
        System.out.println("Your phone number: ");
        this.phone = in.nextLine();
        System.out.println("Your date of birth (in yyyy-mm-dd format): ");
        this.birthDate = new SimpleDateFormat("yyyy-mm-dd").parse(in.nextLine());
        System.out.println("Your address: ");
        this.address = new Address(in);
    }

    @Override
    public String toString() {
        return "{" +
                "\n" +
                " devId=" + devId + "', " +
                "\n" +
                " name='" + name + "', " +
                "\n" +
                " email='" + email + "', " +
                "\n" +
                " password='" + password + "', " +
                "\n" +
                " cnp='" + cnp + "', " +
                "\n" +
                " phone='" + phone + "', " +
                "\n" +
                " birthDate=" + (new SimpleDateFormat("yyyy-mm-dd")).format(birthDate) + ", " +
                "\n" +
                " address=" + address.toString() +
                "}";
    }

    public int getDeveloperId() {
        return devId;
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

    public String getCNP() {
        return cnp;
    }
    public void setCNP(String cnp) {
        this.cnp = cnp;
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

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
