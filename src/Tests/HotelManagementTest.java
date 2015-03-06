package Tests;

import HotelSearchEngine.HotelManagement;
import HotelSearchEngine.HotelStay;

import java.util.Date;

import static org.junit.Assert.*;

public class HotelManagementTest{

    private MockSearchQuery number1;
    private HotelManagement theManager;
    private HotelStay[] mystays;

    private Date checkin = new Date();
    private Date checkout = new Date(2020, 04, 12);

    public void setUp() throws Exception {
        MockSearchQuery number1 = new MockSearchQuery("Grimbilkofinn", "Grimbilfjöll", 1, false, 1, checkin, checkout, 100 );
    }

    @org.junit.After
    public void tearDown() throws Exception {
        theManager = null;
        number1 = null;
        mystays = null;

    }

    @org.junit.Test
    public void testSearchResults() throws Exception {
        assertArrayEquals(HotelStay[] mystays, theManager.searchResults(MockSearchQuery number1));

    }
}