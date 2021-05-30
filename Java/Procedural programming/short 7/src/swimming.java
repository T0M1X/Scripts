import java.util.Scanner;

public class swimming {
	public static void main(String [] args) {
		ask();
	}
	
//This function asks the user for the classification for the event and the team country and the category of each swimmer.
	public static void ask() {
		int maximum;
		int[] points = {0,0,0,0};
		int point = 0;
		
		System.out.println("What is the classification (maximum points) of this relay event?");
		maximum = inputInt();
		ParaRelayTeam team = createTeam(inputString("What country is the team representing?"),points);
		for (int i = 0; i < 4; i++) {
			System.out.println("What is the disability category of Swimmer " + (i+1) +"?");
			point = inputInt();
			setPoints(team, point, i);
		}	
		output(maximum, team);
	}
	
//This function adds up the total for each player and then outputs if the team is legal or not.
	public static void output(int max, ParaRelayTeam theTeam) {
		int total = 0;
		
		for (int i = 0; i < 4; i++) {
			total = total + getPoints(theTeam, i);
		}
		if (total <= max) {
			System.out.println("That " + theTeam.country + " team has " + total + " points so is legal.");
		} else {
			System.out.println("That " + theTeam.country + " team has " + total + " points so is not legal.");
		}
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
	
//This creator method for the ParaRelayTeam record
	public static ParaRelayTeam createTeam(String newCountry, int[] newPoints) {
		ParaRelayTeam team = new ParaRelayTeam();
		team.country = newCountry;
		team.points = newPoints;
		return team;
	}
	
//This is the getter method for the points variable
	public static int getPoints(ParaRelayTeam a, int number){
		return a.points[number];
	}
	
//This is the setter method for the points variable
	public static void setPoints(ParaRelayTeam a, int point, int pos){
		a.points[pos] = point;
	}
	
//This is the getter method for the country variable
	public static String getCountry(ParaRelayTeam a) {
		return a.country;
	}
	
//This is the setter method for the country variable
	public static void setCountry(ParaRelayTeam a, String newCountry) {
		a.country = newCountry;
	}
}

//This is the class definition of ParaRelayTeam
class ParaRelayTeam{
	String country;
	int [] points = new int[4];
}
