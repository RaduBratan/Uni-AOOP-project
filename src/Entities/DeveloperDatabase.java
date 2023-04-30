package Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDatabase {
    Connection connection;

    public DeveloperDatabase(Connection connection) {
        this.connection = connection;
    }

    public List<DeveloperData> read() {
        List<DeveloperData> developers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Developers");
            while (result.next()) {
                DeveloperData current = new DeveloperData(result);
                developers.add(current);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return developers;
    }
}
