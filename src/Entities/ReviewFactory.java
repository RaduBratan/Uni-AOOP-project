package Entities;

public class ReviewFactory {
    private static int uniqueReviewId = 0;

    public ReviewData addReview(int uniqueUserId, int uniqueGameId, String reviewText){
        return new ReviewData(uniqueReviewId++, uniqueUserId, uniqueGameId, reviewText);
    }
}
