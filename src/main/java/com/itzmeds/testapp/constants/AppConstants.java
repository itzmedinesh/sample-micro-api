package com.itzmeds.testapp.constants;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public interface AppConstants {

	default SimpleDateFormat getDateFormatter() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());
		dateFormat.setTimeZone(TimeZone.getDefault());
		return dateFormat;
	}

}