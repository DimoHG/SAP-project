package commands;

import event.FileOperator;

public class UpdateEvent extends Command {

	private String eventName;
	private String[] arguments;
	
	public UpdateEvent(FileOperator fileOperator, String[] arguments) {
		super(fileOperator);
		this.arguments=arguments;
		
	}


	@Override
	public void execute() {
		fileOperator.updateEvent(arguments);
	}

}
