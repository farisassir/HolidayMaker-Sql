package com.HolidayMaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SearchCriteria {

    private PreparedStatement statement;
    private ResultSet resultSet;

    private String hotelName;
    private String hotelAddress;
    private String distanceToCentre ;
    private String distanceToBeach ;
    private String childActivity ;
    private String nightActivity ;
    private String swimmingPool;
    private String restaurant;

    MySqlConnection mySqlConnection = new MySqlConnection();
    Scanner input=new Scanner(System.in);



    public SearchCriteria (String hotelName, String hotelAddress, String distanceToCentre, String distanceToBeach, String childActivity, String nightActivity, String swimmingPool, String restaurant) {
        this.hotelName=hotelName;
        this.hotelAddress=hotelAddress;
        this.distanceToCentre=distanceToCentre;
        this.distanceToBeach=distanceToBeach;
        this.childActivity=childActivity;
        this.nightActivity=nightActivity;
        this.swimmingPool=swimmingPool;
        this.restaurant=restaurant;
    }

    public SearchCriteria() {

    }


    public void newRoomSearch() {

        while (true) {
            try {


                System.out.println("1. near to centre: y/n ");
                String centreCheck = input.nextLine().toLowerCase();
                if ( centreCheck.equals("y") ) {
                    distanceToCentre = "840" ;

                } else if ( centreCheck.equals("n") ) {

                }

                System.out.println("2. near to beach: y/n ");
                String beachCheck = input.nextLine().toLowerCase();
                if ( beachCheck.equals("y") ) {
                   distanceToBeach = "760";

                } else if ( beachCheck.equals("n") ) {

                }

                System.out.println("3. With a child activity: ");
                String childCheck = input.nextLine().toLowerCase();
                if ( childCheck.equals("y") ) {
                    childActivity = "1";

                } else if ( childCheck.equals("n") ) {

                }

                System.out.println("4. With a night activity: ");
                String nightCheck = input.nextLine().toLowerCase();
                if ( nightCheck.equals("y") ) {
                   nightActivity = "1";

                } else if ( nightCheck.equals("n") ) {

                }

                System.out.println("5. With a Swimming Pool: ");
                String swimmingCheck = input.nextLine().toLowerCase();
                if ( swimmingCheck.equals("y") ) {
                  swimmingPool = "1";

                } else if ( swimmingCheck.equals("n") ) {

                }
                System.out.println("6. With a restaurant: ");
                String restaurantCheck = input.nextLine().toLowerCase();
                if ( restaurantCheck.equals("y") ) {
                    restaurant = "1";

                } else if ( restaurantCheck.equals("n") ) {

                }
                System.out.println("7. See the result");


                statement = mySqlConnection.conn.prepareStatement("SELECT hotel_name FROM hotels JOIN facilities ON facility_id = facility_facility_id WHERE pool = ? AND night_activity = ? AND child_activity = ? AND  distance_centre <= ? AND distance_beach <= ?"
               );

                statement.setString(1, swimmingPool);
                statement.setString(2, nightActivity);
                statement.setString(3, childActivity);
                statement.setString(4, distanceToCentre);
                statement.setString(5, distanceToBeach);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    hotelName = "Hotel:  " + resultSet.getString("hotel_name");
                }

                    System.out.println(hotelName);


            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }
}