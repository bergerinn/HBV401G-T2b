package HotelSearchEngine;

/**
 * Created by Andri on 05/03/15.
 */

import java.util.*;
import java.sql.*;


public class SearchQuery {


    private String hotelName;
    private String location;
    private int rating;
    private String wiFi;
    private int numberOfRooms;
    //private Date checkInTime;
    //private Date checkOutTime;


    public SearchQuery(String loc, int numrooms) {

        this.location = loc;
        this.numberOfRooms = numrooms;

        this.hotelName = null;
        this.rating = 0;
        this.wiFi = null;
    }


    public void setHotelName(String name) {
        this.hotelName = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setWiFi(String yesOrNo) {
        this.wiFi = yesOrNo;
    }


    /*public void setCheckInTime(Date time) {
        this.checkInTime = time;
    }
    /*

    /**
     * @param time
     */
    /*public void setCheckOutTime(Date time) {
        this.checkOutTime = time;
    }
    */

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

}