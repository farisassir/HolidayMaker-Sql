package com.HolidayMaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SearchCriteria {
    private PreparedStatement statement;
    private ResultSet resultSet;
    private Connection conn = null;

    private MySqlConnection mySqlConnection = new MySqlConnection();
    private Scanner input=new Scanner(System.in);



    public SearchCriteria() {

    }


    public void newRoomSearch() {


        while (true) {
            try {
                System.out.println("1. near to centre: y/n ");
                String centreCheck = input.nextLine().toLowerCase();
                if ( centreCheck.equals("y") ) {
                    String distanceToCentre = "distance_centre <= 840 AND ";
                    System.out.println(" its ok we found one !");
                } else if ( centreCheck.equals("n") ) {
                    System.out.println(" its ok you don¨t mind");
                }

                System.out.println("2. near to beach: y/n ");
                String beachCheck = input.nextLine().toLowerCase();
                if ( beachCheck.equals("y") ) {
                    String distanceToBeach = "distance_centre <= 760 AND ";
                    System.out.println(" its ok we found one !");
                } else if ( beachCheck.equals("n") ) {
                    System.out.println(" its ok you don¨t mind");
                }

                System.out.println("3. With a child activity: ");
                String childCheck = input.nextLine().toLowerCase();
                if ( childCheck.equals("y") ) {
                    String childActivity = "distance_centre <= 760 AND ";
                    System.out.println(" its ok we found one !");
                } else if ( childCheck.equals("n") ) {
                    System.out.println(" its ok you don¨t mind");
                }

                System.out.println("4. With a night activity: ");
                String nightCheck = input.nextLine().toLowerCase();
                if ( nightCheck.equals("y") ) {
                    String nightActivity = "distance_centre <= 760 AND ";
                    System.out.println(" its ok we found one !");
                } else if ( nightCheck.equals("n") ) {
                    System.out.println(" its ok you don¨t mind");
                }

                System.out.println("5. With a Swimming Pool: ");
                String swimmingCheck = input.nextLine().toLowerCase();
                if ( swimmingCheck.equals("y") ) {
                    String swimmingPool = "distance_centre <= 760 AND ";
                    System.out.println(" its ok we found one !");
                } else if ( swimmingCheck.equals("n") ) {
                    System.out.println(" its ok you don¨t mind");
                }
                System.out.println("6. With a restaurant: ");
                String restaurantCheck = input.nextLine().toLowerCase();
                if ( restaurantCheck.equals("y") ) {
                    String distanceToBeach = "distance_centre <= 760 AND ";
                    System.out.println(" its ok we found one !");
                } else if ( restaurantCheck.equals("n") ) {
                    System.out.println(" its ok you don¨t mind");
                }
                System.out.println("7. See the result");





              Statement statement = conn.createStatement();
              ResultSet resultSet = statement.executeQuery("SELECT * FROM hotels WHERE ");



            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }
}