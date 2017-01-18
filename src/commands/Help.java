package commands;

import event.FileOperator;

public class Help extends Command{

	public Help(FileOperator fileOperator) {
		super(fileOperator);
	}

	@Override
	public void execute() {
		fileOperator.help();
	}
	
	

}
