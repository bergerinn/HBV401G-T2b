package HotelSearchEngine;


import java.sql.*;
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

            int rightNumber = 2;

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
                hs.setNumRooms(rs.getInt("numRooms"));
                hs.setTotalPrice(rs.getInt("numRooms") * rs.getInt("roomPrice"));

                hotelStays[spot] = hs;
                spot++;

            }

            for(int i = 0; i <hotelStays.length; i++){

                System.out.println(hotelStays[i].getHotelName());
                System.out.println(hotelStays[i].getLocation());
                System.out.println(hotelStays[i].getTotalPrice());
            }

            prepStmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        return hotelStays;
    }


    public void bookRoom(HotelStay theRoomToBook, Booking book) {

    }

    public static void main(String[] args) {

        HotelManagement manager = new HotelManagement();
        manager.mysearchQuery = new SearchQuery("Reykjavík", 5);
        manager.mysearchQuery.setRating(3);
        manager.mysearchQuery.setHotelName("Grand");
        //manager.mysearchQuery.setWiFi("yes");
        manager.search(manager.mysearchQuery);
    }


}
