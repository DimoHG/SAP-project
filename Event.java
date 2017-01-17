package event;

import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

import enums.EventMarker;
import enums.EventType;
public class Event {
	private Date date; 
	private String name;
	private String describtion;
	private EventType type;
	private EventMarker marker;



public Event (Date date,String name){
	this.date=date;
	this.name=name;
}
public Event(Date date, String name, String describtion, EventType type, EventMarker marker) {
		this.date = date;
		this.name = name;
		this.describtion = describtion;
		this.type = type;
		this.marker = marker;
	}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Event other = (Event) obj;
	if (date == null) {
		if (other.date != null)
			return false;
	} else if (!date.equals(other.date))
		return false;
	if (describtion == null) {
		if (other.describtion != null)
			return false;
	} else if (!describtion.equals(other.describtion))
		return false;
	if (marker != other.marker)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (type != other.type)
		return false;
	return true;
}





public Date getDate() {
	return date;
}


public void setDate(Date date) {
	this.date = date;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
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





