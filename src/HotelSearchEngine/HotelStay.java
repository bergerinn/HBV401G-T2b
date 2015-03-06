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
     * @param room
     * @return
     */
    public void setRoom(Room room) {

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
