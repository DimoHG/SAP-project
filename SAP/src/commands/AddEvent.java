package commands;

import event.FileOperator;

public class AddEvent extends Command {
	
	 private String date; 
	 private String name;
	 private String description;
	 private String type;
	 private String marker;

	
	public AddEvent(FileOperator fileOperator, String date , String name){
		super(fileOperator);
		this.date=date;
		this.name=name;
	}
	
	public AddEvent(FileOperator fileOperator, String date, String name, String description, String type, String marker ) {
	super(fileOperator);
	this.date=date;
	this.name=name;
	this.description=description;
	this.type=type;
	this.marker=marker;
	}




	@Override
	public void execute() {
		if(this.marker==null){
			fileOperator.addEvent(date, name);
		}else fileOperator.addEvent(date, name, description, type, marker);
	}

}
