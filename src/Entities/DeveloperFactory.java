package Entities;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class DeveloperFactory {
    private static int uniqueDevId = 0;

    public static void incrementUniqueId(int i) {
        DeveloperFactory.uniqueDevId += i;
    }

    public DeveloperData createDeveloper(Scanner in) throws ParseException {
        return new DeveloperData(uniqueDevId++, in);
    }

    /*public DeveloperData createDeveloper(String name, String email, String password, String cnp, String phone, Date birthDate, AddressData addressData) {
        return new DeveloperData(uniqueDevId++, name, email, password, cnp, phone, birthDate, addressData);
    }*/
}
