package com.HolidayMaker;

import java.util.Scanner;

public class SearchCriteria {

    private Scanner input=new Scanner(System.in);
    private MySqlConnection mySqlConnection=new MySqlConnection();

    public SearchCriteria() {

    }

    public void NewHotelSearch() {
        System.out.println("1.When do you checkIn: ");
        String checkIn = input.nextLine();
        searchByDate(checkIn);
        //Function
        System.out.println("2. near to beach: ");
        String beach = input.nextLine();
        //function
        System.out.println("3. near to center: ");
        //function
        System.out.println("4. With a child activity: ");
        //function
        System.out.println("5. With a night activity: ");
        //
        System.out.println("6. With a Swimming Pool: ");
        // function
        System.out.println("7. With a restaurant: ");

    }

public void searchByDate(String checkIn){

}
}