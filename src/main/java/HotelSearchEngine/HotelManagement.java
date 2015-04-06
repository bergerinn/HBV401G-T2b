package HotelSearchEngine;


import java.sql.*;

/**
 * Created by Andri on 05/03/15.
 */
public class HotelManagement {

    //mmm
    Connection connection;

    private SearchQuery mysearchQuery;
    private Booking book;
    private HotelStay[] hotelStays;



    public void search(SearchQuery searchObject) {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:Hotels.db");

            String hotelname = searchObject.getHotelName();
            String hotellocation = searchObject.getHotelLocation();
            int rating = searchObject.getRating();
            String wifi = searchObject.getHasWiFi();
            int numrooms = searchObject.getNumRooms();
            int totalprice = searchObject.getTotalPrice();





            String selectStatement = "SELECT hotels FROM Hotels WHERE location = ? AND rating = ? ";

            PreparedStatement prepStmt = connection.prepareStatement(selectStatement);
            prepStmt.setString(1, hotellocation);



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

    public static void main(String[] args) {

        HotelManagement manager = new HotelManagement();
        manager.mysearchQuery = new SearchQuery("Reykjavík", 5);
        manager.mysearchQuery.setRating(5);
        manager.search(manager.mysearchQuery);
    }


}
