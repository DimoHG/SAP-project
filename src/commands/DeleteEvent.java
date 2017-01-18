package commands;

import event.FileOperator;

public class DeleteEvent extends Command{
	private String eventName;
	
	
	public DeleteEvent(FileOperator fileOperator,String eventName){
		super(fileOperator);
		this.eventName=eventName;
	}
	
	
	@Override
	public void execute() {
		fileOperator.deleteEvent(eventName);
	}
	

}
