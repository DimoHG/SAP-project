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
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import enums.EventMarker;
import enums.EventType;
import exceptions.NoSuchEventException;
import exceptions.NoSuchMarkerException;
import exceptions.NoSuchTypeException;
import exceptions.WrongDateFormatException;
import exceptions.WrongOptionException;
import validations.DateValidator;

public class FileOperator {
	public static final String FILE="data.txt";


	public ArrayList<Event> readJson(){
		FileOperator fileOperator = new FileOperator();
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
		FileOperator fileOperator = new FileOperator();
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
		FileOperator fileOperator = new FileOperator();
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
		FileOperator fileOperator = new FileOperator();
		ArrayList<Event> dataFromJson=fileOperator.readJson();
		DateValidator dateObject = new DateValidator();

		try {
			EventMarker markerToValidate=EventMarker.markerValidation(marker);
			EventType typeToValidate=EventType.typeValidation(type);
			Date dateToValidate=dateObject.dateValidator(date); 
			dataFromJson.add(new Event(dateToValidate, name, description, typeToValidate, markerToValidate));
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


	public void printEvents(){
		FileOperator fileOperator = new FileOperator();
		ArrayList<Event> dataFromJson=fileOperator.readJson();
		for (Event event : dataFromJson) {
			System.out.println("Name: "+event.getName());
			System.out.println("Date: "+event.getDate());
			System.out.println("Marker: "+event.getMarker());
			System.out.println("Type: "+event.getType());
			System.out.println("Description: "+event.getEventDescription());
			System.out.println();
		}
	}

	public void updateEvent(String eventName){
		FileOperator fileOperator = new FileOperator();
		Scanner scan = new Scanner(System.in);
		DateValidator dateObject = new DateValidator();
		
		try {
			Event event = fileOperator.getByName(eventName);
			System.out.println("What would you like to change?");
			System.out.println("1.Date");
			System.out.println("2.Marker");
			System.out.println("3.Type");
			System.out.println("4.Description");
			int switchKey=scan.nextInt();
			String userInput;
			switch (switchKey) {
			case 1:
				System.out.println("Enter new date:");
				scan.nextLine();
				userInput=scan.nextLine();
				Date dateToValidate=dateObject.dateValidator(userInput);
				event.setDate(dateToValidate);
				break;
			case 2:
				System.out.println("Enter new marker");
				scan.nextLine();
				userInput=scan.nextLine();
				EventMarker eventMarker=EventMarker.markerValidation(userInput);
				event.setMarker(eventMarker);
				break;
			case 3:
				System.out.println("Enter new type");
				scan.nextLine();
				userInput=scan.nextLine();
				EventType eventType=EventType.typeValidation(userInput);
				event.setType(eventType);
				break;
				
			case 4:
				System.out.println("Enter new description");
				scan.nextLine();
				userInput=scan.nextLine();
				event.setEventDescription(userInput);
				break;
			default:
				throw new InputMismatchException();
			}
			System.out.println("The chage is successful");
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
		}
		
		scan.close();
	}

	public void printCalendar(){
		FileOperator fileOperator = new FileOperator();
		ArrayList<Event> dataFromJson=fileOperator.readJson();
		
		
	}





}