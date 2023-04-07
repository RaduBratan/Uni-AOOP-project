package Entities;

public class GameFactory {
    private static int uniqueGameId = 0;

    public GameData addGame(int uniqueDevId, String gameName, String devName, String genre, String price, String downloads, String averageCompletionTime, String description){
        return new GameData(uniqueGameId++, uniqueDevId, gameName, devName, genre, price, downloads, averageCompletionTime, description);
    }
}
