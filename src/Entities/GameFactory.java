package Entities;

import java.text.ParseException;
import java.util.Scanner;

public class GameFactory {
    private static int uniqueGameId = 0;

    public static void incrementUniqueId(int i) {
        GameFactory.uniqueGameId += i;
    }

    /*
    public GameData addGame(int uniqueDevId, Scanner in) throws ParseException {
        return new GameData(uniqueGameId++, uniqueDevId, in);
    }

    public GameData addGame(int uniqueDevId, ResultSet in) throws SQLException {
        return new GameData(uniqueGameId++, uniqueDevId, in);
    }
    */

    public GameData addGame(int uniqueDevId, String gameName, String devName, String genre, String price, String downloads, String averageCompletionTime, String description) {
        return new GameData(uniqueGameId++, uniqueDevId, gameName, devName, genre, price, downloads, averageCompletionTime, description);
    }
}
