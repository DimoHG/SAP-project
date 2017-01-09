package commands;

import event.FileOperator;

public class DeleteEvent implements Command{
	private FileOperator fileOperator;
	private String userInput;
	
	
	public DeleteEvent(FileOperator fileOperator,String userInput){
		this.fileOperator=fileOperator;
		this.userInput=userInput;
	}
	
	
	@Override
	public void execute() {
		fileOperator.deleteEvent(userInput);
	}
	

}
