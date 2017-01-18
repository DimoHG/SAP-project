package commands;

import event.FileOperator;

public abstract class Command {
	FileOperator fileOperator = new FileOperator();
	public Command(FileOperator fileOperator){
		this.fileOperator=fileOperator;
	}
	public abstract void execute();
		
	
	
	
}
