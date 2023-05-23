package Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewDatabase {
    Connection connection;

    ReviewFactory reviewFactory = new ReviewFactory();

    public ReviewDatabase(Connection connection) {
        this.connection = connection;
    }

    public List<ReviewData> read() {
        List<ReviewData> reviews = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Reviews");
            while (result.next()) {
                ReviewData current = reviewFactory.addReview(result);
                reviews.add(current);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return reviews;
    }

    public void update(ReviewData review) {
        try {
            String query = "UPDATE Reviews SET text = ? WHERE reviewId = ? AND userId = ? AND gameId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, review.getText());
            statement.setInt(2, review.getReviewId());
            statement.setInt(3, review.getUserId());
            statement.setInt(4, review.getGameId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void create(ReviewData review) {
        try {
            String query = "INSERT INTO Reviews (reviewId, userId, gameId, text) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, review.getReviewId());
            statement.setInt(2, review.getUserId());
            statement.setInt(3, review.getGameId());
            statement.setString(4, review.getText());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(ReviewData review) {
        try {
            String query = "DELETE FROM Reviews WHERE gameId = ? AND userId = ? AND reviewId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, review.getReviewId());
            statement.setInt(2, review.getUserId());
            statement.setInt(3, review.getGameId());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}