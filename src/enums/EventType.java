package enums;

import java.util.Scanner;

import exceptions.NoSuchTypeException;

public enum EventType {
MEETING("Meeting"),
TASK("Task");
	
	private final String type;
	
	 EventType(String type){
		this.type=type;
	}
	 
	 public String getType(){
		 return this.type;
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
}
