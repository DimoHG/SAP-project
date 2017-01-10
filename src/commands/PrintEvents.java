package commands;

import event.FileOperator;

public class PrintEvents implements Command {

	private FileOperator fileOperator;
	
	
	public PrintEvents(FileOperator fileOperator){
		this.fileOperator=fileOperator;
	}
	
	
	@Override
	public void execute() {
		fileOperator.printEvents();
	}
}
