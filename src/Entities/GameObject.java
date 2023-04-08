package Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GameObject {
    private static GameObject instance = null;
    final private GameFactory factory = new GameFactory();
    private List<GameData> games = new ArrayList<GameData>();

    public static GameObject getInstance() {
        if (instance == null)
            instance = new GameObject();
        return instance;
    }

    public List<GameData> getGames() {
        return games;
    }

    public void setGames(List<GameData> games) {
        this.games = games;
    }

    private static List<String[]> getCSVColumns(String fileName) {
        List<String[]> columns = new ArrayList<>();
        try (var in = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] fields = line.replaceAll(" ", "").split(",");
                columns.add(fields);
            }
        } catch (IOException e) {
            System.out.println("Nu există jocuri");
        }
        return columns;
    }

    public void readFromCSV() {
        var columns = GameObject.getCSVColumns("data/games.csv");
        for (var fields : columns) {
            var newGame = new GameData(
                    Integer.parseInt(fields[0]),
                    Integer.parseInt(fields[1]),
                    fields[2],
                    fields[3],
                    fields[4],
                    fields[5],
                    fields[6],
                    fields[7],
                    fields[8]
            );
            games.add(newGame);
        }
        GameFactory.incrementUniqueId(columns.size());
    }

    public void writeToCSV() {
        try {
            var writer = new FileWriter("data/games.csv");
            for (var game : this.games) {
                writer.write(game.toCSV());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
