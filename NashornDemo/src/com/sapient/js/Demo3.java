package com.sapient.js;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class Demo3 {

	public String sayHello(String name) {
		return "hello " + name;

	}
	public static String getDate() {
		DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MMM/yyyy");
		return LocalDate.now().format(df);
	}

}
