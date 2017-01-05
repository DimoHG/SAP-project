package dayPlanner;

import java.util.Scanner;
import java.util.regex.Pattern;

import enums.EventMarker;
public class Event {
	private String eventType; // meeting or task
	private String eventDate; // yyyyMMddhhmmss
	private String eventName;
	private String eventDescription;
	private EventMarker marker; 
	



	public Event() {
		this.marker = Event.markerValidation();
	}
	
	
	
public static EventMarker markerValidation(){
Scanner scan=new Scanner(System.in);
int option =0;
EventMarker marker= EventMarker.CONFIDENTIAL;
while(option!=1 || option!=2 || option !=3){
	System.out.println("How would you like to mark the event?");
	System.out.println("1. Public");
	System.out.println("2. Confidential");
	System.out.println("3. Private");
	option=scan.nextInt();
	switch(option){
	case 1:
		EventMarker publicMarker=EventMarker.PUBLIC;
		return publicMarker;

	case 2:
		EventMarker confidentialMarker=EventMarker.CONFIDENTIAL;
		return confidentialMarker;
	case 3:
		EventMarker privateMarker=EventMarker.PRIVATE;
		return privateMarker;
	default:
		System.out.println("No such option");
		break;
	}
	
}	return marker;


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


	

	public String getDescription() {
		return eventDescription;
	}

	public String getDate() {
		return eventDate;
	}
	public String getName() {
		return eventName;
	}

}


