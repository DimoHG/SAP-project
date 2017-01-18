package validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import enums.EventMarker;
import enums.EventType;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;

import exceptions.NoSuchMarkerException;
import exceptions.NoSuchTypeException;
import exceptions.WrongDateFormatException;

public class Validator {


	
	public   java.util.Date dateValidator(String userInput) throws WrongDateFormatException {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm/MM/dd/yyyy");
		java.util.Date testDate = null;
		try{
			testDate = df.parse(userInput);
		} catch (ParseException e){ 
			System.out.println("Invalid date format!");}

		if (df.format(testDate).equals(userInput)){
			return testDate;
		} else	throw new WrongDateFormatException();		

	}
	
	public static EventType typeValidation(String userInput) throws NoSuchTypeException{
		userInput=userInput.toLowerCase();
		if(userInput.equals("task")){
			EventType taskType = EventType.TASK;
			return taskType;
		}else if(userInput.equals("meeting")){
			EventType meetingType = EventType.MEETING;
			return meetingType;
		}else throw new NoSuchTypeException();
		
		
	}
	
public static EventMarker markerValidation(String userInput) throws NoSuchMarkerException{
		
		userInput=userInput.toLowerCase();
		if(userInput.equals("public")){
			EventMarker publicMarker=EventMarker.PUBLIC;
			return publicMarker;
		}else if(userInput.equals("confidential")){
			EventMarker confidentialMarker=EventMarker.CONFIDENTIAL;
			return confidentialMarker;
		}else if(userInput.equals("private")){
			EventMarker privateMarker=EventMarker.PRIVATE;
			return privateMarker;
		}else throw new NoSuchMarkerException();
	
}
		 

	 

}
