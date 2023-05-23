package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class ReviewFactory {
    private static int uniqueReviewId = 0;

    public static void incrementUniqueId(int i) {
        ReviewFactory.uniqueReviewId += i;
    }

    public ReviewData addReview(Scanner scanner) throws ParseException {
        return new ReviewData(uniqueReviewId++, scanner);
    }

    public ReviewData addReview(ResultSet result) throws SQLException {
        return new ReviewData(uniqueReviewId++, result);
    }

    /*
    public ReviewData addReview(int uniqueUserId, int uniqueGameId, String text) {
        return new ReviewData(uniqueReviewId++, uniqueUserId, uniqueGameId, text);
    }
    */
}
