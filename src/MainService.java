import Entities.*;

import java.text.ParseException;
import java.util.*;

public class MainService {

    // values, setters and getters

    private List<DeveloperData> developers = new ArrayList<>();
    private List<UserData> users = new ArrayList<>();
    private List<GameData> games = new ArrayList<>();

    private final Map<String, GameData> gamesMap = new HashMap<>();
    private final DeveloperFactory developerFactory = new DeveloperFactory();
    private final UserFactory userFactory = new UserFactory();
    private final GameFactory gameFactory = new GameFactory();

    public List<DeveloperData> getDevelopers() {
        return developers;
    }

    public List<UserData> getUsers() {
        return users;
    }

    public List<GameData> getGames() {
        return games;
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

    // functions included in MainService

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
        return users.get(userId);
    }

    public void showUser(Scanner in) throws Exception {
        var user = this.getUser(in);
        System.out.println(user.toString());
    }

    public void addGame(Scanner in) { }

    public void addReview(Scanner in) { }

    public void showGames(Scanner in) { }

    public void showReviews(Scanner in) { }

    public void removeGame(Scanner in) { }

    public void removeReview(Scanner in) { }
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