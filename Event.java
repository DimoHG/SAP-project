package dayPlanner;

import java.util.Scanner;
import java.util.regex.Pattern;
public class Event {
	private String type; // meeting or task
	private String marker; // public confidential private
	private String date; // yyyyMMddhhmmss
	private String description; 
	private String name;



	public Event() {
		this.name=Event.setName();
		this.type = Event.setType();
		this.marker = Event.setMarker();
		this.date=Event.setDate();
		this.description=Event.setDescription();
	}


	public static String setName() {
		Scanner scan= new Scanner(System.in);
		System.out.println("What is the name of te event?");
		String name=scan.nextLine();
		return name;
	}
	public static String setType() {
		int option=0;
		Scanner scan = new Scanner(System.in);
		String type="";

		while(option!=1 || option!=2){
			System.out.println("What type is the event?");
			System.out.println("1. Meeting");
			System.out.println("2. Task");
			option=scan.nextInt();
			switch (option) {
			case 1:
				return "Meeting";
			case 2:
				return "Task";
			default:
				System.out.println("No such option");
				break;
			}
		}
		return type;
	}

	public static String setMarker() {
		int option =0;
		Scanner scan=new Scanner(System.in);
		String marker="";
		while(option!=1 || option!=2 || option !=3){
			System.out.println("How would you like to mark the event?");
			System.out.println("1. Public");
			System.out.println("2. Confidential");
			System.out.println("3. Private");
			option=scan.nextInt();
			switch(option){
			case 1:
				return "Public";
			case 2:
				return "Confidential";
			case 3:
				return "Private";
			default:
				System.out.println("No such option");
				break;
			}

		}
		return marker;
	}
	public static String setDate() {
		Scanner scan= new Scanner(System.in);
		final String DATE_PATTERN = "(?:(?:(?:(?:(?:[13579][26]"
				+ "|[2468][048])00)|(?:[0-9]{2}(?:(?:[13579][26])|(?:[2468][048]"
				+ "|0[48]))))(?:(?:(?:09|04|06|11)(?:0[1-9]|1[0-9]|2[0-9]|30))|(?:(?:01|03|05|07|08|10|12)"
				+ "(?:0[1-9]|1[0-9]|2[0-9]|3[01]))|(?:02(?:0[1-9]|1[0-9]|2[0-9]))))|(?:[0-9]{4}(?:(?:(?:09|04|06|11)"
				+ "(?:0[1-9]|1[0-9]|2[0-9]|30))|(?:(?:01|03|05|07|08|10|12)(?:0[1-9]|1[0-9]|2[0-9]|3[01]))|(?:02(?:[01][0-9]"
				+ "|2[0-8])))))(?:0[0-9]|1[0-9]|2[0-3])(?:[0-5][0-9]){2}";


		System.out.println("When would you like to schedule the event?");
		boolean matches=false;
		String input="";

		while (matches!=true){
			System.out.println("Use yyyymmddhhmmss format");
			input=scan.nextLine();
			matches=Pattern.matches(DATE_PATTERN, input);
		}

		return input;

	}

	public static String setDescription() {
		Scanner scan=new Scanner(System.in);
		System.out.println("How would you describe this event?");
		String description;
		return description=scan.nextLine();
	}

	public String getDescription() {
		return description;
	}

	public String getMarker() {
		return marker;
	}
	public String getType() {
		return type;
	}
	public String getDate() {
		return date;
	}
	public String getName() {
		return name;
	}
}


