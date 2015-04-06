package HotelSearchEngine;

import java.util.*;

/**
 * Created by Andri on 05/03/15.
 */


public class Room {

    /**
     *
     */
    public Room() {
    }

    /**
     *
     */
    private String typeOfRoom;

    /**
     *
     */
    private int roomPrice;

    /**
     *
     */
    private boolean isOccupied;

    /**
     *
     */
    private int roomId;

    /**
     * @param isOccupied
     * @return
     */
    public void setOccupyStatus(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }

    /**
     * @return
     */
    public int getRoomId() {
        return this.roomId;
    }

}