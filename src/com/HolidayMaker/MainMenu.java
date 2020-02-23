package com.HolidayMaker;

import java.util.Scanner;

public class MainMenu {
    Scanner input;

    public MainMenu(Scanner input) {
        this.input=new Scanner(System.in);
    }

    public MainMenu() {

    }

    public void start() {
        this.menu();
    }

    private void menu() {
        while (true) {
            System.out.println("        Holidaymaker        ");
            System.out.println("2. Register a customer");
            System.out.println("3. Show available room within specified period");
            System.out.println("4. Reserve a room");
            System.out.println("5. add Extra bed");
            System.out.println("6. Cancel booking");
            String option=this.input.nextLine();


        }
    }
}
