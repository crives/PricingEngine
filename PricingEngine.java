import java.util.HashMap;
import java.util.Scanner;

public class PricingEngine {

	static int choice = 0;
	static String vehicleType;
	static String pricingMethod;
	static String pricingUnit;
	static int num_units;
	static int num_vehicles;
	static int vehicleTypeRate;
	
	private static Scanner sc = new Scanner(System.in);
	static HashMap<String, Double> pricingMap = new HashMap<>();
	
	public static void main(String[] args) {
	
		welcome();
		
	}

	public static void welcome() {
		
			do {
			System.out.println("---- Welcome to CharterUP Quote Generator! ----");
			System.out.println("\nWhich vehicle type would you like to rent?");
			System.out.print("\n1. Charter Bus");
			System.out.print("\n2. Mini Bus");
			System.out.print("\n3. Sprinter");
			System.out.print("\n4. Party Bus");
			System.out.print("\n5. Sedan");
			System.out.print("\n6. SUV");
			System.out.print("\n7. Limousine");
			System.out.print("\n8. Trolley");
			System.out.println("\n9. Exit");
			System.out.print("\nEnter Choice (1 - 8):");
			
			choice = Integer.parseInt(sc.nextLine().trim());
			
			} while(choice > 9 || choice < 0 && choice != 9);
			
			switch(choice) {
			case 1:
				vehicleType = "Charter Bus";
				pricingMap.put("Daily", 1000.00);
				pricingMap.put("Hourly", 400.00);
				pricingMap.put("Distance", 3.50);
				
				numberVehicles();
				break;
			case 2: 
				vehicleType = "Mini Bus";
				
				pricingMap.put("Daily", 925.00);
				pricingMap.put("Hourly", 360.00);
				pricingMap.put("Distance", 3.25);

				numberVehicles();
				break;
			case 3: 
				vehicleType = "Sprinter";
				
				pricingMap.put("Daily", 850.00);
				pricingMap.put("Hourly", 320.00);
				pricingMap.put("Distance", 3.00);

				numberVehicles();
				break;
			case 4: 
				vehicleType = "Party Bus";
				
				pricingMap.put("Daily", 775.00);
				pricingMap.put("Hourly", 280.00);
				pricingMap.put("Distance", 2.75);
				
				numberVehicles();
				break;
			case 5: 
				vehicleType = "Sedan";
				
				pricingMap.put("Daily", 700.00);
				pricingMap.put("Hourly", 240.00);
				pricingMap.put("Distance", 2.50);
				
				numberVehicles();
				break;
			case 6: 
				vehicleType = "SUV";
				
				pricingMap.put("Daily", 625.00);
				pricingMap.put("Hourly", 200.00);
				pricingMap.put("Distance", 2.25);
				
				numberVehicles();
				break;
			case 7:
				vehicleType = "Limousine";
				
				pricingMap.put("Daily", 550.00);
				pricingMap.put("Hourly", 160.00);
				pricingMap.put("Distance", 2.00);
				
				numberVehicles();
				break;
			case 8:
				vehicleType = "Trolley";
				pricingMap.put("Daily", 475.00);
				pricingMap.put("Hourly", 120.00);
				pricingMap.put("Distance", 1.75);
				
				numberVehicles();
				break;
			case 9: 
				System.out.println("Goodbye.");	
				break;
			}			
	}

	static void numberVehicles() {
		System.out.println("How many vehicles would you like to rent?");
		
		num_vehicles = Integer.parseInt(sc.nextLine().trim());
		
		pricingMethod();
	}

	
	private static void pricingMethod() {
		
		do {
		System.out.println("For which pricing method would you like?");
		System.out.print("\n1. Daily");
		System.out.print("\n2. Hourly");
		System.out.print("\n3. Distance (miles)");
		System.out.print("\nEnter Choice (1 - 3) :");
		
		choice = Integer.parseInt(sc.nextLine().trim());

		} while(choice > 3 || choice < 0 && choice != 3);
	
		switch(choice) {
		case 1:
			pricingMethod = "Daily";
			pricingUnit = "days";
			
			unitNumber(pricingUnit);
			generateQuote(pricingMethod, vehicleType, num_vehicles, num_units, pricingMap, pricingUnit);
			break;
		case 2: 
			pricingMethod = "Hourly";
			pricingUnit = "hours";
			
			unitNumber(pricingUnit);
			generateQuote(pricingMethod, vehicleType, num_vehicles, num_units, pricingMap, pricingUnit);
			break;	
		case 3:
			pricingMethod = "Distance";
			pricingUnit = "miles";
			
			unitNumber(pricingUnit);
			generateQuote(pricingMethod, vehicleType, num_vehicles, num_units, pricingMap, pricingUnit);
			break;
		case 9: 
			System.out.println("Goodbye.");	
			break;
	}			

	}

	private static void unitNumber(String pricingUnit) {

		System.out.println("For how many " + pricingUnit + " would you like to rent?");
		
		num_units = Integer.parseInt(sc.nextLine().trim());
	}


	private static void generateQuote(String pricingMethod2, String vehicleType2, int num_vehicles2, int num_units2, HashMap<String, Double> map, String pricingUnit2) {
		
		Double rate = map.get(pricingMethod2);
		
		Double price = rate * num_vehicles2 * num_units2;
		
		System.out.println("Your quote for " + num_vehicles2 + " " + vehicleType2 + " for " + num_units2 + " " + pricingUnit2 + " would be $" + price);
		
	}
	
}
