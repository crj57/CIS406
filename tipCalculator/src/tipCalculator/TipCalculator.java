//Caitlyn Janiszewski CIS406 Tip Calculator 
package tipCalculator;
import java.util.Scanner;

public class TipCalculator {

	public static void main(String[] args) {
		//declare variables
		double mealCost;
		double tip;
		double total;
		String keepGoing = "y";
		
		System.out.println("Tip Calculator\n");
		
		//create scanner
		Scanner input = new Scanner(System.in);
		
		//loop
		while (!keepGoing.equals("n")) {
			//get input
			System.out.print("Cost of meal: ");
			mealCost = input.nextDouble();
			System.out.println();
		
			
			for (double i = 0.15; i <= 0.25; i += 0.05) {
				System.out.println(i*100 + "%");
				tip = mealCost * i; 
				total = mealCost + tip;
				System.out.println("Tip amount:	$" + String.format("%.2f", tip));
				System.out.println("Total amount:	$" + String.format("%.2f", total));
			}
			
			System.out.print("Continue? (y/n): ");
			keepGoing= input.next().toLowerCase();
		}
		
		//exit
		input.close();
		System.out.println("Bye!!!");		
	}

}
