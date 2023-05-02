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

    public void update(DeveloperData newDeveloperData) {
        try {
            String query = "UPDATE Developers SET name = ?, email = ?, password = ?, cnp = ?, phone = ?, birthDate = ?, state = ?, county = ?, city = ?, street = ?, postalCode = ? WHERE customerId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, newDeveloperData.getName());
            statement.setString(2, newDeveloperData.getEmail());
            statement.setString(3, newDeveloperData.getPassword());
            statement.setString(4, newDeveloperData.getPhone());
            statement.setString(5, (new SimpleDateFormat("yyyy-MM-dd")).format(newDeveloperData.getBirthDate()));
            statement.setString(8, newDeveloperData.getAddress().getState());
            statement.setString(8, newDeveloperData.getAddress().getCounty());
            statement.setString(7, newDeveloperData.getAddress().getCity());
            statement.setString(6, newDeveloperData.getAddress().getStreet());
            statement.setInt(10, newDeveloperData.getAddress().getPostalCode());
            statement.setInt(11, newDeveloperData.getDeveloperId());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
