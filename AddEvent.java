package commands;

import java.util.ArrayList;

import event.Event;
import event.FileOperator;

public class AddEvent implements Command {
	FileOperator fileOperator = new FileOperator();

	
	
	
	public AddEvent(FileOperator fileOperator) {
	this.fileOperator=fileOperator;
	}




	@Override
	public void execute() {
		fileOperator.addEvent();
		
	}

}
