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
	 
	 
	
}
