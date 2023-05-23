package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class GameData {

    private final int gameId;
    private int devId;
    private String name, genre, price, downloads, averageCompletionTime, description;

    public GameData(int gameId, int devId, String name, String genre, String price, String downloads, String averageCompletionTime, String description) {
        this.gameId = gameId;
        this.devId = devId;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.downloads = downloads;
        this.averageCompletionTime = averageCompletionTime;
        this.description = description;
    }

    public GameData(int gameId, Scanner scanner) throws ParseException {
        this.gameId = gameId;
        this.read(scanner);
    }

    public GameData(int gameId, ResultSet result) throws SQLException {
        this.gameId = gameId;
        this.read(result);
    }

    public void read(Scanner scanner) throws ParseException {
        System.out.println("ID-ul dezvoltatorului: ");
        this.devId = Integer.parseInt(scanner.nextLine());
        System.out.println("Numele jocului: ");
        this.name = scanner.nextLine();
        System.out.println("Genul jocului: ");
        this.genre = scanner.nextLine();
        System.out.println("Prețul jocului: ");
        this.price = scanner.nextLine();
        System.out.println("Numărul de descărcări: ");
        this.downloads = scanner.nextLine();
        System.out.println("Timpul mediu de completare: ");
        this.averageCompletionTime = scanner.nextLine();
        System.out.println("Scurtă descriere: ");
        this.description = scanner.nextLine();
    }

    public void read(ResultSet result) throws SQLException {
        this.devId = result.getInt("devId");
        this.name = result.getString("gameName");
        this.genre = result.getString("genre");
        this.price = result.getString("price");
        this.downloads = result.getString("downloads");
        this.averageCompletionTime = result.getString("averageCompletionTime");
        this.description = result.getString("description");
    }

    @Override
    public String toString() {
        return "{" + "\n" + " gameId='" + gameId + "', " + "\n" + " devId='" + devId + "', " + "\n" + " name='" + name + "', " + "\n" + " genre='" + genre + "', " + "\n" + " price='" + price + "', " + "\n" + " downloads=" + downloads + "\n" + " averageCompletionTime=" + averageCompletionTime + "\n" + " description=" + description + "\n" + "}";
    }

    public String toCSV() {
        return gameId + "," + "\n" + devId + "," + "\n" + name + "," + "\n" + genre + "," + "\n" + price + "," + "\n" + downloads + "," + "\n" + averageCompletionTime + "," + "\n" + description;
    }

    public int getGameId() {
        return gameId;
    }

    public int getDeveloperId() {
        return devId;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public String getPrice() {
        return price;
    }

    public String getDownloads() {
        return downloads;
    }

    public String getAverageCompletionTime() {
        return averageCompletionTime;
    }

    public String getDescription() {
        return description;
    }
}
