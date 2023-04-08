package Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class UserData {

    private final int userId;
    private String name, email, password, phone;
    private Date birthDate;
    protected List<ReviewData> reviews = new ArrayList<>();
    private final ReviewFactory reviewFactory = new ReviewFactory();

    public UserData(int userId, String name, String email, String password, String phone, Date birthDate) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birthDate = birthDate;
    }

    public UserData(int userId, Scanner in) throws ParseException {
        this.userId = userId;
        this.read(in);
    }

    public void read(Scanner in) throws ParseException {
        System.out.println("Numele: ");
        this.name = in.nextLine();
        System.out.println("Adresa de e-mail: ");
        this.email = in.nextLine();
        System.out.println("Parola: ");
        this.password = in.nextLine();
        System.out.println("Numărul de telefon: ");
        this.phone = in.nextLine();
        System.out.println("Data de naștere (în formatul aaaa-ll-zz): ");
        this.birthDate = new SimpleDateFormat("yyyy-mm-dd").parse(in.nextLine());
    }

    public List<ReviewData> filterReviews(List<ReviewData> allReviews) {
        var reviews = new ArrayList<ReviewData>();
        for (var review : allReviews)
            if (review.getUserId() == this.getUserId())
                reviews.add(review);
        return reviews;
    }

    public void addReview(GameData gameData, String reviewText) {
        ReviewData newReview = reviewFactory.addReview(this.userId, gameData.getGameId(), reviewText);
        reviews.add(newReview);
    }

    @Override
    public String toString() {
        return "{" +
                "\n" +
                " userId=" + userId + "', " +
                "\n" +
                " name='" + name + "', " +
                "\n" +
                " email='" + email + "', " +
                "\n" +
                " password='" + password + "', " +
                "\n" +
                " phone='" + phone + "', " +
                "\n" +
                " birthDate=" + (new SimpleDateFormat("yyyy-mm-dd")).format(birthDate) + ", " +
                "\n" +
                "}";
    }

    public String toCSV() {
        return userId + "," +
                "\n" + name + "," +
                "\n" + email + "," +
                "\n" + password + "," +
                "\n" + phone + "," +
                "\n" + (new SimpleDateFormat("yyyy-mm-dd")).format(birthDate);
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
