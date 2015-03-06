package Tests;

import HotelSearchEngine.SearchQuery;

import java.util.Date;

/**
 * Created by Andri on 06/03/15.
 */
public class MockSearchQuery{

    private String hotelName;
    private String location;
    private int rating;
    private boolean wiFi;
    private int numberOfRooms;
    private Date checkInTime;
    private Date checkOutTime;
    private int totalPrice;

    public MockSearchQuery(String hName, String loc, int rating, boolean hasWiFi, int numRooms, Date chkIn, Date chkOut, int totPrice){
        this.hotelName = hName;
        this.location = loc;
        this.rating = rating;
        this.wiFi = hasWiFi;
        this.numberOfRooms = numRooms;
        this.checkInTime = chkIn;
        this.checkOutTime = chkOut;
        this.totalPrice = totPrice;

    }


}
