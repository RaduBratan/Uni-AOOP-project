package Entities;

import java.text.ParseException;

public class GameFactory {
    private static int uniqueGameId = 0;
    // private static int uniqueDevId = Entities.DeveloperFactory.uniqueDevId;

    public static void incrementUniqueId(int i) {
        GameFactory.uniqueGameId += i;
    }

    public GameData addGame(int uniqueDevId, String gameName, String devName, String genre, String price, String downloads, String averageCompletionTime, String description) {
        return new GameData(uniqueGameId++, uniqueDevId, gameName, devName, genre, price, downloads, averageCompletionTime, description);
    }
}
