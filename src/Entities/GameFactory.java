package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class GameFactory {
    private static int uniqueGameId = 0;

    public static void incrementUniqueId(int i) {
        GameFactory.uniqueGameId += i;
    }

    public GameData addGame(Scanner scanner) throws ParseException {
        return new GameData(uniqueGameId++, scanner);
    }

    public GameData addGame(ResultSet result) throws SQLException {
        return new GameData(uniqueGameId++, result);
    }

    /*
    public GameData addGame(int uniqueDevId, Scanner scanner) throws ParseException {
        return new GameData(uniqueGameId++, uniqueDevId, scanner);
    }

    public GameData addGame(int uniqueDevId, ResultSet result) throws SQLException {
        return new GameData(uniqueGameId++, uniqueDevId, result);
    }
    */

    /*
    public GameData addGame(int uniqueDevId, String gameName, String devName, String genre, String price, String downloads, String averageCompletionTime, String description) {
        return new GameData(uniqueGameId++, uniqueDevId, gameName, devName, genre, price, downloads, averageCompletionTime, description);
    }
    */
}
