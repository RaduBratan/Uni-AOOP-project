package Entities;

import java.util.Scanner;

public class ReviewData {

    private final int reviewId, userId, gameId;
    private String text;

    public ReviewData(int reviewId, int userId, int gameId, String text) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.gameId = gameId;
        this.text = text;
    }

    public void read(Scanner in) {
        System.out.println("Recenzia ta: ");
        this.text = in.nextLine();
    }

    /*
    @Override
    public String toString() {
        return "{" +
                "\n" +
                " reviewId='" + reviewId + "', " +
                "\n" +
                " userId='" + userId + "', " +
                "\n" +
                " gameId='" + gameId + "', " +
                "\n" +
                " reviewText=" + reviewText +
                "\n" +
                "}";
    }

    public String toCSV() {
        return reviewId + "," +
                "\n" + userId + "," +
                "\n" + gameId + "," +
                "\n" + reviewText;
    }
    */

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
