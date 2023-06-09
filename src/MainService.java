import Entities.*;

import java.text.ParseException;
import java.util.*;

public class MainService {

    // ------------ values, setters and getters
    private List<DeveloperData> developers = new ArrayList<>();
    private List<UserData> users = new ArrayList<>();
    private List<GameData> games = new ArrayList<>();
    private List<ReviewData> reviews = new ArrayList<>();

    private final Map<String, GameData> gamesMap = new HashMap<>(); // the string is for gameName
    private final Map<Integer, ReviewData> reviewsMap = new HashMap<>(); // the int is for reviewId

    private final DeveloperFactory developerFactory = new DeveloperFactory();
    private final UserFactory userFactory = new UserFactory();
    private final GameFactory gameFactory = new GameFactory();
    private final ReviewFactory reviewFactory = new ReviewFactory();

    private DeveloperDatabase developerDatabase = null;
    private UserDatabase userDatabase = null;
    private GameDatabase gameDatabase = null;
    private ReviewDatabase reviewDatabase = null;

    /*
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
    */

    public MainService(DeveloperDatabase developerDatabase, UserDatabase userDatabase, GameDatabase gameDatabase, ReviewDatabase reviewDatabase) {
        this.developerDatabase = developerDatabase;
        this.userDatabase = userDatabase;
        this.gameDatabase = gameDatabase;
        this.reviewDatabase = reviewDatabase;

        this.developers = developerDatabase.read();
        this.users = userDatabase.read();
        this.games = gameDatabase.read();
        this.reviews = reviewDatabase.read();
    }

    // ------------ functions included in Main for creating and getting developers
    public void createDeveloper(Scanner scanner) throws ParseException {
        DeveloperData newDeveloper = developerFactory.createDeveloper(scanner);
        this.developers.add(newDeveloper);
        // newDeveloper = developerFactory.createDeveloper(newDeveloper.getName(), newDeveloper.getEmail(), newDeveloper.getPassword(), newDeveloper.getCNP(), newDeveloper.getPhone(), newDeveloper.getBirthDate(), newDeveloper.getAddress());
        if (this.developerDatabase != null)
            this.developerDatabase.create(newDeveloper);
        System.out.println("Contul de dezvoltator a fost creat");
    }

    private DeveloperData getDeveloperFromId(Scanner scanner) throws Exception {
        if (this.developers.size() == 0)
            throw new Exception("Nu există dezvoltatori");
        if (this.developers.size() == 1)
            return developers.get(0);
        System.out.println("ID-ul dezvoltatorului între 0 și " + (this.developers.size() - 1) + ": ");
        int developerId = Integer.parseInt(scanner.nextLine());
        if (developerId > this.developers.size())
            throw new Exception("Nu există dezvoltatorul cu acest ID");
        return developers.get(developerId);
    }

    public void showDeveloper(Scanner scanner) throws Exception {
        var developer = this.getDeveloperFromId(scanner);
        System.out.println(developer.toString());
    }

    // ------------ functions included in Main for creating and getting users
    public void createUser(Scanner scanner) throws ParseException {
        UserData newUser = userFactory.createUser(scanner);
        this.users.add(newUser);
        if (this.userDatabase != null)
            this.userDatabase.create(newUser);
        System.out.println("Contul de utilizator a fost creat");
    }

    private UserData getUserFromId(Scanner scanner) throws Exception {
        if (this.users.size() == 0)
            throw new Exception("Nu există utilizatori");
        if (this.users.size() == 1)
            return users.get(0);
        System.out.println("ID-ul utilizatorului între 0 și " + (this.users.size() - 1) + ": ");
        int userId = Integer.parseInt(scanner.nextLine());
        if (userId > this.users.size())
            throw new Exception("Nu există utilizatorul cu acest ID");
        return users.get(userId);
    }

    public void showUser(Scanner scanner) throws Exception {
        var user = this.getUserFromId(scanner);
        System.out.println(user.toString());
    }

    // ------------ functions included in Main for creating, getting and removing games
    public void addGame(Scanner scanner) throws Exception {
        /*
        System.out.println("Numele jocului: ");
        String gameName = scanner.nextLine();
        System.out.println("Numele dezvoltatorului: ");
        String devName = scanner.nextLine();
        System.out.println("Genul jocului: ");
        String genre = scanner.nextLine();
        System.out.println("Prețul jocului: ");
        String price = scanner.nextLine();
        System.out.println("Numărul de descărcări: ");
        String downloads = scanner.nextLine();
        System.out.println("Timpul mediu de completare: ");
        String averageCompletionTime = scanner.nextLine();
        System.out.println("Scurtă descriere: ");
        String description = scanner.nextLine();
        GameData newGame = this.gameFactory.addGame(developer.getDeveloperId(), gameName, devName, genre, price, downloads, averageCompletionTime, description);
        */
        GameData newGame = gameFactory.addGame(scanner);
        this.games.add(newGame);
        if (this.gameDatabase != null)
            this.gameDatabase.create(newGame);
        System.out.println("Jocul a fost adăugat");
    }

    private GameData getGameFromId(Scanner scanner) throws Exception {
        if (this.games.size() == 0)
            throw new Exception("Nu există jocuri");
        if (this.games.size() == 1)
            return games.get(0);
        System.out.println("ID-ul jocului între 0 și " + (this.games.size() - 1) + ": ");
        int gameId = Integer.parseInt(scanner.nextLine());
        if (gameId > this.games.size())
            throw new Exception("Nu există jocul cu acest ID");
        return games.get(gameId);
    }

    public void showGame(Scanner scanner) throws Exception {
        var game = this.getGameFromId(scanner);
        System.out.println(game.toString());
    }

    private GameData getGameFromDev(Scanner scanner, DeveloperData developer) throws Exception {
        List<GameData> devGames = developer.filterGames(this.games);
        System.out.println("Jocurile dezvoltatorului: " + devGames);
        System.out.println("Alege numele jocului: ");
        var gameName = scanner.nextLine();
        if (!this.gamesMap.containsKey(gameName))
            throw new Exception("Acesta nu este un nume valid");
        var game = gamesMap.get(gameName);
        if (game.getDeveloperId() != developer.getDeveloperId())
            throw new Exception("Acest joc nu a fost creat de acest dezvoltator");
        return game;
    }

    public void removeGame(Scanner scanner) throws Exception {
        var developer = this.getDeveloperFromId(scanner);
        var game = this.getGameFromDev(scanner, developer);
        if (developer.filterGames(this.games).size() <= 1)
            throw new Exception("Acest dezvoltator nu are jocuri");
        this.gamesMap.remove(game.getName());
        this.games.remove(game);
        if (this.gameDatabase != null)
            this.gameDatabase.delete(game);
        System.out.println("Jocul ofensiv a fost eliminat");
    }

    // ------------ functions included in Main for creating, getting and removing reviews
    public void addReview(Scanner scanner) throws Exception {
        /*
        var user = this.getUserFromId(scanner);
        var game = this.getGameFromId(scanner);
        System.out.println("Recenzia ta: ");
        String reviewText = scanner.nextLine();
        ReviewData newReview = this.reviewFactory.addReview(user.getUserId(), game.getGameId(), reviewText);
        */
        ReviewData newReview = this.reviewFactory.addReview(scanner);
        this.reviews.add(newReview);
        if (this.reviewDatabase != null)
            this.reviewDatabase.create(newReview);
        System.out.println("Recenzia a fost adăugată");
    }

    private ReviewData getReviewFromId(Scanner scanner) throws Exception {
        if (this.reviews.size() == 0)
            throw new Exception("Nu există recenzii");
        if (this.reviews.size() == 1)
            return reviews.get(0);
        System.out.println("ID-ul recenziei între 0 și " + (this.reviews.size() - 1) + ": ");
        int reviewId = Integer.parseInt(scanner.nextLine());
        if (reviewId > this.reviews.size())
            throw new Exception("Nu există recenzia cu acest ID");
        return reviews.get(reviewId);
    }

    public void showReview(Scanner scanner) throws Exception {
        var review = this.getReviewFromId(scanner);
        System.out.println(review.toString());
    }

    private ReviewData getReviewFromUser(Scanner scanner, UserData user) throws Exception {
        List<ReviewData> devReviews = user.filterReviews(this.reviews);
        System.out.println("Recenziile utilizatorului: " + devReviews);
        System.out.println("Alege ID-ul recenziei: ");
        var reviewId = Integer.parseInt(scanner.nextLine());
        if (!this.reviewsMap.containsKey(reviewId))
            throw new Exception("Acesta nu este o recenzie validă");
        var review = reviewsMap.get(reviewId);
        if (review.getUserId() != user.getUserId())
            throw new Exception("Această recenzie nu a fost creată de acest utilizator");
        return review;
    }

    public void removeReview(Scanner scanner) throws Exception {
        var user = this.getUserFromId(scanner);
        var review = this.getReviewFromUser(scanner, user);
        if (user.filterReviews(this.reviews).size() <= 1)
            throw new Exception("Acest utilizator nu are recenzii");
        this.reviewsMap.remove(review.getReviewId());
        this.reviews.remove(review);
        if (this.reviewDatabase != null)
            this.reviewDatabase.delete(review);
        System.out.println("Recenzia ofensivă a fost eliminată");
    }
}