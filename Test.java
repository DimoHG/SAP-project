package event;

import java.awt.Window.Type;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import exceptions.NoSuchEventException;
public class Test {

	public static void main(String... args){
		ArrayList<Event> events= new ArrayList();
		FileOperator fileOperator= new FileOperator();
		Event event1= new Event("Dimo");
		Event event2= new Event("Vili");
		Event event3= new Event("Niki");
		Event event4= new Event("Jelcho");
		
		events.add(event1);
		events.add(event2);
		events.add(event3);
		events.add(event4);
		////////////////////////////////////////////////////////////////
		fileOperator.writeJson(events);
		
		ArrayList<Event> dataFromJson=fileOperator.readJson();
		fileOperator.deleteEvent("Niki");
	
		
		
		

		
	}
	
	
}

