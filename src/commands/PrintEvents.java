package commands;

import event.FileOperator;

public class PrintEvents extends Command {

	
	
	public PrintEvents(FileOperator fileOperator){
	super(fileOperator);
	}
	
	
	@Override
	public void execute() {
		fileOperator.printEvents();
	}
}
