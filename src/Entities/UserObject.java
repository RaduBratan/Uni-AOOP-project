package Entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserObject {
    private static UserObject instance = null;
    final private UserFactory factory = new UserFactory();
    private List<UserData> users = new ArrayList<UserData>();

    public static UserObject getInstance() {
        if (instance == null)
            instance = new UserObject();
        return instance;
    }

    public List<UserData> getUsers() {
        return users;
    }

    public void setUsers(List<UserData> users) {
        this.users = users;
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
            System.out.println("Nu există utilizatori");
        }
        return columns;
    }

    public void readFromCSV() {
        try {
            var columns = UserObject.getCSVColumns("data/users.csv");
            for (var fields : columns) {
                var newUser = new UserData(
                        Integer.parseInt(fields[0]),
                        fields[1],
                        fields[2],
                        fields[3],
                        fields[4],
                        new SimpleDateFormat("yyyy-mm-dd").parse(fields[5])
                );
                users.add(newUser);
            }
            UserFactory.incrementUniqueId(columns.size());
        } catch (ParseException e) {
            System.out.println(e);
        }
    }

    public void writeToCSV() {
        try {
            var writer = new FileWriter("data/users.csv");
            for (var user : this.users) {
                writer.write(user.toCSV());
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
