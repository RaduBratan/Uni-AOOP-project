import Entities.*;

import java.text.ParseException;
import java.util.*;

public class MainService {

    // ------------ values, setters and getters

    private List<DeveloperData> developers = new ArrayList<>();
    private List<UserData> users = new ArrayList<>();
    private List<GameData> games = new ArrayList<>();
    private List<ReviewData> reviews = new ArrayList<>();

    // private final Map<String, GameData> gamesMap = new HashMap<>();
    private final DeveloperFactory developerFactory = new DeveloperFactory();
    private final UserFactory userFactory = new UserFactory();
    private final GameFactory gameFactory = new GameFactory();
    private final ReviewFactory reviewFactory = new ReviewFactory();

    public List<DeveloperData> getDevelopers() {
        return developers;
    }

    public List<UserData> getUsers() {
        return users;
    }

    public List<GameData> getGames() {
        return games;
    }

    public List<ReviewData> getReviews() {
        return reviews;
    }

    public void setDevelopers(List<DeveloperData> developers) {
        this.developers = developers;
    }

    public void setUsers(List<UserData> users) {
        this.users = users;
    }

    public void setGames(List<GameData> games) {
        this.games = games;
    }

    public void setReviews(List<ReviewData> reviews) {
        this.reviews = reviews;
    }

    // ------------ functions included in Main

    public void createDeveloper(Scanner in) throws ParseException {
        DeveloperData newDeveloper = developerFactory.createDeveloper(in);
        this.developers.add(newDeveloper);
        System.out.println("Contul de dezvoltator a fost creat");
    }

    private DeveloperData getDeveloper(Scanner in) throws Exception {
        if (this.developers.size() == 0)
            throw new Exception("Nu există dezvoltatori");
        if (this.developers.size() == 1)
            return developers.get(0);
        System.out.println("ID-ul dezvoltatorului între 0 și " + (this.developers.size() - 1) + ": ");
        int developerId = Integer.parseInt(in.nextLine());
        if (developerId > this.developers.size())
            throw new Exception("Nu există dezvoltatorul cu acest ID");
        return developers.get(developerId);
    }

    public void showDeveloper(Scanner in) throws Exception {
        var developer = this.getDeveloper(in);
        System.out.println(developer.toString());
    }

    public void createUser(Scanner in) throws ParseException {
        UserData newUser = userFactory.createUser(in);
        this.users.add(newUser);
        System.out.println("Contul de utilizator a fost creat");
    }

    private UserData getUser(Scanner in) throws Exception {
        if (this.users.size() == 0)
            throw new Exception("Nu există utilizatori");
        if (this.users.size() == 1)
            return users.get(0);
        System.out.println("ID-ul utilizatorului între 0 și " + (this.users.size() - 1) + ": ");
        int userId = Integer.parseInt(in.nextLine());
        if (userId > this.users.size())
            throw new Exception("Nu există utilizatorul cu acest ID");
        return users.get(userId);
    }

    public void showUser(Scanner in) throws Exception {
        var user = this.getUser(in);
        System.out.println(user.toString());
    }

    public void addGame(Scanner in) throws Exception {
        var developer = this.getDeveloper(in);
        System.out.println("Numele jocului: ");
        String gameName = in.nextLine();
        System.out.println("Numele dezvoltatorului: ");
        String devName = in.nextLine();
        System.out.println("Genul jocului: ");
        String genre = in.nextLine();
        System.out.println("Prețul jocului: ");
        String price = in.nextLine();
        System.out.println("Numărul de descărcări: ");
        String downloads = in.nextLine();
        System.out.println("Timpul mediu de completare: ");
        String averageCompletionTime = in.nextLine();
        System.out.println("Scurtă descriere: ");
        String description = in.nextLine();
        GameData newGame = this.gameFactory.addGame(developer.getDeveloperId(), gameName, devName, genre, price, downloads, averageCompletionTime, description);
        games.add(newGame);
        System.out.println("Jocul a fost adăugat");
    }

    public void addReview(Scanner in) throws Exception {
        var user = this.getUser(in);
        var game = this.getGame(in);
        System.out.println("Recenzia ta: ");
        String reviewText = in.nextLine();
        ReviewData newReview = this.reviewFactory.addReview(user.getUserId(), game.getGameId(), reviewText);
        reviews.add(newReview);
        System.out.println("Recenzia a fost adăugată");
    }

    private GameData getGame(Scanner in) throws Exception {
        if (this.games.size() == 0)
            throw new Exception("Nu există jocuri");
        if (this.games.size() == 1)
            return games.get(0);
        System.out.println("ID-ul jocului între 0 și " + (this.games.size() - 1) + ": ");
        int gameId = Integer.parseInt(in.nextLine());
        if (gameId > this.games.size())
            throw new Exception("Nu există jocul cu acest ID");
        return games.get(gameId);
    }

    private ReviewData getReview(Scanner in) throws Exception {
        if (this.reviews.size() == 0)
            throw new Exception("Nu există recenzii");
        if (this.reviews.size() == 1)
            return reviews.get(0);
        System.out.println("ID-ul recenziei între 0 și " + (this.reviews.size() - 1) + ": ");
        int reviewId = Integer.parseInt(in.nextLine());
        if (reviewId > this.reviews.size())
            throw new Exception("Nu există recenzia cu acest ID");
        return reviews.get(reviewId);
    }

    public void showGame(Scanner in) throws Exception {
        var game = this.getGame(in);
        System.out.println(game.toString());
    }

    public void showReview(Scanner in) throws Exception {
        var review = this.getReview(in);
        System.out.println(review.toString());
    }

    public void removeGame(Scanner in) {
    }

    public void removeReview(Scanner in) {
    }
}

/*
    public void enterDeveloper(Scanner in) throws Exception {
        if (this.developers.size() == 0)
            throw new Exception("Nu există dezvoltatori");
        if (this.developers.size() == 1)
            return developers.get(0);
        System.out.println("ID-ul dezvoltatorului [0-" + (this.developers.size() - 1) + "]: ");
        int developerId = Integer.parseInt(in.nextLine());
        System.out.println("Parola dezvoltatorului:");
        String developerPassword = in.nextLine();
        if(new DeveloperData().comparePasswords(developerId, developerPassword))
            return developers.get(developerId);
    }
*/