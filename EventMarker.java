package enums;

import java.util.Scanner;

public enum EventMarker {
PUBLIC("Public"),
CONFIDENTIAL("Confidential"),
PRIVATE("Private");
	
	private final String marker;

	EventMarker(String marker){
	this.marker=marker;	
	}
	
	public String getMarker(){
		return this.marker;
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
		}
		return marker;
	}
	
	
}
