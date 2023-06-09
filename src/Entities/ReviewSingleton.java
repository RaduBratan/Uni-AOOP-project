package Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReviewSingleton {
    private static ReviewSingleton instance = null;
    final private ReviewFactory factory = new ReviewFactory();
    private List<ReviewData> reviews = new ArrayList<>();

    public static ReviewSingleton getInstance() {
        if (instance == null)
            instance = new ReviewSingleton();
        return instance;
    }

    /*
    public List<ReviewData> getReviews() {
        return reviews;
    }

    public void setReviews(List<ReviewData> reviews) {
        this.reviews = reviews;
    }
    */

    private static List<String[]> getCSVColumns(String fileName) {
        List<String[]> columns = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.replaceAll(" ", "").split(",");
                columns.add(fields);
            }
        } catch (IOException e) {
            System.out.println("Nu există recenzii");
        }
        return columns;
    }

    public void readFromCSV() {
        var columns = ReviewSingleton.getCSVColumns("data/reviews.csv");
        for (var fields : columns) {
            var newReview = new ReviewData(
                    Integer.parseInt(fields[0]),
                    Integer.parseInt(fields[1]),
                    Integer.parseInt(fields[2]),
                    fields[3]
            );
            reviews.add(newReview);
        }
        ReviewFactory.incrementUniqueId(columns.size());
    }

    public void writeToCSV() {
        try {
            var writer = new FileWriter("data/reviews.csv");
            for (var review : this.reviews) {
                writer.write(review.toCSV());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}