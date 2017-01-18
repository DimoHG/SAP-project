package commands;

import event.FileOperator;

public class DeleteAllEvents extends Command{

	public DeleteAllEvents(FileOperator fileOperator) {
		super(fileOperator);

	}
	
	public void execute(){
		fileOperator.deleteAllEvents();
	}

}
