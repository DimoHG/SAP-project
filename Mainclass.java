package main;

import commands.AddEvent;
import commands.DeleteAllEvents;
import commands.DeleteEvent;
import commands.Help;
import commands.MonthEvents;
import commands.CommandInvoker;
import commands.DayEvents;
import commands.PrintEvents;
import commands.UpdateEvent;
import event.FileOperator;

public class Mainclass {
	public static void main(String[] args){
		FileOperator fileOperator = new FileOperator();
		
		
		
		switch (args[0]) {
		case "delete":
			DeleteEvent deleteEvent = new DeleteEvent(fileOperator,args[1]);
			CommandInvoker invoker = new CommandInvoker(deleteEvent);
			fileOperator.deleteEvent(args[1]);
			break;
		case "print":
			PrintEvents printEvents = new PrintEvents(fileOperator);
			invoker = new CommandInvoker(printEvents);
			invoker.invokeCommand();
			break;
		case "add":
			addEvent(args, fileOperator);
			break;
			
		case "update":
			UpdateEvent updateEvent = new UpdateEvent(fileOperator,args);
			invoker = new CommandInvoker(updateEvent);
			invoker.invokeCommand();
			break;
		case "deleteAll":
			DeleteAllEvents deleteAll = new DeleteAllEvents(fileOperator);
			invoker = new CommandInvoker(deleteAll);
			invoker.invokeCommand();
			break;
		case"help":
			Help help = new Help(fileOperator);
			invoker = new CommandInvoker(help);
			invoker.invokeCommand();
			break;
		case"month":
			MonthEvents monthEvents = new MonthEvents(fileOperator, args[1]);
			invoker = new CommandInvoker(monthEvents);
			invoker.invokeCommand();
			break;
		case"day":
			DayEvents dayEvents = new DayEvents(fileOperator,args[1]);
			invoker = new CommandInvoker(dayEvents);
			invoker.invokeCommand();
		default:
			System.out.println("No such option");
			break;
		}
	}

	private static void addEvent(String[] args, FileOperator fileOperator) {
		String date="";
		String marker="";
		String name="";
		String type="";
		String description="";
		
		if(args.length>6){
		
		for(int i=0;i<args.length;i++){
			if(args[i].equals("-name")){
				int counter=i+1;
				while(!(args[counter].startsWith("-"))){
					name=name +args[counter]+ " ";
					counter++;
					if(counter>=args.length){
						break;
					}
				}
				
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
				int counter=i+1;
				while(!(args[counter].startsWith("-"))){
					description=description +args[counter]+ " ";
					counter++;
					if(counter>=args.length){
						break;
					}
				}
				
			}
		}
		description=description.trim();
		name=name.trim();
		AddEvent addEvent = new AddEvent(fileOperator, date, name, description, type, marker);
		CommandInvoker invoker = new CommandInvoker(addEvent);
		if(date==null||marker==null||name==null||type==null||description==null){
			System.out.println("Incorrect input");
		}else invoker.invokeCommand();
	}
	else {
		for(int i=0;i<args.length;i++){
			if(args[i].equals("-name")){
				int counter=i+1;
				while(!(args[counter].startsWith("-"))){
					name=name +args[counter]+ " ";
					counter++;
					if(counter>=args.length){
						break;
					}
				}
				
				
			}
			if(args[i].equals("-date")){
				date=args[i+1];
			}
		}
		name=name.trim();
		AddEvent addEvent=new AddEvent(fileOperator,date,name);
		CommandInvoker invoker = new CommandInvoker(addEvent);
		if(date==null||name==null){
			System.out.println("Incorrect input");
		}else invoker.invokeCommand();
	}
}
}
