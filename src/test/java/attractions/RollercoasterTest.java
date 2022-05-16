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

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(12, 150, 9.50);
        visitor2 = new Visitor(8, 115, 3.75 );
        visitor3 = new Visitor(13, 140, 12.50);
        visitor4 = new Visitor(11, 155, 4.50);
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
}
