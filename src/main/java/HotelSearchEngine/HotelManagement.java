package HotelSearchEngine;


import java.sql.*;
import java.util.Date;
import java.util.*;
import java.util.concurrent.Exchanger;


/**
 * Created by Andri on 05/03/15.
 */
public class HotelManagement {

    Connection connection;

    private SearchQuery mysearchQuery;
    private Booking book;
    private HotelStay[] hotelStays;



    public HotelStay[] search(SearchQuery searchObject) {
        HotelStay[] improvedHotelStay = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Hotels.db");

            String hotellocation = searchObject.getHotelLocation();
            int numrooms = searchObject.getNumRooms();
            int rating = searchObject.getRating();
            String hotelname = searchObject.getHotelName();
            String wifi = searchObject.getHasWiFi();


            String selectStatement = "SELECT * FROM Hotels WHERE location = ? ";

            if(rating != 0) {
                selectStatement = selectStatement + " AND rating >= ?";
            }
            if(hotelname != null) {
                selectStatement = selectStatement + " AND hotels = ?";
            }
            if(wifi != null) {
                selectStatement = selectStatement + " AND wifi = ?";
            }


            String countStatement = selectStatement.replace("*", "COUNT(*)");

            PreparedStatement prepStmt = connection.prepareStatement(selectStatement);
            PreparedStatement countPrepStmt = connection.prepareStatement(countStatement);

            prepStmt.setString(1, hotellocation);
            countPrepStmt.setString(1, hotellocation);


            int rightNumber = 1;
            if(rating != 0){
                rightNumber++;
                prepStmt.setInt(rightNumber, rating);
                countPrepStmt.setInt(rightNumber, rating);
            }
            if(hotelname != null){
                rightNumber++;
                prepStmt.setString(rightNumber, hotelname);
                countPrepStmt.setString(rightNumber, hotelname);
            }
            if(wifi != null){
                rightNumber++;
                prepStmt.setString(rightNumber, wifi);
                countPrepStmt.setString(rightNumber, wifi);
            }

            ResultSet rs = prepStmt.executeQuery();
            ResultSet countRs = countPrepStmt.executeQuery();


            int numResults = countRs.getInt("COUNT(*)");
            hotelStays = new HotelStay[numResults];

            int spot = 0;
            while (rs.next()) {

                HotelStay hs = new HotelStay();
                hs.setHotelName(rs.getString("hotels"));
                hs.setRating(rs.getInt("rating"));
                hs.setLocation(rs.getString("location"));
                hs.setWiFi(rs.getString("wifi"));
                hs.setNumRooms(searchObject.getNumRooms());
                hs.setTotalPrice(searchObject.getNumRooms() * rs.getInt("roomPrice"));
                hs.setCheckInTime(searchObject.getCheckInTime());
                hs.setCheckOutTime(searchObject.getCheckOutTime());

                hotelStays[spot] = hs;
                spot++;

            }

            List<HotelStay> myList = new ArrayList<HotelStay>();

            for(int i = 0; i < hotelStays.length; i++){
                boolean inOrOut = checkDates(hotelStays[i], hotelStays[i].getRooms());
                if(inOrOut){
                    myList.add(hotelStays[i]);
                }
            }

            improvedHotelStay = new HotelStay[myList.size()];
            for(int z = 0; z < myList.size(); z++){
                improvedHotelStay[z] = myList.get(z);
            }

            prepStmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return improvedHotelStay;
    }

    public static String dateToString( Date date )
    {
        StringBuilder b = new StringBuilder();
        Formatter f = new Formatter(b);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        f.format ( "%04d%02d%02d"
                , c.get(Calendar.YEAR)
                , c.get(Calendar.MONTH)
                , c.get(Calendar.DAY_OF_MONTH)
        );
        return b.toString();
    }

    public boolean checkDates(HotelStay hs, int numrooms){

        String checkin = dateToString(hs.getCheckInTime());
        String checkout = dateToString(hs.getCheckOutTime());

        boolean canIcheckIn = true;


        try{
            String selectStatement1 = "SELECT * FROM Available WHERE ? <= date AND date <= ? AND hotel = ?";
            PreparedStatement prepStmt1 = connection.prepareStatement(selectStatement1);
            prepStmt1.setString(1, checkin);
            prepStmt1.setString(2, checkout);
            prepStmt1.setString(3, hs.getHotelName());
            ResultSet rs = prepStmt1.executeQuery();

            while(rs.next()){
                int roomsavail = rs.getInt("roomsAvail");
                if(roomsavail < numrooms){
                    canIcheckIn = false;
                }

            }
        }

        catch(Exception e){

        }

        return canIcheckIn;
    }


    public boolean bookRoom(HotelStay theRoomToBook, Booking book) {

        boolean success;
        try{

            connection = DriverManager.getConnection("jdbc:sqlite:Hotels.db");

            String name = book.getName();
            String email = book.getEmail();
            String phone = book.getPhone();
            int numrooms = theRoomToBook.getRooms();
            String hotelid = theRoomToBook.getHotelName();
            int totPrice = theRoomToBook.getTotalPrice();

            String checkin = dateToString(theRoomToBook.getCheckInTime());
            String checkout = dateToString(theRoomToBook.getCheckOutTime());

            String selectStatement1 = "SELECT * FROM Available WHERE ? <= date AND date <= ? AND hotel = ?";
            PreparedStatement prepStmt1 = connection.prepareStatement(selectStatement1);
            prepStmt1.setString(1, checkin);
            prepStmt1.setString(2, checkout);
            prepStmt1.setString(3, theRoomToBook.getHotelName());
            ResultSet rs = prepStmt1.executeQuery();


            while(rs.next()){
                String updateStatement = "UPDATE Available set roomsAvail = ? WHERE  date = ? AND hotel = ?";
                PreparedStatement updatePrep = connection.prepareStatement(updateStatement);
                int difference = rs.getInt("roomsAvail") - numrooms;
                updatePrep.setInt(1, difference);
                updatePrep.setString(2, rs.getString("date"));
                updatePrep.setString(3, theRoomToBook.getHotelName());
                updatePrep.executeUpdate();
            }




            String insertStatement = "INSERT INTO Booking VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement prepStmt = connection.prepareStatement(insertStatement);

            prepStmt.setString(1, name);
            prepStmt.setString(2, email);
            prepStmt.setString(3, phone);
            prepStmt.setInt(4, numrooms);
            prepStmt.setString(5, hotelid);
            prepStmt.setInt(6, totPrice);
            prepStmt.setString(7, checkin);
            prepStmt.setString(8, checkout);


            prepStmt.executeUpdate();


            connection.close();
            success = true;
        }
        catch(Exception e){
            success = false;
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return success;
    }

}
