//Caitlyn Janiszewski CIS406 Powers Table
package powersTable;
import java.util.Scanner;

public class PowersTable {
	

	public static void main(String[] args) {
		int userNum;
		String keepGoing;
		
		//intro
		System.out.println("Welcome to the Squares and Cubes table");
		
		//create scanner
		Scanner input = new Scanner(System.in);
		
		//Get user input
		do {
			String powTable = "";
			System.out.print("\nEnter an integer: ");
			userNum = input.nextInt();
			
			//create table header 
			powTable += "\nNumber  Square  Cubed";
			powTable += "\n======  ======  =====\n";
			
			//add numbers to table
			for (int i = 1; i <= userNum; i++) {
				powTable += (i + "\t" + (i*i) + "\t" + (i*i*i) + "\n");
			}
			
			System.out.println(powTable);
			
			System.out.print("Continue? y/n: ");
			keepGoing = input.next().toLowerCase();
		} while (!keepGoing.equals("n"));
		
		//exit
		input.close();
		System.out.println("\nBye!!");
	}

}
