import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class flowDiary {

	public static void main(String args[]) {
		questioning();	
	}
	
	public static void questioning() {
		int dangerLevel;
		int day;
		int temp;
		int[] zeros = {0,0,0};
		int table[][] = new int[2][31];
		result entry = createResult(0,zeros);
		
		System.out.println("What is your danger level?");
		dangerLevel = inputInt();
		
		for (int i = 0; i < 31; i++) {
			System.out.println("Enter 0 when you would like to quit");
			System.out.println("Please enter the day of the month");
			day = inputInt();
			while (day < 0 | day > 31) {
				System.out.println("Please enter a number between 0 and 31");
				day = inputInt();
			}
			if (day == 0) {
				break;
			}
			setDay(entry, day);
			
			for (int j = 0; j <= 2; j++) {
				System.out.println("Please enter reading number " + (j+1));
				temp = inputInt();
				while (temp < 0 | temp > 800) {
					System.out.println("Please enter a number between 0 and 800");
					temp = inputInt();
				}
				setResults(entry, temp, j);
			}
			calculatePeak(entry);
			if (getPeakFlow(entry) < dangerLevel) {
				System.out.println("You should go to the hospital due to a low peak reading.");
			}
			table[0][i] = getDay(entry);
			table[1][i] = getPeakFlow(entry);
		}
		
		saveResults(table);
	}
	
	
//This method will create a new file that will be used to store the results
	public static void createResultsFile() {
		try {
			File file = new File("Results.txt");
			if (file.createNewFile()) {
				System.out.println("Results file created.");
			} else {
				System.out.println("Results file already exists.");
			}
		} catch (IOException e) {
			System.out.println("A file error occured");
		}
	}
	

//This method will save a new result inside the file
	public static void saveResults(int[][] values) {
		try {
			File file = new File("Results.txt");
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
			int length = arrayLength(values);
			for (int i = 0; i < (length);i++) {
				writer.write(values[0][i] + "," + values[1][i]);
				System.out.println(values[0][i] + "," + values[1][i]);
				writer.newLine();
			}
			writer.close();
			System.out.println("Your result has been added to the file.");
		} catch (IOException e) {
			System.out.println("A file error occured");
		}
	}

	public static int arrayLength(int[][] data) {
		int length = 0;
		for (int i = 0; i < 31; i++) {
			if (data[0][i] != 0) {
				length = length + 1;
			}
		}
			
		return length;
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
	
	public static result createResult(int newDay, int[] newResults) {
		result result = new result();
		result.day = newDay;
		result.results = newResults;
		calculatePeak(result);
		
		return result;
	}
	
	public static void calculatePeak(result a) {
		int temp = 0;
		
		for (int i = 0; i < 3; i++) {
			if (a.results[i] > temp){
				temp = a.results[i];
			}
		}
		a.peakResult = temp;
	}
	
//This is the getter method for the day variable
	public static int getDay(result a) {
		return a.day;
	}
	
//This is the setter method for the day variable
	public static void setDay(result a, int newDay) {
		a.day = newDay;
	}
	
	public static int getPeakFlow(result a) {
		return a.peakResult;
	}
	
	public static void setResults(result a, int value, int pos) {
		a.results[pos] = value;
	}
}

class result{
	int day;
	int [] results = new int[3];
	int peakResult = 0;
}