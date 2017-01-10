package commands;

import event.FileOperator;

public class AddEvent implements Command {
	FileOperator fileOperator = new FileOperator();
	 String date; 
	 String name;
	 String description;
	 String type;
	 String marker;

	
	
	
	public AddEvent(FileOperator fileOperator, String date, String name, String description, String type, String marker ) {
	this.fileOperator=fileOperator;
	this.date=date;
	this.name=name;
	this.description=description;
	this.type=type;
	this.marker=marker;
	}




	@Override
	public void execute() {
		fileOperator.addEvent(date, name, description, type, marker);
	}

}
