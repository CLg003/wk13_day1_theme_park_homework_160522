package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;
    Visitor visitor5;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(12, 150, 9.50);
        visitor2 = new Visitor(8, 115, 3.75 );
        visitor3 = new Visitor(13, 140, 12.50);
        visitor4 = new Visitor(10, 165, 3.50);
        visitor5 = new Visitor(19, 205, 20.00);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void isAllowedToRideRollercoasterIfOverMinimumHeightAndAge(){
        assertEquals(true, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void isNotAllowedToRideRollercoasterIfUnderMinimumHeightAndAge(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void isNotAllowedToRideRollercoasterIfOverMinimumAgeButUnderMinimumHeight(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void isNotAllowedToRideRollercoasterIfOverMinimumHeightButUnderMinimumAge(){
        assertEquals(false, rollerCoaster.isAllowedTo(visitor4));
    }

    @Test
    public void canReturnDefaultPrice(){
        assertEquals(8.40, rollerCoaster.defaultPrice(), 0.0);
    }

    @Test
    public void willChargeDoubleForVisitorsOver200Height(){
        assertEquals(16.80, rollerCoaster.priceFor(visitor5), 0.0);
    }

    @Test
    public void willChargeDefaultPriceForVisitorsUnder200Height(){
        assertEquals(8.40, rollerCoaster.priceFor(visitor3), 0.0);
    }
}
