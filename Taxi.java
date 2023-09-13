package carTaxiApp;

public class Taxi {
	private static int taxiCount=0;
	private int taxiId;
	private String currentPoint;
	private int eraings;
	private int dropTime;
	
	public Taxi(String startPoint) {
		taxiCount++;
		setTaxiId(taxiCount);
		setCurrentPoint(startPoint);
		setEraings(0);
		setDropTime(0);
	}

	public int getTaxiId() {
		return taxiId;
	}

	public void setTaxiId(int taxiId) {
		this.taxiId = taxiId;
	}

	public String getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(String currentPoint) {
		this.currentPoint = currentPoint;
	}

	public int getEraings() {
		return eraings;
	}

	public void setEraings(int eraings) {
		this.eraings = eraings;
	}

	public int getDropTime() {
		return dropTime;
	}

	public void setDropTime(int dropTime) {
		this.dropTime = dropTime;
	}
	
	public void assignCustomer(int customerId, String pickupPoint, String dropPoint, int pickupTime) {
		
		int distance=calculateDistance(currentPoint,pickupPoint);
		int travelTime=calculateTravelTime(distance);
		int fare=calculateFare(distance);
		
		 dropTime = pickupTime + travelTime;
	        currentPoint = dropPoint;
	        eraings += fare;
	        
	        // Print booking information
	        System.out.println("Taxi-" + taxiId + " is allotted");
	        System.out.println("Taxi No: " + taxiId);
	        System.out.println("BookingID\tCustomerID\tFrom\tTo\tPickupTime\tDropTime\tAmount");
	        System.out.println("   " + taxiId + "\t\t   " + customerId + "\t\t  " + pickupPoint + "\t   " + dropPoint +
	                           "\t     " + pickupTime + "\t\t    " + dropTime + "\t\t " + fare);
	}

	private int calculateFare(int distance) {
		int initialCharge=100;
		int additionalCharge=(distance > 5)?(distance-5)*10:0;
		
		return initialCharge + additionalCharge;
	}

	private int calculateTravelTime(int distance) {
		
		return distance/15*60;
	}

	private int calculateDistance(String fromPoint, String toPoint) {
		char fromChar=fromPoint.charAt(0);
		char toChar=toPoint.charAt(0);
		
		return Math.abs(fromChar-toChar)*15;
	}
	
}

