package validations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.GregorianCalendar;

import exceptions.WrongDateFormatException;

public class DateValidator {


	
	public   java.util.Date dateValidator(String userInput) throws WrongDateFormatException {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm/MM/dd/yyyy");
		java.util.Date testDate = null;
		try{
			testDate = df.parse(userInput);
		} catch (ParseException e){ 
			System.out.println("Invalid date format!");}

		if (df.format(testDate).equals(userInput)){
			return testDate;
		} else	throw new WrongDateFormatException();		

	}
		 
	    public void test1() {
	        Calendar today = new GregorianCalendar();
	 
	        SimpleDateFormat df = new SimpleDateFormat();
	        df.applyPattern("dd/MM/yyyy");
	        System.out.println(df.format(today.getTime()));
	    }
	 

}
