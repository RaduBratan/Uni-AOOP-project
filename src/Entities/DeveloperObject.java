package Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DeveloperObject {
    private static DeveloperObject instance = null;
    final private DeveloperFactory factory = new DeveloperFactory();
    private List<DeveloperData> developers = new ArrayList<DeveloperData>();

    public static DeveloperObject getInstance() {
        if (instance == null)
            instance = new DeveloperObject();
        return instance;
    }

    public List<DeveloperData> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<DeveloperData> developers) {
        this.developers = developers;
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
            System.out.println("Nu există dezvoltatori");
        }
        return columns;
    }

    public void readFromCSV() {
        try {
            var columns = DeveloperObject.getCSVColumns("data/developers.csv");
            for (var fields : columns) {
                var newDeveloper = new DeveloperData(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        fields[2],
                        fields[3],
                        fields[4],
                        fields[5],
                        new SimpleDateFormat("yyyy-mm-dd").parse(fields[6]),
                        new AddressData(fields[7], fields[8], fields[9], fields[10], Integer.parseInt(fields[11]))
                );
                developers.add(newDeveloper);
            }
            DeveloperFactory.incrementUniqueId(columns.size());
        } catch (ParseException e) {
            System.out.println(e);
        }
    }

    public void writeToCSV() {
        try {
            var writer = new FileWriter("data/developers.csv");
            for (var developer : this.developers) {
                writer.write(developer.toCSV());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
