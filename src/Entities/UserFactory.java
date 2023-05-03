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

    public UserData createUser(Scanner in) throws ParseException {
        return new UserData(uniqueUserId++, in);
    }

    public UserData createUser(ResultSet in) throws SQLException {
        return new UserData(uniqueUserId++, in);
    }
}
