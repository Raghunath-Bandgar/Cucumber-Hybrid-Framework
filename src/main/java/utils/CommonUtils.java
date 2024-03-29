package utils;

import java.util.Date;

public class CommonUtils {

	// constants Variables

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int EXPLICIT_WAIT_TIME = 20;
	public static final int PAGE_LOAD_TIME = 15;
	public static final int SHORT_WAIT = 5;
	public static final int LONG_WAIT = 8;

	// for dynamic sending email address

	public static String getEmailWithTimeStamp() {

		Date date = new Date(); // Date ..from java util package
		return "Rishan" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";
	}

}
