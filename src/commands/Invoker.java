package commands;

public class Invoker {
	Command theCommand;
	
	public Invoker(Command command){
		theCommand=command;
	}
	
	
	public void press(){
		theCommand.execute();
	}
}
