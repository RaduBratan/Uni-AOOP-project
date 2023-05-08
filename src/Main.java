import Entities.DeveloperDatabase;
import Entities.UserDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static List<String> commandNumbers = Arrays.asList(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12"
    );

    static List<String> commandDescriptions = Arrays.asList(
            "Creează un cont pentru un dezvoltator",
            "Creează un cont pentru un utilizator",
            "Vizionează contul unui dezvoltator",
            "Vizionează contul unui utilizator",
            "Adaugă un joc al unui dezvoltator",
            "Adaugă o recenzie a unui utilizator",
            "Găsește un joc al unui dezvoltator",
            "Găsește o recenzie a unui utilizator",
            "Elimină un joc ofensiv",
            "Elimină o recenzie ofensivă",
            "Afișează toate comenzile",
            "Închide aplicația"
    );

    private static void showAllCommands() {
        for (int i = 0; i < commandNumbers.size(); ++i)
            System.out.println((i + 1) + ". " + commandDescriptions.get(i));
    }

    public static Connection getConnection() {
        try {
            String url = "";
            String user = "";
            String password = "";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean finish = false;
        var connection = getConnection();
        var developerDatabase = new DeveloperDatabase(connection);
        var userDatabase = new UserDatabase(connection);
        var gameDatabase = new GameDatabase(connection);
        var reviewDatabase = new ReviewDatabase(connection);

        MainService mainService = new MainService(developerDatabase, userDatabase, gameDatabase, reviewDatabase);
        CSVService csvService = new CSVService();

        while (!finish) {
            System.out.println("\nTastează o comandă (11 = listă comenzi)");
            String cmd = in.nextLine().toLowerCase(Locale.ROOT);
            try {
                switch (cmd) {
                    case "1" -> mainService.createDeveloper(in);
                    case "2" -> mainService.createUser(in);
                    case "3" -> mainService.showDeveloper(in);
                    case "4" -> mainService.showUser(in);
                    case "5" -> mainService.addGame(in);
                    case "6" -> mainService.addReview(in);
                    case "7" -> mainService.showGame(in);
                    case "8" -> mainService.showReview(in);
                    case "9" -> mainService.removeGame(in);
                    case "10" -> mainService.removeReview(in);
                    case "11" -> showAllCommands();
                    case "12" -> finish = true;
                }
                if (commandNumbers.contains(cmd))
                    csvService.logAction(cmd);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
