package Entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddressData {

    private String state, county, city, street;
    private int postalCode;

    public AddressData(String state, String county, String city, String street, int postalCode) {
        this.state = state;
        this.county = county;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public AddressData(Scanner scanner) {
        this.read(scanner);
    }

    public AddressData(ResultSet result) throws SQLException {
        this.read(result);
    }

    public void read(Scanner scanner) {
        System.out.println("Țara: ");
        this.state = scanner.nextLine();
        System.out.println("Județul: ");
        this.county = scanner.nextLine();
        System.out.println("Municipiul / Sectorul: ");
        this.city = scanner.nextLine();
        System.out.println("Strada: ");
        this.street = scanner.nextLine();
        System.out.println("Codul poștal: ");
        this.postalCode = Integer.parseInt(scanner.nextLine());
    }

    public void read(ResultSet result) throws SQLException {
        this.state = result.getString("state");
        this.county = result.getString("county");
        this.city = result.getString("city");
        this.street = result.getString("street");
        this.postalCode = result.getInt("postalCode");
    }

    @Override
    public String toString() {
        return "{" + "\n" + " state='" + state + "', " + "\n" + " county='" + county + "', " + "\n" + " city='" + city + "', " + "\n" + " street='" + street + "', " + "\n" + " postalCode=" + postalCode + "\n" + "}";
    }

    public String toCSV() {
        return state + "," + "\n" + county + "," + "\n" + city + "," + "\n" + street + "," + "\n" + postalCode;
    }

    public String getState() {
        return state;
    }

    public String getCounty() {
        return county;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    /*
    public void setState(String state) {
        this.state = state;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    */
}
