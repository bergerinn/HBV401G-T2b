package HotelSearchEngine;


import java.sql.*;
import java.util.Date;
import java.text.*;
import java.util.*;


/**
 * Created by Andri on 05/03/15.
 */
public class HotelManagement {

    Connection connection;

    private SearchQuery mysearchQuery;
    private Booking book;
    private HotelStay[] hotelStays;



    public HotelStay[] search(SearchQuery searchObject) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Hotels.db");

            String hotellocation = searchObject.getHotelLocation();
            int numrooms = searchObject.getNumRooms();
            int rating = searchObject.getRating();
            String hotelname = searchObject.getHotelName();
            String wifi = searchObject.getHasWiFi();


            String selectStatement = "SELECT * FROM Hotels WHERE location = ? AND numRooms >= ?";

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
            prepStmt.setInt(2, numrooms);
            countPrepStmt.setString(1, hotellocation);
            countPrepStmt.setInt(2, numrooms);


            int rightNumber = 2;
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


            prepStmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return hotelStays;
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

            SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy");
            String checkin = ft.format(theRoomToBook.getCheckInTime());
            String checkout = ft.format(theRoomToBook.getCheckOutTime());



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

    public static void main(String[] args) {

        HotelManagement manager = new HotelManagement();
        Date chkin = new Date();
        Date chkout = new Date();
        manager.mysearchQuery = new SearchQuery("Reykjavík", 5, chkin, chkout);
        manager.mysearchQuery.setRating(3);
        manager.mysearchQuery.setHotelName("Grand");
        manager.mysearchQuery.setWiFi("yes");

        HotelStay[] myhs;
        myhs = manager.search(manager.mysearchQuery);

        /*
        for(int i = 0; i<myhs.length; i++){
            System.out.println(myhs[i].getHotelName());
            System.out.println(myhs[i].getRating());
            System.out.println(myhs[i].getWiFi());
        }
        */

        manager.book = new Booking();
        manager.book.setName("Kári");
        manager.book.setEmail("leikjanet@leikjanet.is");
        manager.book.setPhone("111-1111");
        boolean test;
        test = manager.bookRoom(myhs[0], manager.book);
        System.out.println(test);

    }


}
