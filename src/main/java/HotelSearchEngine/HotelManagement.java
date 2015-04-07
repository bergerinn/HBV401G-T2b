package HotelSearchEngine;


import java.sql.*;


/**
 * Created by Andri on 05/03/15.
 */
public class HotelManagement {

    Connection connection;

    private SearchQuery mysearchQuery;
    private Booking book;
    private HotelStay[] hotelStays;



    public void search(SearchQuery searchObject) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Hotels.db");

            String hotellocation = searchObject.getHotelLocation();
            int numrooms = searchObject.getNumRooms();

            int rating = searchObject.getRating();
            String hotelname = searchObject.getHotelName();
            String wifi = searchObject.getHasWiFi();


            String selectStatement = "SELECT hotels FROM Hotels WHERE location = ? AND numRooms >= ?";

            if(rating != 0) {
                selectStatement = selectStatement + "AND rating >= ?";
            }
            if(hotelname != null) {
                selectStatement = selectStatement + "AND hotels = ?";
            }
            if(wifi != null) {
                selectStatement = selectStatement + "AND wifi = ?";
            }

            PreparedStatement prepStmt = connection.prepareStatement(selectStatement);
            prepStmt.setString(1, hotellocation);
            prepStmt.setInt(2, numrooms);


            if(rating != 0){
                prepStmt.setInt(3, rating);
            }
            if(hotelname != null){
                prepStmt.setString(4, hotelname);
            }
            if(wifi != null){
                prepStmt.setString(5, wifi);
            }

            ResultSet rs = prepStmt.executeQuery();


            while (rs.next()) {
                System.out.println(rs.getString("hotels"));

            }



            prepStmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }


    public void bookRoom(HotelStay theRoomToBook, Booking book) {

    }

    //This is main fall
    public static void main(String[] args) {

        HotelManagement manager = new HotelManagement();
        manager.mysearchQuery = new SearchQuery("Reykjavík", 5);
        manager.mysearchQuery.setRating(3);
        manager.mysearchQuery.setHotelName("Grand");
        manager.mysearchQuery.setWiFi("yes");
        manager.search(manager.mysearchQuery);
    }


}
