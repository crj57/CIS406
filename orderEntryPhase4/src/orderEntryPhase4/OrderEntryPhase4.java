//Caitlyn Janiszewski CIS406 Order Entry Phase 4
package orderEntryPhase4;
import java.util.Scanner;
import java.util.InputMismatchException;

public class OrderEntryPhase4 {
	final int MAX_ITEMS = 10;
	private String[] itemNumber = new String[MAX_ITEMS];
	private String[] itemDescr = new String[MAX_ITEMS];
	private double[] itemPrice = new double[MAX_ITEMS];
	private int[] quantity = new int[MAX_ITEMS];
	private double[] taxPercent = new double[MAX_ITEMS];
	private double[] discount = new double[MAX_ITEMS];
	private double[] discountPercent = new double[MAX_ITEMS];
	private double[] netCost = new double[MAX_ITEMS];
	private double[] grossCost = new double[MAX_ITEMS];
	private double[] tax = new double[MAX_ITEMS];
	private String keepGoing = "y";
	private int itemCount = 0; 
	private double allGross = 0;
	private double allTax; 
	private double allDiscount;
	private double allNet;
	private String name;
	private String date;
	private String address;
	private String city;
	private String state;
	private String zip;
	
	private void getData() {
		//create scanner object
		Scanner input = new Scanner(System.in);
		
		//get customer info
		System.out.print("Enter invoice date (MM/DD/YY): ");
		date = input.nextLine();
		System.out.print("Enter customer name: ");
		name = input.nextLine();
		System.out.print("Enter street address: ");
		address = input.nextLine();
		System.out.print("Enter city: ");
		city = input.nextLine();
		System.out.print("Enter state (2 letters): ");
		state = input.nextLine();
		System.out.print("Enter zip (5 digits): ");
		zip = input.nextLine();
		System.out.println();
		
		
		
		
		
		//get inputs 
		while (!keepGoing.equals("n")) {
			System.out.print("Enter item number: ");
			itemNumber[itemCount] = input.nextLine();
			
			System.out.print("Enter item description: ");
			itemDescr[itemCount] =  input.nextLine();
			
			try {
				System.out.print("Enter item price: $");
				itemPrice[itemCount] = input.nextDouble();
			} 
			catch (InputMismatchException e) {
				System.out.println("Invalid entry. Program is ending.");
				break;
			}
			
			
			try {
				System.out.print("Enter quantity ordered: ");
				quantity[itemCount] = input.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid entry. Program is ending.");
				break;
			}
			
			try{
				System.out.print("Enter tax percentage for item: ");
				taxPercent[itemCount] = input.nextDouble();
			} 
			catch (InputMismatchException e) {
				System.out.println("Invalid entry. Program is ending.");
				break;
			}
			
			try {
				System.out.print("Enter total discount percentage: ");
				discountPercent[itemCount] = input.nextDouble();
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid entry. Program is ending.");
				break;
			}
			
			
			//Calculations 
			grossCost[itemCount] = quantity[itemCount] * itemPrice[itemCount];
			//System.out.println("Gross cost: " + grossCost);
			
			tax[itemCount] = grossCost[itemCount] * taxPercent[itemCount];
			//System.out.println("Tax amount: "+ tax);
			
			discount[itemCount] = (grossCost[itemCount] + tax[itemCount]) * discountPercent[itemCount];
			//System.out.println("Discount amount: "+ discount);

			netCost[itemCount] = (quantity[itemCount] * itemPrice[itemCount]) + tax[itemCount] - discount[itemCount];
			//System.out.println("Net amount for item: " + netCost);
			
			System.out.print("Enter another item? y/n: ");
			input.nextLine();
			keepGoing = input.nextLine().toLowerCase();
		
			
			//Increment totals
			
			allGross += grossCost[itemCount];
			allTax += tax[itemCount];
			allDiscount += discount[itemCount];
			allNet += netCost[itemCount];
			itemCount += 1;
			
		}
	input.close();
	
	System.out.println("Invoice Date:	"+ date);
	System.out.println("Customer Information:\n"
			+ "\nName"
			+ "\t\tAddress"
			+ "\t\tCity"
			+ "\t\tState"
			+ "\t\tZip Code");
	System.out.println(name +"\t\t" 
			+ address + "\t" 
			+ city + "\t\t" 
			+ state + "\t\t" 
			+ zip + "\n");
	
	
	System.out.println("Order Details:\n" 
				+ "\nItem Number "
				+ "\tItem Description "
				+ "\tPrice "
				+ "\t\tQuantity "
				+ "\tGross Cost "
				+ "\tTax Percent "
				+ "\tTax "
				+ "\tDiscount Percent "
				+ "\tDiscount "
				+ "\tNet Cost");
	//loop thru array to print each item 
	for (int i = 0; i < itemCount; i++) {
		System.out.println("\n\t" 
				+ itemNumber[i] + "\t\t" 
				+ itemDescr[i] + "\t\t$" 
				+ String.format("%.2f",itemPrice[i]) + "\t\t" 
				+ quantity[i] + "\t\t" 
				+ String.format("%.2f",grossCost[i]) + "\t\t" 
				+ taxPercent[i] + "\t\t$" 
				+ String.format("%.2f",tax[i]) + "\t\t" 
				+ discountPercent[i] + "\t\t$" 
				+ String.format("%.2f",discount[i]) + "\t\t$" 
				+ String.format("%.2f",netCost[i]));
	}
	
	
	//print totals
	System.out.println("\nTotals:\t "
			+ "Number of Items\t "
			+ "Total Gross\t     "
			+ "Total Tax\t "
			+ "Total Discount\t   "
			+ "Total Net\n\t\t" 
			+ itemCount + "\t\t\t$" 
			+ String.format("%.2f",allGross) + "\t\t$" 
			+ String.format("%.2f",allTax) + "\t\t$" 
			+ String.format("%.2f",allDiscount) + "\t\t$" 
			+ String.format("%.2f",allNet));
	
	}
	
	
	public static void main(String[] args) {
		//create order
		OrderEntryPhase4 myOrder = new OrderEntryPhase4();
		myOrder.getData();		
	}

}
