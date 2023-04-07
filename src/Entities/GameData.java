package Entities;

import java.util.*;

public class GameData {

    private final int gameId, devId;
    private String gameName, devName, genre, price, downloads, averageCompletionTime, description;
    protected List<ReviewData> reviews = new ArrayList<>();
    private final ReviewFactory reviewFactory = new ReviewFactory();

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

    public void read(Scanner in) {
        System.out.println("Game name: ");
        this.gameName = in.nextLine();
        System.out.println("Developer name: ");
        this.devName = in.nextLine();
        System.out.println("Genre: ");
        this.genre = in.nextLine();
        System.out.println("Price: ");
        this.price = in.nextLine();
        System.out.println("Downloads: ");
        this.downloads = in.nextLine();
        System.out.println("Average completion time: ");
        this.averageCompletionTime = in.nextLine();
        System.out.println("Short description: ");
        this.description = in.nextLine();
    }

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
