package HotelSearchEngine;

/**
 * Created by Andri on 05/03/15.
 */

import java.util.*;

/**
 *
 */
public class SearchQuery {

    /**
     *
     */
    public SearchQuery() {
    }

    /**
     *
     */
    private String hotelName;

    /**
     *
     */
    private String location;

    /**
     *
     */
    private int rating;

    /**
     *
     */
    private boolean wiFi;

    /**
     *
     */
    private int numberOfRooms;

    /**
     *
     */
    private Date checkInTime;

    /**
     *
     */
    private Date checkOutTime;

    /**
     *
     */
    private int totalPrice;

    /**
     *
     */
    public void search() {
        // TODO implement here
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
    public void setWiFi(boolean yesOrNo) {
        this.wiFi = yesOrNo;
    }

    /**
     * @param roomCount
     */
    public void setNumRooms(int roomCount) {
        this.numberOfRooms = roomCount;
    }

    /**
     * @param time
     */
    public void setCheckInTime(Date time) {
        this.checkInTime = time;
    }

    /**
     * @param time
     */
    public void setCheckOutTime(Date time) {
        this.checkOutTime = time;
    }

    /**
     * @param price
     */
    public void setTotalPrice(int price) {
        this.totalPrice = price;
    }

}