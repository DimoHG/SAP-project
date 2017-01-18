package commands;

public class CommandInvoker {
	private Command theCommand;
	
	public CommandInvoker(Command command){
		theCommand=command;
	}
	
	
	public void invokeCommand(){
		theCommand.execute();
	}
}
