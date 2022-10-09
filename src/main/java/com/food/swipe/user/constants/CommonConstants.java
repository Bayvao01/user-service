package com.food.swipe.user.constants;

import java.time.format.DateTimeFormatter;

public class CommonConstants {
	
	public static final String SUCCESS = "Success";
	public static final String VERIFIED = "Verified";
	public static final String FAILURE = "Failure";
	public static final String NOT_VERIFIED = "Not Verified";

	//common timestamp format to be maintained across all DB records
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm:ss.ffff");
}
