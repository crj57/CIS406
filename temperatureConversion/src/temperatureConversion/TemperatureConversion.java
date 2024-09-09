//Caitlyn Janiszewski CIS406 Temperature Converter
package temperatureConversion;
import java.util.Scanner;

public class TemperatureConversion {
	
	public static void main(String[] args) {
		//Intro
		System.out.println("Welcome to the Temperature Converter");
		
		//Create scanner object
		Scanner input = new Scanner(System.in); 
		
		//Get fahrenheit temp from user
		System.out.print("\nEnter degrees in Fahrenheit: ");
		double fTemp = input.nextDouble();
		
		//Convert to Celsius
		double cTemp = (fTemp - 32) * 5.0/9;
		System.out.println("Degrees in Celsius: " + (int)cTemp);
		
		//Get celsius temp from user
		System.out.print("\nEnter degrees in Celsius: ");
		cTemp = input.nextDouble();
				
		//Convert to fahrenheit
		fTemp = cTemp * (9.0/5) + 32;
		System.out.println("Degrees in Fahrenheit: " + (int)fTemp);
		
		//Exit
		System.out.println("\n\nBye!!");
		input.close();
	}
}
