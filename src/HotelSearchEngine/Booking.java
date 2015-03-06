package HotelSearchEngine;

import java.util.*;


/**
 * Created by Andri on 05/03/15.
 */



/**
 *
 */
public class Booking {

    /**
     *
     */
    public Booking() {
    }

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String email;

    /**
     *
     */
    private String phone; //Maybe we want this as int

    /**
     *
     */
    private int roomId;

    /**
     *
     */
    private String hotelId;

    /**
     * @param name
     * @param email
     * @param phone
     * @param roomId
     * @param hotelId
     * @return
     */
    public void InsertIntoDB(String name, String email, String phone, int roomId, String hotelId) {

    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @param roomid
     */
    public void setRoomId(int roomid) {
        this.roomId = roomid;
    }

    /**
     * @param hotelid
     */
    public void setHotelId(String hotelid) {
        this.hotelId = hotelid;
    }

}
