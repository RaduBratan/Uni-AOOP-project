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

    DeveloperFactory developerFactory = new DeveloperFactory();

    public DeveloperDatabase(Connection connection) {
        this.connection = connection;
    }

    public List<DeveloperData> read() {
        List<DeveloperData> developers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Developers");
            while (result.next()) {
                DeveloperData current = developerFactory.createDeveloper(result);
                developers.add(current);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return developers;
    }

    public void update(DeveloperData developer) {
        try {
            String query = "UPDATE Developers SET name = ?, email = ?, password = ?, cnp = ?, phone = ?, birthDate = ?, state = ?, county = ?, city = ?, street = ?, postalCode = ? WHERE devId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, developer.getName());
            statement.setString(2, developer.getEmail());
            statement.setString(3, developer.getPassword());
            statement.setString(4, developer.getCNP());
            statement.setString(5, developer.getPhone());
            statement.setString(6, (new SimpleDateFormat("yyyy-MM-dd")).format(developer.getBirthDate()));
            statement.setString(7, developer.getAddress().getState());
            statement.setString(8, developer.getAddress().getCounty());
            statement.setString(9, developer.getAddress().getCity());
            statement.setString(10, developer.getAddress().getStreet());
            statement.setInt(11, developer.getAddress().getPostalCode());
            statement.setInt(12, developer.getDeveloperId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void create(DeveloperData developer) {
        try {
            String query = "INSERT INTO Developers (devId, name, email, password, cnp, phone, birthDate, state, county, city, street, postalCode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, developer.getDeveloperId());
            statement.setString(2, developer.getName());
            statement.setString(3, developer.getEmail());
            statement.setString(4, developer.getPassword());
            statement.setString(5, developer.getCNP());
            statement.setString(6, developer.getPhone());
            statement.setString(7, (new SimpleDateFormat("yyyy-MM-dd")).format(developer.getBirthDate()));
            statement.setString(8, developer.getAddress().getState());
            statement.setString(9, developer.getAddress().getCounty());
            statement.setString(10, developer.getAddress().getCity());
            statement.setString(11, developer.getAddress().getStreet());
            statement.setInt(12, developer.getAddress().getPostalCode());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(DeveloperData developer) {
        try {
            String query = "DELETE FROM Developers WHERE devId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, developer.getDeveloperId());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
