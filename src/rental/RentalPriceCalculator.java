package rental;

import driver.Driver;
import rental.RentalData;

import java.math.BigDecimal;

public class RentalPriceCalculator {

    public static final int YOUNG_DRIVER_HIGH_CAR_CLASS = 4;
    public static final int YOUNG_DRIVER_HIGH_CAR_CLASS_MIN_AGE = 25;
    public static final int YOUNG_DRIVER_HIGH_CAR_CLASS_MULTIPLIER = 2;
    public static final int NEW_LICENSE = 3;
    public static final double NEW_LICENSE_MULTIPLIER = 1.3;
    public static final int MINIMAL_AGE_FOR_DRIVING = 18;
    public static final int MINIMAL_AGE_FOR_HIGH_CLASS_CAR = 21;

    // age - age of driver
    // licence - number of full years person holds driving licence
    // clazz - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
    // acc - has s/he caused any accidents within last year
    // acc2 - has s/he participated (but not caused) in any accidents within last year
    // season - if it is high season or not
    public double price(Driver driver) {
		
	/*	if (rentalData.getAge() < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (rentalData.getAge() <= 21 && rentalData.getClazz() > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		*/
        double rentalprice = driver.getAge();
		
	/*	if (rentalData.getClazz() >=4 && rentalData.getAge() <= 25 && rentalData.isSeason() != false) {
			rentalprice = rentalprice * 2;
		}
		*/
	/*
		if (rentalData.getLicence() < 3) {
			rentalprice = rentalprice * 1.3;
		}
		*/

        if (rentalprice > 1000) {
            return 1000.00;
        }
        return rentalprice;
    }

    public boolean canDriverRentCar(Driver driver) {
        if (driver.getTimeOfLicense() < 1) {
            throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
        }
        return true;
    }

    public BigDecimal getRentalPrice(Driver driver, int carClass, boolean isSeason) {
        return BigDecimal.valueOf(driver.getAge());
    }

    private BigDecimal getExtraFees(Driver driver) {
        if (driver.hasCausedAccidents() && driver.getAge() < 30) {
            return BigDecimal.valueOf(15);
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getPriceMultiplier(Driver driver, int carClass, boolean isSeason) {
        BigDecimal multiplier = BigDecimal.ONE;
        if (carClass >= YOUNG_DRIVER_HIGH_CAR_CLASS && driver.getAge() <= YOUNG_DRIVER_HIGH_CAR_CLASS_MIN_AGE && isSeason) {
            return multiplier.multiply(BigDecimal.valueOf(YOUNG_DRIVER_HIGH_CAR_CLASS_MULTIPLIER));
        }
        if (driver.getTimeOfLicense() < NEW_LICENSE) {
            return multiplier.multiply(BigDecimal.valueOf(NEW_LICENSE_MULTIPLIER));
        }
        return multiplier;
    }

    public boolean isDriverOldEnough(Driver driver, int carClass) {
        if (driver.getAge() < MINIMAL_AGE_FOR_DRIVING) {
            throw new IllegalArgumentException("Driver too young - cannot quote the price");
        }
        if (driver.getAge() <= MINIMAL_AGE_FOR_HIGH_CLASS_CAR && carClass > 2) {
            throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
        }
        return true;
    }

}