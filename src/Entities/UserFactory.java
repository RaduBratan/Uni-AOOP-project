package Entities;

import java.text.ParseException;
import java.util.Scanner;

public class UserFactory {
    private static int uniqueId = 0;

    public static void incrementUniqueId(int i) {
        UserFactory.uniqueId += i;
    }

    public UserData createUserData(Scanner in) throws ParseException {
        return new UserData(uniqueId++, in);
    }
}
