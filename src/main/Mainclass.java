package main;

import event.FileOperator;

public class Mainclass {
	public static void main(String[] args){
		FileOperator fileOperator = new FileOperator();
		switch (args[0]) {
		case "delete":
			fileOperator.deleteEvent(args[1]);
			break;
		case "print":
			fileOperator.printEvents();
		case "add":
			String date=null;
			String marker=null;
			String name=null;
			String type=null;
			String description=null;
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
			}else fileOperator.addEvent(date, name, description, type, marker);
			break;
			
		case "update":
			fileOperator.updateEvent(args[1]);
			
			
			
		default:
			System.out.println("No such option");
			break;
		}
	}
}
