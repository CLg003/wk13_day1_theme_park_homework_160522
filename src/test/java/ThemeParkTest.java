import attractions.Dodgems;
import attractions.Playground;
import behaviours.IReviewed;
import org.junit.Before;
import org.junit.Test;
import people.Visitor;
import stalls.CandyflossStall;
import stalls.IceCreamStall;
import stalls.ParkingSpot;
import stalls.TobaccoStall;
import attractions.RollerCoaster;

import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItem;

public class ThemeParkTest {

    ThemePark themePark;
    Dodgems dodgems;
    Playground playground;
    CandyflossStall candyflossStall;
    IceCreamStall iceCreamStall;
    TobaccoStall tobaccoStall;
    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void before(){
        themePark = new ThemePark();
        dodgems = new Dodgems("Wild Drive", 8);
        playground = new Playground("Pirate Adventure", 9);
        candyflossStall = new CandyflossStall("Cloud Candy", "Jill", ParkingSpot.A1, 8);
        iceCreamStall = new IceCreamStall("N-ice Cream", "Robert", ParkingSpot.B1, 7);
        tobaccoStall = new TobaccoStall("Hot Smokes", "Dave", ParkingSpot.A3, 2);
        rollerCoaster = new RollerCoaster("Rapid Rails", 10);
        visitor1 = new Visitor(13, 170, 15.00);
        visitor2 = new Visitor(19, 135, 25.00);
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

    @Test
    public void canReturnHashMapOfReviews(){
        themePark.addToAllReviewed(dodgems);
        themePark.addToAllReviewed(candyflossStall);
        assertEquals(2, themePark.getReviewDetails().size());
    }

    @Test
    public void canReturnVisitorIsNotAllowedToTobaccoStall(){
        themePark.addToAllReviewed(dodgems);
        themePark.addToAllReviewed(rollerCoaster);
        themePark.addToAllReviewed(playground);
        themePark.addToAllReviewed(candyflossStall);
        themePark.addToAllReviewed(iceCreamStall);
        themePark.addToAllReviewed(tobaccoStall);
        ArrayList<IReviewed> results = new ArrayList<>();
        results = themePark.getAllAllowedFor(visitor1);
        assertFalse(results, hasItem(tobaccoStall));
//        minimum 18
    }

//    @Test
//    public void canReturnVisitorIsNotAllowedOnRollercoaster(){
//        minimum 12, + 145cm
//    }
//
//    @Test
//    public void canReturnVisitorIsNotAllowedInPlayground(){
//        maximum 15
//    }



}
