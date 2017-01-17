package enums;

import java.util.Scanner;

import exceptions.NoSuchMarkerException;

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
	

	
	

}
	
	
	
	
	
	
	