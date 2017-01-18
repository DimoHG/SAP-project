package commands;

import event.FileOperator;

public class DayEvents extends Command {
String date;

	public DayEvents(FileOperator fileOperator, String date) {
		super(fileOperator);
		this.date=date;
		
	}

	@Override
	public void execute() {
		fileOperator.dayEvents(date);
	}

}
