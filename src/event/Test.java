package event;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import enums.EventMarker;
import enums.EventType;
public class Test {

	public static void main(String... args){
		ArrayList<Event> events= new ArrayList();
		FileOperator fileOperator= new FileOperator();

		////////public Event(Date date, String name, String describtion, EventType type, EventMarker marker)
	
fileOperator.printEvents();		
fileOperator.updateEvent("Dimo");

		
	}
	
}

