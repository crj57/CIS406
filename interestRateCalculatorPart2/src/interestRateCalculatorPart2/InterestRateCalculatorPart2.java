//Caitlyn Janiszewski CIS406 Interest Rate Calculator Part 2
package interestRateCalculatorPart2;
import java.util.Scanner; 
import java.util.InputMismatchException;

public class InterestRateCalculatorPart2 {
	
	static double getData(Scanner input, String prompt) {
		double num = 0;
		boolean validInput = false; 
		
		while (!validInput) {
			validInput = true; 
			try {
				System.out.print(prompt);
				String inputString = input.nextLine();
				if (inputString.contains(",")) {
					throw new InputMismatchException("");
				} 
				num = Double.parseDouble(inputString);
			} catch (Exception e) {
				System.out.println("Error! Invalid numeric value. Try again.");
				validInput = false;
			}
		}
		return num; 
		
	}
	
	static double calculateAmount(double amount, double rate) {
		double interestAmount = amount * (rate/100); 
		return interestAmount;
	}

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
			loanAmount = getData(input, "\nEnter loan amount: ");
			rate = getData(input, "\nEnter interest rate: ");
			
			interestAmount = calculateAmount(loanAmount, rate);
	
			//display
			System.out.println("\nLoan amount:		$" + String.format("%,.2f",loanAmount));
			System.out.println("Interest rate:		" + rate + "%");
			System.out.println("Interest:		$" + String.format("%,.2f", interestAmount) + "\n");
			
			System.out.print("Continue? (y/n): ");
			keepGoing = input.nextLine().toLowerCase();
			
		}
		
		//exit
		input.close();
		System.out.println("Bye!!!");

	}

}
