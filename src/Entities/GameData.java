package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class GameData {

    private final int gameId, devId;
    private String gameName, devName, genre, price, downloads, averageCompletionTime, description;

    public GameData(int gameId, int devId, String gameName, String devName, String genre, String price, String downloads, String averageCompletionTime, String description) {
        this.gameId = gameId;
        this.devId = devId;
        this.gameName = gameName;
        this.devName = devName;
        this.genre = genre;
        this.price = price;
        this.downloads = downloads;
        this.averageCompletionTime = averageCompletionTime;
        this.description = description;
    }

    /*
    public GameData(int gameId, int devId, Scanner in) throws ParseException {
        this.gameId = gameId;
        this.devId = devId;
        this.read(in);
    }

    public GameData(int gameId, int devId, ResultSet in) throws SQLException {
        this.gameId = gameId;
        this.devId = devId;
        this.read(in);
    }
    */

    public void read(Scanner in) throws ParseException {
        System.out.println("Numele jocului: ");
        this.gameName = in.nextLine();
        System.out.println("Numele dezvoltatorului: ");
        this.devName = in.nextLine();
        System.out.println("Genul jocului: ");
        this.genre = in.nextLine();
        System.out.println("Prețul jocului: ");
        this.price = in.nextLine();
        System.out.println("Numărul de descărcări: ");
        this.downloads = in.nextLine();
        System.out.println("Timpul mediu de completare: ");
        this.averageCompletionTime = in.nextLine();
        System.out.println("Scurtă descriere: ");
        this.description = in.nextLine();
    }

    /*
    public void read(ResultSet in) throws SQLException {
        this.gameName = in.getString("gameName");
        this.devName = in.getString("devName");
        this.genre = in.getString("genre");
        this.price = in.getString("price");
        this.downloads = in.getString("downloads");
        this.averageCompletionTime = in.getString("averageCompletionTime");
        this.description = in.getString("description");
    }

    @Override
    public String toString() {
        return "{" +
                "\n" +
                " gameId='" + gameId + "', " +
                "\n" +
                " devId='" + devId + "', " +
                "\n" +
                " gameName='" + gameName + "', " +
                "\n" +
                " devName='" + devName + "', " +
                "\n" +
                " genre='" + genre + "', " +
                "\n" +
                " price='" + price + "', " +
                "\n" +
                " downloads=" + downloads +
                "\n" +
                " averageCompletionTime=" + averageCompletionTime +
                "\n" +
                " description=" + description +
                "\n" +
                "}";
    }

    public String toCSV() {
        return gameId + "," +
                "\n" + devId + "," +
                "\n" + gameName + "," +
                "\n" + devName + "," +
                "\n" + genre + "," +
                "\n" + price + "," +
                "\n" + downloads + "," +
                "\n" + averageCompletionTime + "," +
                "\n" + description;
    }
    */

    public int getGameId() {
        return gameId;
    }

    public int getDeveloperId() {
        return devId;
    }

    public String getGameName() {
        return gameName;
    }

    public String getDeveloperName() {
        return devName;
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
