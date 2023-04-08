package Entities;

public class ReviewFactory {
    private static int uniqueReviewId = 0;

    public static void incrementUniqueId(int i) {
        ReviewFactory.uniqueReviewId += i;
    }

    public ReviewData addReview(int uniqueUserId, int uniqueGameId, String reviewText) {
        return new ReviewData(uniqueReviewId++, uniqueUserId, uniqueGameId, reviewText);
    }
}
