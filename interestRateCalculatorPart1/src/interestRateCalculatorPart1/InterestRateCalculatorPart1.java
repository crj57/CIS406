//Caitlyn Janiszewski CIS 406 Interest Rate Calculator Part 1
package interestRateCalculatorPart1;
import java.util.Scanner; 

public class InterestRateCalculatorPart1 {

	public static void main(String[] args) {
		//declare variables
		double loanAmount;
		double rate; 
		double interestAmount; 
		String keepGoing = "y";
		
		System.out.println("Welcome to the Interest Calculator");
		
		
		//create scanner
		Scanner input = new Scanner(System.in);
		
		while (!keepGoing.equals("n")){
			System.out.print("\nEnter loan amount:	");
			loanAmount = input.nextDouble();
			
			System.out.print("Enter interest rate:	");
			rate = input.nextDouble();
			
			interestAmount = loanAmount * (rate/100); 
	
			//display
			System.out.println("\nLoan amount:		$" + String.format("%,.2f",loanAmount));
			System.out.println("Interest rate:		" + rate + "%");
			System.out.println("Interest:		$" + String.format("%,.2f", interestAmount) + "\n");
			
			System.out.print("Continue? (y/n): ");
			keepGoing = input.next().toLowerCase();
		}
		
		//exit
		input.close();
		System.out.println("Bye!!!");

	}

}
