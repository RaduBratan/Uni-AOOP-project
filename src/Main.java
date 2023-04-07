import Entities.DeveloperData;

import java.util.*;

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
    static List<String> commandTexts = Arrays.asList(
            "create_developer_account",
            "create_user_account",
            "show_developer_account",
            "show_user_account",
            "add_game_to_dev",
            "add_review_to_game",
            "show_game_of_dev",
            "show_review_of_game",
            "remove_offensive_game_of_dev",
            "remove_offensive_review_of_game",
            "commands",
            "finish"
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean end = false;

        while (!end) {
            System.out.println("\nTastează o comandă (11 = listă comenzi)");
            String command = in.nextLine().toLowerCase(Locale.ROOT);
            try {
                switch (command) {
                    case "1" -> new MainService().createDeveloper(in);
                    // case "create_developer_account":
                    case "2" -> new MainService().createUser(in);
                    // case "create_user_account":
                    case "3" -> new MainService().showDeveloper(in);
                    // case "show_developer_account":
                    case "4" -> new MainService().showUser(in);
                    // case "show_user_account":
                    case "5" -> new MainService().addGame(in);
                    // case "add_game_to_dev":
                    case "6" -> new MainService().addReview(in);
                    // case "add_review_to_game":
                    case "7" -> new MainService().showGame(in);
                    // case "show_all_games_of_dev":
                    case "8" -> new MainService().showReview(in);
                    // case "show_all_reviews_of_game":
                    case "9" -> new MainService().removeGame(in);
                    // case "remove_offensive_game_of_dev":
                    case "10" -> new MainService().removeReview(in);
                    // case "remove_offensive_review_of_game":
                    case "11" -> Main.showAllCommands();
                    // case "commands":
                    case "12" -> end = true;
                    // case "finish":
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
