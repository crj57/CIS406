//Caitlyn Janiszewski CIS406 Vacation Diary Part 2
package vacationDiaryPart2;


import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class VacationDiaryPart2 {
	
	static String getDate(Scanner input, String prompt) {
		String date = "";
		boolean validInput = false; 
		
		while(!validInput) {
			validInput = true; 
			try {
				System.out.print(prompt);
				date = input.nextLine();
				if (!date.equals("end")){
					SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyy");
					sdf.setLenient(false);
					Date javaDate = sdf.parse(date);
					if (date.length() != 8) {
						throw new Exception();
					}
					String outputPattern = "MM/dd/yyyy";
					SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);
					String formattedDate = outputFormat.format(javaDate);
					return formattedDate; 
				} else {
					validInput = false;
					return date; 
				}
			} catch (Exception e) {
				System.out.println("Invalid date format. Please re-enter.");
				validInput = false; 
			}
		}
		return date;
	}
	
	static int getDays(Scanner input, String prompt) {
		int days = 0;
		boolean validInput = false; 
		
		while(!validInput) {
			validInput = true; 
			try {
				System.out.print(prompt);
				days = input.nextInt();
				input.nextLine();
				if (days < 1 | days > 30) {
					throw new Exception();
				} 
			}catch (InputMismatchException e) {
				System.out.println("Invalid number format. Please re-enter.");
				validInput = false; 
				input.next();
			}catch (Exception e) {
				System.out.println("Invalid number format. Please re-enter.");
				validInput = false; 
			}
		
		
		} 
		return days;
	}
		
	
	static String getLocation(Scanner input, String prompt) {
		String location = "";
		boolean validInput = false; 
		int length = 0;
		
		while(!validInput) {
			validInput = true; 
			try {
				System.out.print(prompt);
				location = input.nextLine();
				length = location.length();
				if (length < 15) {
					location = String.format("%-15s", location);
				}
				if (length > 15) {
					location = location.substring(0,15);
				}
				
			} catch (Exception e) {
				System.out.println("Invalid location format. Please re-enter.");
				validInput = false; 
			}
		
		
		}
		return location;
		
	}
	
	static String getMode(Scanner input, String prompt) {
		String mode = "";
		boolean validInput = false; 
		String[] modeOptions = {"car", "plane", "ship", "train", "bus"};
		int isIn = -1; 
		
		while(!validInput) {
			validInput = true; 
			try {
				System.out.print(prompt);
				mode = input.nextLine();
				for (int i = 0; i < modeOptions.length; i++) {
					if (modeOptions[i].equalsIgnoreCase(mode)) {
						isIn = 1;
					} 
				}
				if (isIn < 0) {
					throw new Exception();
				}
				
			}catch (Exception e) {
				System.out.println("Invalid mode. Please re-enter.");
				validInput = false; 
			}
		
		}
		return mode; 
	}

	public static void main(String[] args) {
		int numStop = 0;
		final int MAX_STOPS = 10;
		String startDate[] = new String[MAX_STOPS];
		String city[] = new String[MAX_STOPS];
		String country[] = new String[MAX_STOPS];
		int numDays[] = new int[MAX_STOPS];
		String mode[] = new String[MAX_STOPS];
		String keepGoing = "";
		
		
		
		System.out.println("Vacation Diary");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		
		while (!keepGoing.equals("end")) {
			startDate[numStop] = getDate(input, "Enter Date Vacation Started (mmddyyyy): ");
			if (startDate[numStop].equals("end")) {
				break;
			}
			
			city[numStop] = getLocation(input, "Enter City Visited: ");
			country[numStop] = getLocation(input, "Enter Country Visited: ");
			
			numDays[numStop] = getDays(input, "Enter Number of days: ");
			
			mode[numStop] = getMode(input, "Enter Mode of Travel (car, airplane, ship, train, bus): ");
			
			keepGoing = startDate[numStop];
			numStop += 1;
			}
			
		
		
		
		System.out.println("================================================================");
		System.out.println("==========================Vacation Diary========================");
		System.out.println("Date\t\tCity\t\tCountry\t\tDays\tMode");
		System.out.println("========\t========\t========\t====\t========");
		for (int i = 0; i < numStop; i++) {
			System.out.println(startDate[i] + "\t" 
					+ city[i] + "\t"
					+ country[i] + "\t"
					+ numDays[i] + "\t"
					+ mode[i]);
		}
		System.out.println("=================================================================");
				
		input.close();
		System.out.println("\nBye!!");
		
		
	}

}
