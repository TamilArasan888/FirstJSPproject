package com.chainsys.jspproject.commonutils;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public static boolean checkStringForParseInt(String data) throws InvalidInputDataException {
		boolean result = false;
		for (int i = 0; i < data.length(); i++) {
			int c = (int) data.charAt(i);
			if (!(c >= 48 && c <= 58)) {
				result = false;
			if(!result) throw new InvalidInputDataException("Please Enter Integer Values!!");

			}
		} // if data is invalid throw new InvalidInputDataException("The value in string
			// must contain only numbers ");
		return result;
	}

	public static boolean checkNumberForGreaterThanZero(int data) throws InvalidInputDataException {
		boolean result = false;
		if (data <=0) {
			throw new InvalidInputDataException("THE VALUE MUST BE GREATER THEN ZERO");
		} // if data is invalid throw new InvalidInputDataException("The value must be
			// greater then zero");
		return result;
	}
	
	public static void checkNumberForGreaterThanZero(float data) throws InvalidInputDataException {
		if(data<0) 
			throw new InvalidInputDataException("Please Enter value greater than zero");
		
	}

	public static boolean checkCharLessThanTwenty(String data) throws InvalidInputDataException {
		boolean result = false;
		int count = 0;
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) != ' ') {
				count++;
			}
			if (count >= 20) {
				throw new InvalidInputDataException("The value of character must be less then twenty digit");
			}
		}
		return result;
	}
	
	public static boolean checkNumberLessThanTenDigit(Float data) throws InvalidInputDataException {
		boolean result = false;
		String d = Float.toString(data);
		int count = 0;
		for (int i = 0; i < d.length(); i++) {
			if (d.charAt(i) != ' ') {
				count++;
			}
			if (count >= 10) {
				throw new InvalidInputDataException("The Digits of Number must be less then or equal to ten digits");
			}
		}
		return result;
	}

	public static boolean checkMailContainsAtsymbol(String data) throws InvalidInputDataException {
		boolean result = false;
		Pattern p = Pattern.compile("^(.+)@(.+)$");
		Matcher m = p.matcher(data);

		if (!m.find()) {
			throw new InvalidInputDataException("The Input Data is not valid ");
		}
		return result;
	}

	public static void checkStringOnly(String data) throws InvalidInputDataException {
		boolean result=false;
		String pattern="^[a-zA-Z]+(\\s[a-zA-Z]+)?$";
		Pattern patt=Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
		if(!result) throw new InvalidInputDataException("PLEASE ENTER CHARACTERS ONLY");
	}
	
	public static void checkFloat(String data) throws InvalidInputDataException{

		String pattern="^[0-9]+(.[0-9]*)?$";
		if (!match(pattern, data))
			throw new InvalidInputDataException("Please Enter Integer or Decimal number");
	}
	
	private static boolean match(String pattern, String data) {

		Pattern patt = Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		return match.matches();
	}

	public static void checkEmail(String data) throws InvalidInputDataException{

		boolean result=false;
	    String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	    Pattern patt=Pattern.compile(regexPattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
	    if(!result) throw new InvalidInputDataException("Your E-Mail ID does not meet required length.");
	}
	
	public static void checkJobId(String data) throws InvalidInputDataException{

		boolean result=false;
		String pattern="^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
		Pattern patt=Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
		if(!result) throw new InvalidInputDataException("Wrong pattern of Job ID");
	}
	
	public static void checkSalaryLimit(float data) throws InvalidInputDataException {

		if(data<7000 && data>150000) {
			throw new InvalidInputDataException("Please Enter Salary between 7000 and 150000");
		}
	}
	
	public static void checkPhone(String data) throws InvalidInputDataException{
		boolean result=false;
		String pattern="^[0-9]{10}$";
		Pattern patt=Pattern.compile(pattern);
		Matcher match = patt.matcher(data);
		result=match.matches();
		if(!result) throw new InvalidInputDataException("Please Enter 10 Digit Number ");
	}

	public static boolean checkDateFormat(String data) throws InvalidInputDataException {
		boolean result = false;
		int len = data.length();
		String[] data1 = data.split("/");
		//for (int i = 0; i < data1.length; i++)
			//System.out.println(data1[i]);
		int date = Integer.parseInt(data1[0]);
		int mon = Integer.parseInt(data1[1]);
		int yrs = Integer.parseInt(data1[2]);
		for (int index = 0; index < len; index++) {
			int asc = (int) data.charAt(index);
			if ((asc < 46) || (asc > 58))// || (asc != 47))
				throw new InvalidInputDataException("Enter date in correct format ");
		}

		// TODO
		// date before 1/1/1985

		if (yrs > 1984 && yrs <= 2022) {
			if (mon == 1 || mon == 3 || mon == 5 || mon == 7 || mon == 8 || mon == 10 || mon == 12)
				if (date > 0 && date <= 31)
					result = true;
				else
					throw new InvalidInputDataException("enter valid date");
			else if (mon == 2 || mon == 4 || mon == 6 || mon == 9 || mon == 11)
				if (date > 0 && date <= 30)
					result = true;
				else
					throw new InvalidInputDataException("enter valid date");
			else
				throw new InvalidInputDataException("enter valid month");
		} else
			throw new InvalidInputDataException("enter valid year");
//		if(date.before(calender.getI);

		return result;

	}

	public static boolean CheckNofutureDate(Date date) throws InvalidInputDataException {
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateA = new Date();
		boolean result = false;
	if( date.compareTo(dateA)<0 )
		result=true;
	else
		throw new InvalidInputDataException("Enter a valid date format");
		return result;
//		String testDate = formatter.format(date);
	}
	
	public static void checkHireDate(String date) throws InvalidInputDataException {
		String pattern11 = "^((\\d{1})|(\\d{2}))/((\\d{1})|(\\d{2}))/((19[89][0-9])|(20([01][0-9])|20(2[0-2])))$";
		if (!match(pattern11, date))
			throw new InvalidInputDataException("Hire Date must be in between 1980-2022");
	}
	
	public static void checkAppointmentDate(String date) throws InvalidInputDataException {
		String pattern13 = "^((\\d{1})|(\\d{2}))/((\\d{1})|(\\d{2}))/(([0-1][0-9][0-9][0-9])|(20[01][0-9])|(202[01]))$";
		if (match(pattern13, date))
			throw new InvalidInputDataException("Appointment date must above 2022");
	}
}
