import attractions.Dodgems;
import attractions.Playground;
import org.junit.Before;
import org.junit.Test;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;

import static org.junit.Assert.assertEquals;

public class ThemeParkTest {

    ThemePark themePark;
    Dodgems dodgems;
    Playground playground;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;

    @Before
    public void before(){
        themePark = new ThemePark();
        dodgems = new Dodgems("Wild Drive", 8);
        playground = new Playground("Pirate Adventure", 9);
        candyflossStall = new CandyflossStall("Cloud Candy", "Jill", ParkingSpot.A1, 8);
        iceCreamStall = new IceCreamStall("N-ice Cream", "Robert", ParkingSpot.B1, 7);
    }

    @Test
    public void startsWithEmptyArrayListOfReviewedVisitorLocations(){
        assertEquals(0, themePark.getAllReviewed().size());
    }

    @Test
    public void canAddVisitorLocationsToArrayList(){
        themePark.addToAllReviewed(dodgems);
        themePark.addToAllReviewed(playground);
        themePark.addToAllReviewed(candyflossStall);
        themePark.addToAllReviewed(iceCreamStall);
        assertEquals(4, themePark.getAllReviewed().size());
    }
}
