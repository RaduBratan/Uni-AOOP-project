package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;

public class UserFactory {
    private static int uniqueUserId = 0;

    public static void incrementUniqueId(int i) {
        UserFactory.uniqueUserId += i;
    }

    public UserData createUser(Scanner scanner) throws ParseException {
        return new UserData(uniqueUserId++, scanner);
    }

    public UserData createUser(ResultSet result) throws SQLException {
        return new UserData(uniqueUserId++, result);
    }
}
