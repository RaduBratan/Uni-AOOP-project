package Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    Connection connection;

    UserFactory userFactory = new UserFactory();

    public UserDatabase(Connection connection) {
        this.connection = connection;
    }

    public List<UserData> read() {
        List<UserData> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM Users");
            while (result.next()) {
                UserData current = userFactory.createUser(result);
                users.add(current);
            }
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return users;
    }

    public void update(UserData user) {
        try {
            String query = "UPDATE Users SET name = ?, email = ?, password = ?, phone = ?, birthDate = ? WHERE userId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getPhone());
            statement.setString(5, (new SimpleDateFormat("yyyy-MM-dd")).format(user.getBirthDate()));
            statement.setInt(6, user.getUserId());
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void create(UserData user) {
        try {
            String query = "INSERT INTO Users (userId, name, email, password, phone, birthDate) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, user.getUserId());
            statement.setString(2, user.getName());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getPhone());
            statement.setString(6, (new SimpleDateFormat("yyyy-MM-dd")).format(user.getBirthDate()));
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(UserData user) {
        try {
            String query = "DELETE FROM Users WHERE userId = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, user.getUserId());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
