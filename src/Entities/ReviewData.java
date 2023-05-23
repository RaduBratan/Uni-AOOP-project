package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class ReviewData {

    private final int reviewId;
    private int userId, gameId;
    private String text;

    public ReviewData(int reviewId, int userId, int gameId, String text) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.gameId = gameId;
        this.text = text;
    }

    public ReviewData(int reviewId, Scanner scanner) throws ParseException {
        this.reviewId = reviewId;
        this.read(scanner);
    }

    public ReviewData(int reviewId, ResultSet result) throws SQLException {
        this.reviewId = reviewId;
        this.read(result);
    }

    public void read(Scanner scanner) throws ParseException {
        System.out.println("ID-ul utilizatorului: ");
        this.userId = Integer.parseInt(scanner.nextLine());
        System.out.println("ID-ul jocului: ");
        this.gameId = Integer.parseInt(scanner.nextLine());
        System.out.println("Recenzia ta: ");
        this.text = scanner.nextLine();
    }

    public void read(ResultSet result) throws SQLException {
        this.userId = result.getInt("userId");
        this.gameId = result.getInt("gameId");
        this.text = result.getString("text");
    }

    @Override
    public String toString() {
        return "{" + "\n" + " reviewId='" + reviewId + "', " + "\n" + " userId='" + userId + "', " + "\n" + " gameId='" + gameId + "', " + "\n" + " text=" + text + "\n" + "}";
    }

    public String toCSV() {
        return reviewId + "," + "\n" + userId + "," + "\n" + gameId + "," + "\n" + text;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getUserId() {
        return userId;
    }

    public int getGameId() {
        return gameId;
    }

    public String getText() {
        return text;
    }
}
