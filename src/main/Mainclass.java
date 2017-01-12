package main;

import commands.AddEvent;
import commands.DeleteEvent;
import commands.Invoker;
import commands.PrintEvents;
import commands.UpdateEvent;
import event.FileOperator;

public class Mainclass {
	public static void main(String[] args){
		FileOperator fileOperator = new FileOperator();
		
		
		
		switch (args[0]) {
		case "delete":
			DeleteEvent deleteEvent = new DeleteEvent(fileOperator,args[1]);
			Invoker invoker = new Invoker(deleteEvent);
			fileOperator.deleteEvent(args[1]);
			break;
		case "print":
			PrintEvents printEvents = new PrintEvents(fileOperator);
			invoker = new Invoker(printEvents);
			invoker.press();
		case "add":
			updateEvent(args, fileOperator);
			break;
			
		case "update":
			UpdateEvent updateEvent = new UpdateEvent(fileOperator,args[1]);
			invoker = new Invoker(updateEvent);
			invoker.press();
			break;
			
			
			
			
		default:
			System.out.println("No such option");
			break;
		}
	}

	private static void updateEvent(String[] args, FileOperator fileOperator) {
		String date=null;
		String marker=null;
		String name=null;
		String type=null;
		String description=null;
		AddEvent addEvent = new AddEvent(fileOperator, date, name, description, type, marker);
		Invoker invoker = new Invoker(addEvent);
		
		for(int i=0;i<args.length;i++){
			if(args[i].equals("-name")){
				name=args[i+1];
			}
			if(args[i].equals("-type")){
				type=args[i+1];
			}
			if(args[i].equals("-marker")){
				marker=args[i+1];
			}
			if(args[i].equals("-date")){
				date=args[i+1];
			}
			if(args[i].equals("-description")){
				description=args[i+1];
			}
		}
		if(date==null||marker==null||name==null||type==null||description==null){
			System.out.println("Incorrect input");
		}else invoker.press();
	}
}
