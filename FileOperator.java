package event;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;


public class FileOperator {

	//       Employee emp1=gson.fromJson(empJson, Employee.class); 	
	//       
	//      System.out.println(emp1.getAge());
	// 	}
	ArrayList<Event> arrayListOfEvents =new ArrayList<Event>();
	public static void readJson(){
		Gson gson = new Gson();
		BufferedReader buffReader=null;
		String textFromFile="";
		try{
			buffReader=new BufferedReader(new FileReader("C://Users//admin 231116//Desktop//DATABASE.txt"));
			String currentLine=buffReader.readLine();
			while(currentLine!=null){
				textFromFile=textFromFile + "" + currentLine;
				currentLine=buffReader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffReader != null)buffReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		String[] jsonStrings=textFromFile.split("\\*");

		Event event1=gson.fromJson(jsonStrings[1], Event.class);
		//System.out.println(event1.getEventName());
		
		

	}





	public static void writeJson(){
		Gson gson=new Gson();
		ArrayList<Event> arrayListOfEvents =new ArrayList<Event>();
		arrayListOfEvents.add(new Event());
		arrayListOfEvents.add(new Event());
		BufferedWriter buffWriter=null;
		FileWriter fileWriter=null;
		try{
			File file = new File("C://Users//admin 231116//Desktop//DATABASE.txt");
			String textToBeWritten="";
			for (Event event : arrayListOfEvents) {
				textToBeWritten=textToBeWritten+"*"+gson.toJson(event);
			}
			fileWriter = new FileWriter(file.getAbsoluteFile());
			buffWriter = new BufferedWriter(fileWriter);
			buffWriter.write(textToBeWritten);
			buffWriter.flush();
		}catch(IOException e){
			e.printStackTrace();}
		finally{
			if(buffWriter!=null ){
				try {
					buffWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}if(fileWriter != null){
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}