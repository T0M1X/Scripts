import java.util.Scanner;

public class topGoalScorers {

	public static void main(String [] args) {
		questions();
	}

//This function allows the user to input a string a then it will return that string.
	public static String inputString(String text) {
		Scanner scanner = new Scanner(System.in);
		String textInput;
		
		System.out.println(text);
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
	
//This function creates the arrays and asks the user for data. It then outputs highest scorer and details of the players.
	public static void questions() {
		String[] names = new String[4];
		int[] scores = new int[4];
		String[] country = new String[4];
		int largestNumber = 0;
		int largestLocation = 0;
		int total = 0;
		for (int i=0; i <4; i++) {
			names = assign(names, inputString("\nName footballer " + (i+1) + "?"), i);
			System.out.println("How many goals did they score?");
			scores[i] = inputInt();
			total = total+scores[i];
			if (scores[i] > largestNumber) {
				largestNumber = scores[i];
				largestLocation = i;
			}
			country[i] = inputString("What country did they play for?");
		}
		System.out.println("\nThe highest scorer was " + names[largestLocation] + ".");
		System.out.println("These players score " + total + " goals between them.");
		
		System.out.println("\nThe details of the players are: ");
		for (int i=0; i <4; i++) {
			System.out.println(names[i] + ", " + country[i] + ", " + scores[i]);
		}
	}
	
//This variable assigns a value to a string array
	public static String [] assign(String[] array, String theInput, int pos) {
		array[pos] = theInput;
		return array;
	}
}
