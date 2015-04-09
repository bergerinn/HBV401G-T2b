package HotelSearchEngine;

/**
 * Created by Andri on 05/03/15.
 */

import java.util.*;
import java.sql.*;
import java.util.Date;


public class SearchQuery {


    private String hotelName;
    private String location;
    private int rating;
    private String wiFi;
    private int numberOfRooms;
    private Date checkInTime;
    private Date checkOutTime;


    public SearchQuery(String loc, int numrooms, Date checkin, Date checkout) {

        this.location = loc;
        this.numberOfRooms = numrooms;
        this.checkInTime = checkin;
        this.checkOutTime = checkout;

        this.hotelName = null;
        this.rating = 0;
        this.wiFi = null;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setHotelName(String name) {
        this.hotelName = name;
    }

    public void setWiFi(String yesOrno) {
        this.wiFi = yesOrno;
    }



    public String getHotelName(){
        return this.hotelName;
    }

    public String getHotelLocation(){
        return this.location;
    }

    public int getRating(){
        return this.rating;
    }

    public String getHasWiFi(){
        return this.wiFi;
    }

    public int getNumRooms(){
        return this.numberOfRooms;
    }

    public Date getCheckInTime(){
       return this.checkInTime;
    }

    public Date getCheckOutTime(){
        return this.checkOutTime;
    }


    public static void main(String[] args){
        Date what = new Date();
        System.out.println(what);
    }
}

