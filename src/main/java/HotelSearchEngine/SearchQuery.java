package HotelSearchEngine;

/**
 * Created by Andri on 05/03/15.
 */

import java.util.*;
import java.sql.*;

/**

/**
 *
 */
public class SearchQuery {


    private String hotelName;
    private String location;
    private int rating;
    private String wiFi;
    private int numberOfRooms;
    private Date checkInTime;
    //private Date checkOutTime;
    private int totalPrice;


    public SearchQuery(String loc, int numrooms) {

        this.location = loc;
        this.numberOfRooms = numrooms;

        this.hotelName = null;
        this.rating = 0;
        this.totalPrice = 0;
        this.wiFi = null;
    }

    /**
     * @param name
     */
    public void setHotelName(String name) {
        this.hotelName = name;
    }

    /**
     * @param loc
     */
    public void setLocation(String loc) {
        this.location = loc;
    }

    /**
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @param yesOrNo
     */
    public void setWiFi(String yesOrNo) {
        this.wiFi = yesOrNo;
    }

    /**
     * @param roomCount
     */
    public void setNumRooms(int roomCount) {
        this.numberOfRooms = roomCount;
    }

    /**
     * @param
     */
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
    /*

    /**
     * @param price
     */
    public void setTotalPrice(int price) {
        this.totalPrice = price;
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

    public int getTotalPrice(){
        return this.totalPrice;
    }


}