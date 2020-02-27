package com.HolidayMaker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainMenu {

    private String guestName;
    private String guestPhone;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Scanner input=new Scanner(System.in);
    private SearchCriteria searchCriteria=new SearchCriteria();
    MySqlConnection mySqlConnection=new MySqlConnection();
    private Object PreparedStatement;


    public void start() throws SQLException {
        menu();
    }

    private void menu() throws SQLException {
        while (true) {
            System.out.println("       Welcome to Holidaymaker Management System        ");
            System.out.println("                        Main Menu                       ");
            System.out.println("1. Register a Guest");
            System.out.println("2. Search available room and Make a booking");
            System.out.println("3. Change Booking");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");
            String option=input.nextLine();

            switch (option) {
                case "1":
                    registerGuest();
                    break;
                case "2":
                    searchCriteria.newRoomSearch();
                    System.out.println("availability");
                    break;
                case "3":
                    System.out.println("booking");
                    break;
                case "4":
                    System.out.println("Extra bed");
                    break;
                case "5":
                    System.out.println("cancellation");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + option);
            }
        }
    }

    public void registerGuest() throws SQLException {
        System.out.println("Enter name: ");
        guestName = input.nextLine().toLowerCase();
        System.out.println("Enter Phone Number: ");
        guestPhone = input.nextLine().toLowerCase();
        PreparedStatement preparedStatement = mySqlConnection.conn.prepareStatement("INSERT INTO guests (guest_name , guest_phone) VALUES (?, ?)");
        preparedStatement.setString (1, guestName);
        preparedStatement.setString (2, guestPhone);
        preparedStatement.execute();
        System.out.println("Guest registered!");

    }
}