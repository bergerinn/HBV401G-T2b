package HotelSearchEngine;


import java.util.*;

/**
 *
 */
public class HotelStay {

    /**
     *
     */
    public HotelStay() {
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
    private Room[] rooms;

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
     * @param room
     */
    public void setRoom(Room room) {

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

    /**
     * @return
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     * @return
     */
    public int getRating() {
        return rating;
    }

    /**
     * @return
     */
    public boolean getWiFi() {
        return wiFi;
    }

    /**
     * @return
     */
    public Room[] getRooms() {
        return rooms;
    }

    /**
     * @return
     */
    public Date getCheckInTime() {
        return checkInTime;
    }

    /**
     * @return
     */
    public Date getCheckOutTime() {
        return checkOutTime;
    }

    /**
     * @return
     */
    public int getTotalPrice() {
        return totalPrice;
    }

}
