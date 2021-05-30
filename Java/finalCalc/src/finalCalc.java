import java.util.Scanner;

public class finalCalc{
	
	public static void main(String args[]) {
		start();
	}
	
//The main function runs all the other functions and also contains the validations for values that cannot be accepted e.g. negative values.
	public static void start(){
		int start;
		int paid;
		double finalAmount;
		start = startYear();
		paid = paidNow();
		while (paid < 0){
			System.out.println("Please enter positive values.");
			paid = paidNow();
		}
		while (paid > start) {
			System.out.println("You cannot pay more than your start amount. Please enter the correct amounts.");
			start = startYear();
			paid = paidNow();
		}
		finalAmount = calculation(start,paid);
		while (finalAmount < 0) {
			System.out.println("Please enter positive values.");
			start = startYear();
			paid = paidNow();
			finalAmount = calculation(start,paid);
		}
		output(finalAmount);
		System.exit(0);
	}
	
	public static int startYear(){ //The startYear function simply asks for the loan amount at the start of the year and returns it.
		int start;
		String textInput;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Amount of loan at start of year?");
		textInput = scanner.nextLine();
		start = Integer.parseInt(textInput);
		return start;
	}
	
	public static int paidNow(){ //The paidNow function simply asks how much has been paid off this year and returns it.
		int paid;
		String textInput;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Amount paid off this year?");
		textInput = scanner.nextLine();
		paid = Integer.parseInt(textInput);
		
		return paid;
	}
	
	//The calculation function takes the loan amount and paid amount and runs the interest calculation using a formula I created.
	public static double calculation(int startAmount,int paidAmount) {
		double newAmount;
		double finalAmount;
		double intrestRate = 0.07;
		
		newAmount = startAmount - paidAmount;
		finalAmount = (newAmount * intrestRate) + newAmount;
		
		return finalAmount;
	}
	
	//This is the rounding function for the final calculation. It rounds the final amount to 1 decimal place.
	public static void output(double endAmount) { 
		int temp;
		
		endAmount = endAmount * 10;
		temp = (int)endAmount;
		endAmount = (double)temp;
		endAmount = endAmount / 10.0;
		System.out.println("The new amount owed is (in pounds):" + endAmount);
	}
}