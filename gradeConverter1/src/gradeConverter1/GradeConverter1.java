//Caitlyn Janiszewski CIS 406 Grade Converter
package gradeConverter1;
import java.util.Scanner;

public class GradeConverter1 {

	public static void main(String[] args) {
		//intro
		System.out.println("Welcome to the Letter Grade Converter\n");
		//create scanner
		Scanner input = new Scanner(System.in);
		int grade; 
		String toContinue = "y";
		String letterGrade;
		
		
		//while loop
		while (!toContinue.equals("n")) {
			
			//get numeric grade
			System.out.print("Enter numerical grade: ");
			grade = input.nextInt();
			
			//if statement to find letter grade
			if (grade >= 90) {
				letterGrade = "A";
			} else if (grade >= 80) {
				letterGrade = "B";
			} else if (grade >= 70) {
				letterGrade = "C";
			} else if (grade >= 60) {
				letterGrade = "D";
			} else {
				letterGrade = "F";
			}
			
			//display letter grade 
			System.out.print("Letter grade: " + letterGrade);
			
			//prompt to continue 
			System.out.print("\nContinue? (y/n): ");
			toContinue = input.next().toLowerCase();
			
		}
		//exit
		input.close();
		System.out.println("Bye!!");
		
	}

}