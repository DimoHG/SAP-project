package commands;

import event.FileOperator;

public class UpdateEvent implements Command {

	private FileOperator fileOperator = new FileOperator();
	String eventName;
	
	public UpdateEvent(FileOperator fileOperator, String eventName) {
		this.fileOperator = fileOperator;
		this.eventName=eventName;
	}


	@Override
	public void execute() {
		fileOperator.updateEvent(eventName);
	}

}
