package enums;

import java.util.Scanner;

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
	 
	 public static EventType typeValidation(){
			Scanner scan=new Scanner(System.in);
			int option=0;
			EventType type=EventType.MEETING;
			while(option!=1 || option!=2){
				System.out.println("What type is the event?");
				System.out.println("1. Meeting");
				System.out.println("2. Task");
				option=scan.nextInt();
				switch(option){
				case 1:
					EventType meetingType = EventType.MEETING;
					return meetingType;
				case 2:
					EventType taskType = EventType.TASK;
					return taskType;
				default:
					System.out.println("No such option");
					break;
				}
			}
			return type;
		}
}
