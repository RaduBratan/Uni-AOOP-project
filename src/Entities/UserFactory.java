package Entities;

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
}
