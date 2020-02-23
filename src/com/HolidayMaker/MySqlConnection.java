package com.HolidayMaker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySqlConnection {
    private Connection conn = null;
    private PreparedStatement statement;
    private ResultSet resultSet;

public MySqlConnection(){
    connect();
}
private void connect(){
    try{
        conn = DriverManager.getConnection("jdbc:mysql://localhost/holidayMaker?user=root&password=Ics@00Fine&serverTimezone=UTC");
    }catch(Exception e){
        e.printStackTrace();
    }
}

public void searchForHotel(){

}

}



