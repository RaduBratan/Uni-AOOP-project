package Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
            String query = "UPDATE Games SET name = ?, genre = ?, price = ?, downloads = ?, averageCompletionTime = ?, description = ? WHERE gameId = ? AND devId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, game.getName());
            statement.setString(2, game.getGenre());
            statement.setString(3, game.getPrice());
            statement.setString(4, game.getDownloads());
            statement.setString(5, game.getAverageCompletionTime());
            statement.setString(6, game.getDescription());
            statement.setInt(7, game.getGameId());
            statement.setInt(8, game.getDeveloperId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void create(GameData game) {
        try {
            String query = "INSERT INTO Games (gameId, devId, name, genre, price, downloads, averageCompletionTime, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, game.getGameId());
            statement.setInt(2, game.getDeveloperId());
            statement.setString(3, game.getName());
            statement.setString(4, game.getGenre());
            statement.setString(5, game.getPrice());
            statement.setString(6, game.getDownloads());
            statement.setString(7, game.getAverageCompletionTime());
            statement.setString(8, game.getDescription());
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