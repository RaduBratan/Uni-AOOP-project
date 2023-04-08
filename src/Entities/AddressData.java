package Entities;

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

    public AddressData(Scanner in) {
        this.read(in);
    }

    public void read(Scanner in) {
        System.out.println("Țara: ");
        this.state = in.nextLine();
        System.out.println("Județul: ");
        this.county = in.nextLine();
        System.out.println("Municipiul / Sectorul: ");
        this.city = in.nextLine();
        System.out.println("Strada: ");
        this.street = in.nextLine();
        System.out.println("Codul poștal: ");
        this.postalCode = Integer.parseInt(in.nextLine());
    }

    @Override
    public String toString() {
        return "{" +
                "\n" +
                " state='" + state + "', " +
                "\n" +
                " county='" + county + "', " +
                "\n" +
                " city='" + city + "', " +
                "\n" +
                " street='" + street + "', " +
                "\n" +
                " postalCode=" + postalCode +
                "\n" +
                "}";
    }

    public String toCSV() {
        return state + "," +
                "\n" + county + "," +
                "\n" + city + "," +
                "\n" + street + "," +
                "\n" + postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getPostalCode() {
        return postalCode;
    }
}
