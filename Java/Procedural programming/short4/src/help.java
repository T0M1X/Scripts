import java.util.Scanner;

public class help {
	public static void main(String args[]) {
		questions();
	}
	
//This function allows the user to input a string a then it will return that string.
	public static String inputString() {
		Scanner scanner = new Scanner(System.in);
		String textInput;

		textInput = scanner.nextLine();
		return textInput;
	}

//This function allows the user to input an integer and it contains validation so that they cannot enter another data type.
	public static int inputInt() {
		Scanner scanner = new Scanner(System.in);
		int intInput;
		boolean isInt;
		intInput = 0;
		isInt = false;
		do {
			while (!scanner.hasNextInt()) {
				System.out.println("Please enter a number");
				scanner.nextLine();
			}
			intInput = scanner.nextInt();
			isInt = true;
			break;
		} while (isInt == false);
		return intInput;
	}
	
//This method is the creation method for the Station class.
	public static Station createStation(String name, boolean stepFree, int distance) {
		Station a = new Station();
		
		a.name = name;
		a.stepFree = stepFree;
		a.distance = distance;
		
		return a;
	}

//This method prints out the details for the station that the user requests.
	public static void stationDetails(Station b) {
		if (b.stepFree == true) {
			System.out.println(b.name + " does have free access.");
		} else {
			System.out.println(b.name + " does not have free access.");
		}
		System.out.println("It is " + b.distance + "m from the entrance to the platform.");
	}
	
//This method creates the station records and then creates the for loop that allows the user ask about the station they want to know about.
	public static void questions() {
		Station mile_end = createStation("Mile End", false, 100);
		Station west_harrow = createStation("West Harrow", false, 20);
		Station farringdon = createStation("Farringdon", false, 300);
		Station wembley_park = createStation("Wembley Park", true, 120);
		int count;
		String request;
		
		System.out.println("How many stations do you need to know about?");
		count = inputInt();
		while (count < 1) {
			System.out.println("Please enter a positive number.");
			count = inputInt();
		}
		for (int i = 0; i < count; i++){
			System.out.println("\nWhat station do you need to know about? ");
			request = inputString();
			if ((request.toLowerCase()).equals("mile end")) {
				stationDetails(mile_end);
			} else if ((request.toLowerCase()).equals("west harrow")) {
				stationDetails(west_harrow);
			} else if ((request.toLowerCase()).equals("farringdon")) {
				stationDetails(farringdon);
			} else if ((request.toLowerCase()).equals("wembley park")) {
				stationDetails(wembley_park);
			} else {
				System.out.println("That station is not in our database.");
			}
		}
	}
}

//This is the declaration for the station method.
class Station{
	String name;
	boolean stepFree;
	int distance;
}
