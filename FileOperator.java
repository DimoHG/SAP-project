package event;

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

public class FileOperator {
	public static final String FILE="C://Users//admin 231116//Desktop//DATABASE.txt";


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


	public Event getByName(String userInput) throws NoSuchEventException{
		Event eventToReturn = null;
		FileOperator fileOperator = new FileOperator();
		ArrayList<Event> dataFromJson= fileOperator.readJson();
		for (Event event : dataFromJson) {
			if(event.getName().equals(userInput)){
				eventToReturn=event;
			}
		}

		if(eventToReturn==null){
			throw new NoSuchEventException();
		}
		return eventToReturn;
	}


	public void deleteEvent(String userInput){
		FileOperator fileOperator = new FileOperator();
		ArrayList<Event> dataFromJson=fileOperator.readJson();
		Event eventToDelete=null;

		try {
			eventToDelete=fileOperator.getByName(userInput);
			for(int i=0;i<dataFromJson.size();i++){
				if(dataFromJson.get(i).equals(eventToDelete)){
					dataFromJson.remove(i);
				}
			}
		} catch (NoSuchEventException e) {
			e.printStackTrace();
		}finally{
			fileOperator.writeJson(dataFromJson);
		}
	}

	public void addEvent(){

	}


}