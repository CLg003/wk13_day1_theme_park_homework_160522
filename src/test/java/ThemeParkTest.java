import attractions.Dodgems;
import attractions.Playground;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
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
    Visitor visitor1;

    @Before
    public void before(){
        themePark = new ThemePark();
        dodgems = new Dodgems("Wild Drive", 8);
        playground = new Playground("Pirate Adventure", 9);
        candyflossStall = new CandyflossStall("Cloud Candy", "Jill", ParkingSpot.A1, 8);
        iceCreamStall = new IceCreamStall("N-ice Cream", "Robert", ParkingSpot.B1, 7);
        visitor1 = new Visitor(13, 170, 15.00);
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

    @Test
    public void canIncrementAttractionVisitCount(){
        themePark.visit(visitor1, dodgems);
        assertEquals(1, dodgems.getVisitCount());
    }

    @Test
    public void canAddAtractionToVisitedAttractionsList(){
        themePark.visit(visitor1, dodgems);
        assertEquals(1, visitor1.getVisitedAttractions().size());
    }


}
