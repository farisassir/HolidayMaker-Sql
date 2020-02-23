package com.HolidayMaker;

import java.util.Scanner;

public class SearchCriteria {



    private MySqlConnection mySqlConnection = new MySqlConnection();
    private Scanner input = new Scanner(System.in);



    public void NewHotelSearch() {
        System.out.println("1. near to beach: ");
        String beach=input.nextLine();
        searchByBeach(beach);
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

    private void searchByBeach(String beach) {
        String y="1";
        String n="0";
        if ( beach == y ) {

            if ( distanceToBeach <= 760 ) {
                System.out.println(" its ok we found one !");

            } else if ( beach == n){
                System.out.println(" its ok you don¨t mind");
            } else {
                System.out.println("Sorry all the hotel near to beach is fully booked");
            }

        }
    }


}
