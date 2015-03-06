package Tests;

import HotelSearchEngine.HotelManagement;
import HotelSearchEngine.HotelStay;

import java.util.Date;

import static org.junit.Assert.*;

public class HotelManagementTest {

    MockSearchQuery number1;
    private MockHotelManagement theManager;
    private HotelStay[] mystays;

    private Date checkin = new Date();
    private Date checkout = new Date(2020, 04, 12);

    @org.junit.Before
    public void setUp() throws Exception {
        number1 = new MockSearchQuery("Grimbilkofinn", "Grimbilfjöll", 1, false, 1, checkin, checkout, 100);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        theManager = null;
        number1 = null;
        mystays = null;
    }

    @org.junit.Test
    public void testSearchResults() throws Exception {

        assertEquals(mystays, theManager.searchResults(number1));
    }
}