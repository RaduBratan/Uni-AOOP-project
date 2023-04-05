package People.Developers;

import java.text.ParseException;
import java.util.Scanner;

public class DeveloperFactory {
    private static int uniqueId = 0;

    public static void incrementUniqueId(int i) {
        DeveloperFactory.uniqueId += i;
    }

    public DeveloperData createDeveloperData(Scanner in) throws ParseException {
        return new DeveloperData(uniqueId++, in);
    }
}
