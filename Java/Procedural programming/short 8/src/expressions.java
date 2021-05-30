import java.util.Scanner;

public class expressions{
	public static void main(String [] args) {
		run();
	}
	
//This method allows the user to input the expression and then run the recursive methods
	public static void run() {
		String expression;
		int length;
		String[] answer;
		
		System.out.println("Please input the expression ");
		expression = input();
		length = expression.length();
		
		String[] arr = new String[length];
		
		arr = assign(arr,expression,length,0);
		
		answer = recurse(arr, length, (length - 1));
		System.out.println("The answer is " + answer[0]);
	}
	
//This is a recursive method used to assign the values of the string into an array
	public static String[] assign(String[] temp, String text, int length, int i) {
		temp[i] = Character.toString(text.charAt(i));
		i=i+1;
		if (i < length) {
			temp = assign(temp,text,length,i);
		}
		return temp;
	}
	
//This is the recursive method used to do the calculation for each function that the user inputs
	public static String[] recurse(String [] exp,int length,int i) {
		
		if (isNumb(exp[0]) == true) {
			return exp;
		}
		if (isNumb(exp[i]) == true) {
			recurse(exp,length,i-1);
		} else {
			if (exp[i].equals("+")) {
				exp[i] =  Integer.toString(Integer.parseInt(exp[i+1]) +  Integer.parseInt(exp[i+2]));
				recurse(exp,length,i-1);
			} else if (exp[i].equals("-")) {
				exp[i] =  Integer.toString(Integer.parseInt(exp[i+1]) -  Integer.parseInt(exp[i+2]));
				recurse(exp,length,i-1);
			} else if (exp[i].equals("&")) {
				exp[i] = Integer.toString(sum(Integer.parseInt(exp[i+1]),0,0));
				recurse(exp,length,i-1);
			} else if (exp[i].equals("*")) {
				exp[i] =  Integer.toString(Integer.parseInt(exp[i+1]) *  Integer.parseInt(exp[i+2]));
			} else {
				System.out.println(exp[i] + " is an illegal character. Terminating program...");
				System.exit(0);
			}
		}
		return exp;
	}
	
//This is a recursive method used to complete the & calculation
	public static int sum(int num, int i, int total) {
		if (i <= num) {
			total = total + i;
			total = sum(num, i+1, total);
		}
		return total;
	}
	
//This function is used to check whether or not a value is a number
	public static boolean isNumb(String num) {
		boolean check;
		int test;
		check = true;
	    if (num == null) {
	        check = false;
	    }
	    try {
	        test = Integer.parseInt(num);
	    } catch (NumberFormatException nfe) {
	        check = false;
	    }
	    return check;
	}
	
	
//This function allows the user to input a string a then it will return that string.
	public static String input() {
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
}