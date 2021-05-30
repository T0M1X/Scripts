import java.util.Scanner;

public class bodyAge {
	
	public static void main(String args[]) {
		calculation();
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
	

// This function asks the user to enter their age and does not allow the user to enter negative numbers.
	public static int askAge() {
		int age;
		System.out.println("What is your age?");
		
		age = inputInt();
		while (age < 5 | age > 120) {
			System.out.println("Please enter a number between 5 - 120.");
			age = inputInt();
		}
		return age;
	}
	
// This function asks the user to enter their heart rate and does not allow the user to enter negative numbers.
	public static int askHeartRate() {
		int heartRate;
		System.out.println("What is your heart rate?");
		
		heartRate = inputInt();
		while (heartRate < 1) {
			System.out.println("Please enter a positive number.");
			heartRate = inputInt();
		}
		return heartRate;
	}
	
// This function asks the user to enter their stretch and does not allow the user to enter negative numbers.
	public static int askStretch() {
		int stretch;
		System.out.println("How far can you stretch?");
		
		stretch = inputInt();
		while (stretch < 1) {
			System.out.println("Please enter a positive number.");
			stretch = inputInt();
		}
		return stretch;
	}

//This function changes the body age according to the heart rate input and the stretch input.
	public static void calculation() {
		int age;
		int heart;
		int stretch;
		
		age = askAge();
		heart = askHeartRate();
		stretch = askStretch();
		
		if (heart < 62) {
			age = age - 5;
		} else if (heart >=  62 & heart <= 64) {
			age = age -1;
		} else if (heart >= 65 & heart <= 70) {
			age = age + 1;
		} else {
			age = age + 2;
		}
		
		if (stretch < 20) {
			age = age + 4;
		} else if (stretch >= 20 & stretch <= 32) {
			age = age + 1;
		} else if (stretch > 37) {
			age = age - 3;
		}
		System.out.println("Your body's age is " + age);
	}
}
