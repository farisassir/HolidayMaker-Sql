package com.HolidayMaker;

import java.util.Scanner;

public class MainMenu {
   private Scanner input = new Scanner(System.in);
   Booking booking = new Booking();
   MySqlConnection mySqlConnection = new MySqlConnection();

    public void start() {
        menu();
    }

    private void menu(){
        while (true) {
            System.out.println("       Welcome to Holidaymaker Management System        ");
            System.out.println("                        Main Menu                       ");
            System.out.println("                1. Register a customer");
            System.out.println("                2. Search available room and book");
            System.out.println("                3. Change Booking");
            System.out.println("                4. Cancel Booking");
            System.out.println("                4. Exit");
            String option= input.nextLine();

            switch (option){
                case"1":
                    System.out.println("register");
                    break;
                case "2":
                    booking.NewHotelSearch();
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
            }
        }
    }
}
