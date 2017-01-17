package event;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.JTable;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import enums.EventMarker;
import enums.EventType;
import exceptions.NoSuchEventException;
import exceptions.NoSuchMarkerException;
import exceptions.NoSuchTypeException;
import exceptions.WrongDateFormatException;
import validations.Validator;
import wagu.Board;
import wagu.Table;

public class FileOperator {
	public static final String FILE="data.txt";
	private FileOperator fileOperator;


	public ArrayList<Event> readJson(){
		ArrayList<Event> listFromFile = new ArrayList<>();
		File file = new File(FILE);
		try{
			BufferedReader buffReader = new BufferedReader(new FileReader(FILE));
			String line;
			Gson gson = new Gson();
			java.lang.reflect.Type type = new TypeToken<ArrayList<Event>>(){} .getType();
			while((line=buffReader.readLine())!=null){
				listFromFile.addAll(gson.fromJson(line, type));
			}

			buffReader.close();

		} catch(IOException e){
			e.printStackTrace();}

		return listFromFile;
	}


	public void writeJson(ArrayList<Event> eventsList){
		fileOperator = new FileOperator();
		try{
			BufferedWriter buffWriter = new BufferedWriter (new FileWriter(FILE));
			Gson gson = new Gson();
			java.lang.reflect.Type type = new TypeToken<ArrayList<Event>>(){}.getType();

			String json = gson.toJson(eventsList, type);
			buffWriter.append(json);
			buffWriter.newLine();
			buffWriter.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}


	public Event getByName(String eventName) throws NoSuchEventException{
		fileOperator = new FileOperator();
		Event eventToReturn = null;
		FileOperator fileOperator = new FileOperator();
		ArrayList<Event> dataFromJson= fileOperator.readJson();
		for (Event event : dataFromJson) {
			if(event.getName().equals(eventName)){
				eventToReturn=event;
			}
		}
		if(eventToReturn==null){
			throw new NoSuchEventException();
		}
		return eventToReturn;
	}


	public void deleteEvent(String eventName){
		fileOperator = new FileOperator();
		ArrayList<Event> dataFromJson=fileOperator.readJson();
		Event eventToDelete=null;

		try {
			eventToDelete=fileOperator.getByName(eventName);
			for(int i=0;i<dataFromJson.size();i++){
				if(dataFromJson.get(i).equals(eventToDelete)){
					dataFromJson.remove(i);
				}
			System.out.println("Event " + eventToDelete.getName() + " was deleted");
			}
		} catch (NoSuchEventException e) {
			System.out.println("No such event in the database!");
		}finally{
			fileOperator.writeJson(dataFromJson);
		}
	}

	public void addEvent(String date, String name, String description, String type, String marker){
		fileOperator = new FileOperator();
		ArrayList<Event> dataFromJson=fileOperator.readJson();
		Validator dateObject = new Validator();

		try {
			EventMarker markerToValidate=Validator.markerValidation(marker);
			EventType typeToValidate=Validator.typeValidation(type);
			Date dateToValidate=dateObject.dateValidator(date); 
			dataFromJson.add(new Event(dateToValidate, name, description, typeToValidate, markerToValidate));
			System.out.println("The event is added");
		}catch (NoSuchMarkerException e) {
			System.out.println("No such marker!");
		}catch (NoSuchTypeException e){
			System.out.println("No such type!");
		}catch (WrongDateFormatException e){
			System.out.println("Wrong date format!");
		}
		finally{
			fileOperator.writeJson(dataFromJson);
			
		}
	}
	
	public void addEvent(String date, String name){
		fileOperator = new FileOperator();
		ArrayList<Event> dataFromJson=fileOperator.readJson();
		Validator dateObject = new Validator();
		try {
			Date dateToValidate=dateObject.dateValidator(date);
			dataFromJson.add(new Event(dateToValidate, name));
			System.out.println("The event is added");
		}catch(WrongDateFormatException e){
			System.out.println("Wrong date format");
		}
		finally{
			fileOperator.writeJson(dataFromJson);
		}
	}


	public void printEvents(){
		fileOperator = new FileOperator();
		ArrayList<Event> dataFromJson=fileOperator.readJson();
		for (Event event : dataFromJson) {
			System.out.println("Name: "+event.getName());
			System.out.println("Date: "+event.getDate());
			if(event.getMarker()!=null){
			System.out.println("Marker: "+event.getMarker());
			}
			if(event.getType()!=null){
			System.out.println("Type: "+event.getType());
			}
			if(event.getEventDescription()!=null){
			System.out.println("Description: "+event.getEventDescription());
			}
			System.out.println();
		}
	}

	public void updateEvent(String[] args){
		FileOperator fileOperator = new FileOperator();
		Validator validator = new Validator();
		ArrayList<Event> arrayListOfEvents = fileOperator.readJson();
		
		try {
			Event event = fileOperator.getByName(args[1]);
			arrayListOfEvents.remove(event);
			String switchKey = args[2];
			if(event.getMarker()==null&&(!switchKey.equals("-date"))){
				System.out.println("This event has no such parameter");
			}else{
			switch (switchKey) {
			case "-date":
				Date dateToValidate=validator.dateValidator(args[3]);
				event.setDate(dateToValidate);
				arrayListOfEvents.add(event);
				break;
			case "-marker":
				EventMarker eventMarker=Validator.markerValidation(args[3]);
				event.setMarker(eventMarker);
				arrayListOfEvents.add(event);
				break;
			case "-type":
				EventType eventType=Validator.typeValidation(args[3]);
				event.setType(eventType);
				arrayListOfEvents.add(event);
				break;
			case "-description":
				String description="";
				for(int i=3;i<args.length;i++){
					description=description+args[i];
				}
				event.setEventDescription(description);
				arrayListOfEvents.add(event);
				break;
			default:
				throw new InputMismatchException();
			}
			System.out.println("The chage is successful");}
		} catch (NoSuchEventException e) {
			System.out.println("No such event in the database!");
		}catch(WrongDateFormatException e){
			System.out.println("Wrong date format");
		}catch(NoSuchMarkerException e){
			System.out.println("No such marker");
		}catch(NoSuchTypeException e){
			System.out.println("No such type");
		}catch(InputMismatchException e){
			System.out.println("No such option");
		}finally {
			fileOperator.writeJson(arrayListOfEvents);
		}
		
	}

	public void deleteAllEvents(){
		fileOperator = new FileOperator();
		ArrayList<Event> blankArrayList=new ArrayList();
		fileOperator.writeJson(blankArrayList);
		System.out.println("All events are deleted");
	}

	public void help(){
		System.out.println("delete    : Takes name of event and deletes it");
		System.out.println("print     : Prints all events");
		System.out.println("update    : Takes name of the event and the parameter u want to change");
		System.out.println("deleteAll : Deletes all events" );
		System.out.println("month     : Prints in table all events scheduled for this month");
	}

	public void monthEvents(String date){
		
		fileOperator = new FileOperator();
		ArrayList<Event> arrayListOfEvents = fileOperator.readJson();
		ArrayList<String> headersList = new ArrayList<String>();
		headersList.add("Name");
		headersList.add("Date");
		List<List<String>> rowsList  = new ArrayList<List<String>>();
		ArrayList<String> singleLine = new ArrayList();
		try{
		int month = Integer.parseInt(date.substring(0,2));
		int year = Integer.parseInt(date.substring(3));
		
		for (Event event : arrayListOfEvents) {
			if((event.getDate().getMonth()+1)==month&&(event.getDate().getYear()+1900)==year){
				singleLine=new ArrayList();
				singleLine.add(event.getName());
				singleLine.add(event.getDate().toString());
				rowsList.add(singleLine);
			}
		}
		
		 
			Board board = new Board(500);
			    String tableString = board.setInitialBlock(new Table(board, 60, headersList, rowsList).tableToBlocks()).build().getPreview();
			    System.out.println("Events scheduled for " + date);
			    System.out.println(tableString);
		}catch(NumberFormatException e){
			System.out.println("Incorrect date format");
		}catch (Exception e) {
			System.out.println("There are no scheduled events for this date");
		}
		
		
	}

	
	public void dayEvents(String date){FileOperator fileOperator = new FileOperator();
	ArrayList<Event> arrayListOfEvents = fileOperator.readJson();
	ArrayList<String> headersList = new ArrayList<String>();
	headersList.add("Name");
	headersList.add("Date");
	List<List<String>> rowsList  = new ArrayList<List<String>>();
	ArrayList<String> singleLine = new ArrayList();
	try{
		int day=Integer.parseInt(date.substring(0, 2));
		int month=Integer.parseInt(date.substring(3,5));
		int year=Integer.parseInt(date.substring(6));
	
	for (Event event : arrayListOfEvents) {
		if((event.getDate().getMonth()+1)==month&&(event.getDate().getYear()+1900)==year&&event.getDate().getDate()==day){
			singleLine=new ArrayList();
			singleLine.add(event.getName());
			singleLine.add(event.getDate().toString());
			rowsList.add(singleLine);
		}
	}
	
	 
		Board board = new Board(500);
		    String tableString = board.setInitialBlock(new Table(board, 60, headersList, rowsList).tableToBlocks()).build().getPreview();
		    System.out.println("Events scheduled for " + date);
		    System.out.println(tableString);
	}catch(NumberFormatException e){
		System.out.println("Incorrect date format");
	}catch (Exception e) {
		System.out.println("There are no scheduled events for this date");
	}
	
		
	}



}