package com.herokuapp.realestatebk.test;

import java.util.Date;

import com.herokuapp.realestatebk.exception.RealEsateException;

public class MainTest {

	public static void checkBirthDate(Date birthdate, String message, String messageAge) throws RealEsateException {
		Date current = new Date();
		if (birthdate.after(current)) {
			throw new RealEsateException(message);
		}
		int age = current.getYear() - birthdate.getYear();
		if (age < 18) {
			throw new RealEsateException(messageAge);
		}
	}

	public static void main(String[] args) throws RealEsateException {
		checkBirthDate(new Date("1990/01/01"), "error1", "error2");
	}
}
