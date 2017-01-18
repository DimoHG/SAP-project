package commands;

import event.FileOperator;

public class MonthEvents extends Command {
String date;
	public MonthEvents(FileOperator fileOperator, String date) {
		super(fileOperator);
		this.date=date;
	}

	@Override
	public void execute() {
		this.fileOperator.monthEvents(date);
	}

	
}
