import java.util.Scanner;

public class passengers {
	
	public static void main(String [] args) {
		loop();
	}
	
//This function allows the user to input a string a then it will return that string.
	public static String inputString(String text) {
		Scanner scanner = new Scanner(System.in);
		String textInput;
		
		System.out.println(text);
		textInput = scanner.nextLine();
		return textInput;
	}
	
//This method contains the loop that will ask the user for the number of passengers on the bus until the user enters "x".
	public static void loop() {
		int totalP = 0;
		int totalB = 0;
		boolean finished = true;
		String userInput;
		int userInt;
		System.out.println("Enter 'x' when you wish to quit the program.\n");
		while (finished == true) {
			userInput = inputString("How many passengers were on the bus?");
			if (userInput.toLowerCase().equals("x")) {
				System.out.println("There were a total of " + totalP + " passengers on " + totalB + " buses.");
				break;
			} else {
				userInt = Integer.parseInt(userInput);
				totalP = totalP + userInt;
				totalB = totalB + 1;
			}
		}
	}
}
