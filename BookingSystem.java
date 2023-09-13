package carTaxiApp;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {
	private List<Taxi> taxis=new ArrayList<>();
	
	public void initializeTaxis() {
		taxis.add(new Taxi("A"));
		taxis.add(new Taxi("A"));
		taxis.add(new Taxi("A"));
		taxis.add(new Taxi("A"));
	}
	
	public void bookTaxi(int customerId, String pickupPoint, String dropPoint, int pickupTime) {
		Taxi availableTaxi=null;
		int minDropTime=Integer.MAX_VALUE;
		
		for(Taxi taxi:taxis) {
			if(taxi.getCurrentPoint().equals(pickupPoint) && taxi.getDropTime() <= pickupTime) {
				availableTaxi=taxi;
				break;
			}else if(taxi.getDropTime() < minDropTime) {
				availableTaxi=taxi;
				minDropTime=taxi.getDropTime();
			}
		}
		
		if(availableTaxi !=null) {
			availableTaxi.assignCustomer(customerId,pickupPoint,dropPoint,pickupTime);
		}else {
			System.out.println("Booking rejected");
		}
	}

	public void displayTaxiDetails() {
		for(Taxi taxi:taxis) {
			System.out.println("Taxi-"+taxi.getTaxiId()+ "Total Ernings:Rs."+taxi.getEraings());;
		}
		
	}
}
