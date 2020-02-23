package com.HolidayMaker;

import java.util.Scanner;

public class MainMenu {
   private Scanner input = new Scanner(System.in);

    public void start() {
        menu();
    }

    private void menu(){
        while (true) {
            System.out.println("       Welcome to Holidaymaker Management System        ");
            System.out.println("                        Main Menu                       ");
            System.out.println("                1. Register a customer");
            System.out.println("                2. Show available room within specified period");
            System.out.println("                3. Reserve a room");
            System.out.println("                4. add Extra bed");
            System.out.println("                5. Cancel booking");
            String option= input.nextLine();

            switch (option){
                case"1":
                    System.out.println("register");
                    break;
                case "2":
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
