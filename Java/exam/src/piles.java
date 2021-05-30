import java.util.Scanner;

public class piles {
	public static void main(String args[]) {
		questions();
	}

//This function ask the user for the size of their top counter and their bottom counter. It contains a lot of validation so the user must enter a suitable number.
	public static void questions() {
		int top = 2;
		int bottom = 0;
		
		while (top > bottom) {
			System.out.println("The top must be smaller than the bottom");
			top = 2;
			bottom = 0;
			while ((top%2) == 0) {
				System.out.println("What is the size of the top counter");
				System.out.println("Please enter an odd number");
				top = inputInt();
			}
			while ((bottom%2) == 0) {
				System.out.println("What is the size of the bottom counter");
				System.out.println("Please enter an odd number");
				bottom = inputInt();
			}
		}
		stringLoop(top,bottom);
	}
	
//This function runs the loop that will print out each line of the picture.
	public static void stringLoop(int top, int bottom) {
		int lines;
		String currentLine;
		
		lines = bottom - top;
		lines = lines / 2;
		
		for (int i = 0; i <= lines; i++) {
			currentLine = createString(bottom,(top + i*2));
			System.out.println(currentLine);
		}
	}
	
//This function creates each line of text for the picture.
	public static String createString(int length, int signs) {
		String line = "";
		int spaces;
		
		spaces = length - signs;
		line = addSpaces(line,spaces/2);
		line = addEquals(line,signs);
		line = addSpaces(line,spaces/2);
		
		return line;
	}

//This function adds the spaces for the current line
	public static String addSpaces(String newLine, int repeats) {
		String space = " ";
		
		for (int i = 0; i < (repeats); i++) {;
			newLine = newLine + space;
		}
		
		return newLine;
	}
	
//This function adds the equal signs for the current line
	public static String addEquals(String newLine, int repeats) {
		String equalSign = "=";
		
		for (int i = 0; i < (repeats); i++) {;
			newLine = newLine + equalSign;
		}
		return newLine;
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
}
