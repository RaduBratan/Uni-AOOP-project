package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
// import java.util.Date;
import java.util.Scanner;

public class DeveloperFactory {
    private static int uniqueDevId = 0;

    public static void incrementUniqueId(int i) {
        DeveloperFactory.uniqueDevId += i;
    }

    public DeveloperData createDeveloper(Scanner scanner) throws ParseException {
        return new DeveloperData(uniqueDevId++, scanner);
    }

    public DeveloperData createDeveloper(ResultSet result) throws SQLException {
        return new DeveloperData(uniqueDevId++, result);
    }

    /*
    public DeveloperData createDeveloper(String name, String email, String password, String cnp, String phone, Date birthDate, AddressData addressData) {
        return new DeveloperData(uniqueDevId++, name, email, password, cnp, phone, birthDate, addressData);
    }
    */
}
