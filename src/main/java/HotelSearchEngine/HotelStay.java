package HotelSearchEngine;


import java.util.*;

/**
 *
 */
public class HotelStay {




    private String hotelName;
    private String location;
    private int rating;
    private String wiFi;
    private int numRooms;
    private Date checkInTime;
    private Date checkOutTime;
    private int totalPrice;

    public HotelStay() {
    }

    public void setHotelName(String name) {
        this.hotelName = name;
    }


    public void setLocation(String loc) {
        this.location = loc;
    }


    public void setRating(int rating) {
        this.rating = rating;
    }


    public void setWiFi(String yesOrNo) {
        this.wiFi = yesOrNo;
    }


    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }


    public void setCheckInTime(Date time) {
        this.checkInTime = time;
    }


    public void setCheckOutTime(Date time) {
        this.checkOutTime = time;
    }


    public void setTotalPrice(int price) {
        this.totalPrice = price;
    }




    public String getHotelName() {
        return hotelName;
    }

    public String getWiFi(){return wiFi;}

    public int getRating(){return rating;}

    public int getRooms() {
        return numRooms;
    }


    public Date getCheckInTime() {
        return checkInTime;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }


    public int getTotalPrice() {
        return totalPrice;
    }

}
