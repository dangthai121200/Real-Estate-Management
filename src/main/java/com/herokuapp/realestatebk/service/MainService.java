package com.herokuapp.realestatebk.service;

import java.util.Date;

import com.herokuapp.realestatebk.exception.RealEsateException;

public class MainService {
	public static void checkStartDateAndEndDate(Date start, Date end, String messageErrorStart, String messageErrorEnd)
			throws RealEsateException {
		Date current = new Date();
		if (start.before(current)) {
			throw new RealEsateException(messageErrorStart);
		}
		if (end.before(start)) {
			throw new RealEsateException(messageErrorEnd);
		}

	}

	public static void checkStartDate(Date start, String messageErrorStart) throws RealEsateException {
		Date current = new Date();
		if (start.before(current)) {
			throw new RealEsateException(messageErrorStart);
		}
	}
}
