package main;

import java.util.ArrayList;
import java.util.List;

import event.Event;
import event.FileOperator;
import wagu.Board;
import wagu.Table;

public class SAPtesting {
	public static void main(String[] args){

		FileOperator fileOperator = new FileOperator();
ArrayList<Event> arrayListOfEvents = fileOperator.readJson();
String[] argumenti = {"update" , "Dimo" , "Georgiev", "-marker", "private"};
String name="";
int counter=2;
for (int i=1;i<argumenti.length;i++) {
	if(argumenti[i].startsWith("-")){
		counter=i;
		break;
	}else name=name + argumenti[i]+ " ";
}
name=name.trim();
System.out.println(name);
System.out.println(argumenti[counter+1]);
	}


}