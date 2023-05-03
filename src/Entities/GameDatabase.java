/*
package Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GameDatabase {
    Connection connection;

    GameFactory gameFactory = new GameFactory();

    public GameDatabase(Connection connection) {
        this.connection = connection;
    }

    public List<GameData> read() {
        List<GameData> games = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Games");
            while (result.next()) {
                GameData current = gameFactory.addGame(result);
                games.add(current);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return games;
    }

    public void update(GameData game) {
        try {
            String query = "UPDATE Games SET gameName = ?, devName = ?, genre = ?, price = ?, downloads = ?, averageCompletionTime = ?, description = ? WHERE gameId = ? AND devId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, game.getGameName());
            statement.setString(2, game.getDeveloperName());
            statement.setString(3, game.getGenre());
            statement.setString(4, game.getPrice());
            statement.setString(5, game.getDownloads());
            statement.setString(6, game.getAverageCompletionTime());
            statement.setString(7, game.getDescription());
            statement.setInt(8, game.getGameId());
            statement.setInt(9, game.getDeveloperId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void create(GameData game) {
        try {
            String query = "INSERT INTO Games (gameId, devId, gameName, devName, genre, price, downloads, averageCompletionTime, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, game.getGameId());
            statement.setInt(2, game.getDeveloperId());
            statement.setString(3, game.getGameName());
            statement.setString(4, game.getDeveloperName());
            statement.setString(5, game.getGenre());
            statement.setString(6, game.getPrice());
            statement.setString(7, game.getDownloads());
            statement.setString(8, game.getAverageCompletionTime());
            statement.setString(9, game.getDescription());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(GameData game) {
        try {
            String query = "DELETE FROM Games WHERE devId = ? AND gameId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, game.getGameId());
            statement.setInt(2, game.getDeveloperId());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
*/