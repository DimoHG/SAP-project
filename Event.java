package event;

import java.util.Scanner;
import java.util.regex.Pattern;

import enums.EventMarker;
import enums.EventType;
public class Event {
	private String date; 
	private String name;
	private String describtion;
	private EventType type;
	private EventMarker marker; 




	public Event() {
		this.name=Event.nameValidation();
		this.marker=EventMarker.markerValidation();
		this.type=EventType.typeValidation();
		this.date=Event.dateValidation();
		this.describtion=Event.describtionValidation();
		
		
	}

///////////////////////////////////////////////////////////////
public static String dateValidation(){	
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

public static String describtionValidation(){
	System.out.println("Describtion:");
	Scanner scan=new Scanner(System.in);
	String describtion=scan.nextLine();
	return describtion;
}


public static String nameValidation(){
	System.out.println("Enter the name of the event");
	Scanner scan =new  Scanner(System.in);
	String name=scan.nextLine();
	return name;
}


//////////////////////////////////////////////////////////
public String getDate() {
	return date;
}


public void setDate(String date) {
	this.date = date;
}


public String getEventName() {
	return name;
}


public void setEventName(String eventName) {
	this.name = eventName;
}


public String getEventDescription() {
	return describtion;
}


public void setEventDescription(String eventDescription) {
	this.describtion = eventDescription;
}


public EventType getType() {
	return type;
}


public void setType(EventType type) {
	this.type = type;
}


public EventMarker getMarker() {
	return marker;
}


public void setMarker(EventMarker marker) {
	this.marker = marker;
}



}





