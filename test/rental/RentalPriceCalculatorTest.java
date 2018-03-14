package rental;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class RentalPriceCalculatorTest {

	private RentalPriceCalculator rentalPriceCalculator;

    @Before
    public void setUp() throws Exception {
        rentalPriceCalculator = new RentalPriceCalculator();
    }

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
    public void testCanDriverRentCar() {}

    @Test
    public void testGetRentalPrice() {}

    @Test
    public void testGetExtraFees() {
    }

    @Test
    public void testGetPriceMultiplier() {}

    @Test
    public void testIsDriverOldEnough() {}
}
