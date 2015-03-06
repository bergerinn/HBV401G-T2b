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
     * @return
     */
    public void search() {
        // TODO implement here
    }

    /**
     * @param name
     * @return
     */
    public void setHotelName(String name) {
        this.hotelName = name;
    }

    /**
     * @param loc
     * @return
     */
    public void setLocation(String loc) {
        this.location = loc;
    }

    /**
     * @param rating
     * @return
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * @param yesOrNo
     * @return
     */
    public void setWiFi(boolean yesOrNo) {
        this.wiFi = yesOrNo;
    }

    /**
     * @param roomCount
     * @return
     */
    public void setNumRooms(int roomCount) {
        this.numberOfRooms = roomCount;
    }

    /**
     * @param time
     * @return
     */
    public void setCheckInTime(Date time) {
        this.checkInTime = time;
    }

    /**
     * @param time
     * @return
     */
    public void setCheckOutTime(Date time) {
        this.checkOutTime = time;
    }

    /**
     * @param price
     * @return
     */
    public void setTotalPrice(int price) {
        this.totalPrice = price;
    }

}