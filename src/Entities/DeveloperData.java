package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DeveloperData {

    private final int devId;
    private String name, email, password, cnp, phone;
    private Date birthDate;
    private AddressData addressData;
    // protected List<GameData> games = new ArrayList<>();
    // private final GameFactory gameFactory = new GameFactory();

    public DeveloperData(int devId, String name, String email, String password, String cnp, String phone, Date birthDate, AddressData addressData) {
        this.devId = devId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.cnp = cnp;
        this.phone = phone;
        this.birthDate = birthDate;
        this.addressData = addressData;
    }

    public DeveloperData(int devId, Scanner scanner) throws ParseException {
        this.devId = devId;
        this.read(scanner);
    }

    public DeveloperData(int devId, ResultSet result) throws SQLException {
        this.devId = devId;
        this.read(result);
    }

    public void read(Scanner scanner) throws ParseException {
        System.out.println("Numele: ");
        this.name = scanner.nextLine();
        System.out.println("Adresa de e-mail: ");
        this.email = scanner.nextLine();
        System.out.println("Parola: ");
        this.password = scanner.nextLine();
        System.out.println("CNP-ul: ");
        this.cnp = scanner.nextLine();
        System.out.println("Numărul de telefon: ");
        this.phone = scanner.nextLine();
        System.out.println("Data de naștere (în formatul aaaa-ll-zz): ");
        this.birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine());
        System.out.println("Adresa completă: ");
        this.addressData = new AddressData(scanner);
    }

    public void read(ResultSet result) throws SQLException {
        this.name = result.getString("name");
        this.email = result.getString("email");
        this.password = result.getString("password");
        this.cnp = result.getString("cnp");
        this.phone = result.getString("phone");
        this.birthDate = result.getDate("birthDate");
        this.addressData = new AddressData(result);
    }

    public List<GameData> filterGames(List<GameData> allGames) {
        var games = new ArrayList<GameData>();
        for (var game : allGames)
            if (game.getDeveloperId() == this.getDeveloperId())
                games.add(game);
        return games;
    }

    /*
    public void addGame(String gameName, String genre, String price, String downloads, String averageCompletionTime, String description) {
        GameData newGame = gameFactory.addGame(this.devId, gameName, this.name, genre, price, downloads, averageCompletionTime, description);
        games.add(newGame);
    }
    */

    @Override
    public String toString() {
        return "{" + "\n" + " devId=" + devId + "'," + "\n" + " name='" + name + "'," + "\n" + " email='" + email + "'," + "\n" + " password='" + password + "'," + "\n" + " cnp='" + cnp + "'," + "\n" + " phone='" + phone + "'," + "\n" + " birthDate=" + (new SimpleDateFormat("yyyy-MM-dd")).format(birthDate) + "," + "\n" + " address=" + addressData.toString() + "}";
    }

    public String toCSV() {
        return devId + "," + "\n" + name + "," + "\n" + email + "," + "\n" + password + "," + "\n" + cnp + "," + "\n" + phone + "," + "\n" + (new SimpleDateFormat("yyyy-MM-dd")).format(birthDate) + "," + "\n" + addressData.toCSV();
    }

    public int getDeveloperId() {
        return devId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCNP() {
        return cnp;
    }

    public String getPhone() {
        return phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public AddressData getAddress() {
        return addressData;
    }

    /*
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCNP(String cnp) {
        this.cnp = cnp;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(AddressData addressData) {
        this.addressData = addressData;
    }
    */
}
