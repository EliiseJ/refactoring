package rental;

import rental.RentalData;

public class RentalPriceCalculator {
	
	// age - age of driver
	// licence - number of full years person holds driving licence
	// clazz - class of the car from 1 (smallest) to 5 (largest) that person wishes to rent
	// acc - has s/he caused any accidents within last year
	// acc2 - has s/he participated (but not caused) in any accidents within last year
	// season - if it is high season or not
	public double price(RentalData rentalData) {
		
		if (rentalData.getAge() < 18) {
			throw new IllegalArgumentException("Driver too young - cannot quote the price");
		}
		if (rentalData.getAge() <= 21 && rentalData.getClazz() > 2) {
			throw new UnsupportedOperationException("Drivers 21 y/o or less can only rent Class 1 vehicles");
		}
		
		double rentalprice = rentalData.getAge();
		
		if (rentalData.getClazz() >=4 && rentalData.getAge() <= 25 && rentalData.isSeason() != false) {
			rentalprice = rentalprice * 2;
		}
		
		if (rentalData.getLicence() < 1) {
			throw new IllegalArgumentException("Driver must hold driving licence at least for one year. Can not rent a car!");
		}
		
		if (rentalData.getLicence() < 3) {
			rentalprice = rentalprice * 1.3;
		}
		
		if (rentalData.isAcc() == true && rentalData.getAge() < 30) {
			rentalprice += 15;
		}

		if (rentalprice > 1000) {
			return 1000.00;
		}
		return rentalprice;
	}
}