package Entities;

import java.util.Scanner;

public class ReviewData {

    private final int reviewId, userId, gameId;
    private String reviewText;

    public ReviewData(int reviewId, int userId, int gameId, String reviewText) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.gameId = gameId;
        this.reviewText = reviewText;
    }

    public void read(Scanner in) {
        System.out.println("Recenzia ta: ");
        this.reviewText = in.nextLine();
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

    public String getReviewText() {
        return reviewText;
    }
}
