import java.util.*;

public class Main {

    static List<String> commandNumbers = Arrays.asList(
            "1",
            // "create_developer_account",
            "2",
            // "create_user_account",
            "3",
            // "show_developer_account",
            "4",
            // "show_user_account",
            "5",
            // "add_game_to_dev",
            "6",
            // "add_review_to_game",
            "7",
            // "show_all_games_of_dev",
            "8",
            // "show_all_reviews_of_game",
            "9",
            // "remove_offensive_game_of_dev",
            "10",
            // "remove_offensive_review_of_game",
            "11",
            // "commands",
            "12"
            // "finish"
    );
    static List<String> commandDescriptions = Arrays.asList(
            "Creează un cont pentru un dezvoltator",
            "Creează un cont pentru un utilizator",
            "Vizionează contul unui dezvoltator",
            "Vizionează contul unui utilizator",
            "Adaugă un joc al unui dezvoltator",
            "Adaugă o recenzie a unui utilizator",
            "Arată toate jocurile unui dezvoltator",
            "Arată toate recenziile unui utilizator",
            "Elimină un joc ofensiv",
            "Elimină o recenzie ofensivă",
            "Afișează toate comenzile",
            "Închide aplicația"
    );

    private static void showAllCommands() {
        for (int i = 0; i < commandNumbers.size(); ++i)
            System.out.println((i + 1) + ". " + commandDescriptions.get(i) + " (" + commandNumbers.get(i) + ")");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean end = false;

        while (!end) {
            System.out.println("Tastează o comandă (6 = listă comenzi)");
            String command = in.nextLine().toLowerCase(Locale.ROOT);
            try {
                switch (command) {
                    case "1":
                    // case "create_developer_account":
                        new MainService().createDeveloper(in);
                    case "2":
                    // case "create_user_account":
                        new MainService().createUser(in);
                    case "3":
                    // case "show_developer_account":
                        new MainService().showDeveloper(in);
                    case "4":
                    // case "show_user_account":
                        new MainService().showUser(in);
                    case "5":
                    // case "add_game_to_dev":
                        new MainService().addGame(in);
                    case "6":
                    // case "add_review_to_game":
                        new MainService().addReview(in);
                    case "7":
                    // case "show_all_games_of_dev":
                        new MainService().showGames(in);
                    case "8":
                    // case "show_all_reviews_of_game":
                        new MainService().showReviews(in);
                    case "9":
                    // case "remove_offensive_game_of_dev":
                        new MainService().removeGame(in);
                    case "10":
                    // case "remove_offensive_review_of_game":
                        new MainService().removeReview(in);
                    case "11":
                    // case "commands":
                        Main.showAllCommands();
                    case "12":
                    // case "finish":
                        end = true;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}
