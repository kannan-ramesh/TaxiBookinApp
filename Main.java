package carTaxiApp;

public class Main {

	public static void main(String[] args) {
		BookingSystem bookingSystem=new BookingSystem();
		
		bookingSystem.initializeTaxis();
		
		bookingSystem.bookTaxi(1,"A","B",9);
		bookingSystem.bookTaxi(2,"B","D",9);
		bookingSystem.bookTaxi(3,"B","C",12);
		
		bookingSystem.displayTaxiDetails();
	}

}
