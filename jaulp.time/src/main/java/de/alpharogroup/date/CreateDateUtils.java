/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.date;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Utility class for the use of Date and Calendar object.
 *
 * @author Asterios Raptis
 * @version 1.0
 */
public final class CreateDateUtils implements DatePatterns
{

	/**
	 * Creates a date in past from the given Date back in milliseconds.
	 *
	 * @param from
	 *            the from
	 * @param millis
	 *            the millis
	 * @return the date
	 */
	public static Date inPast(final Date from, final int millis)
	{
		return CalculateDateUtils.addMilliseconds(from, (millis * (-1)));
	}

	/**
	 * Creates a new Date object from the given values.
	 *
	 * @param year
	 *            The year.
	 * @param month
	 *            The month.
	 * @param day
	 *            The day.
	 * @return Returns the created Date object.
	 */
	public static Date newDate(final int year, final int month, final int day)
	{
		return newDate(year, month, day, 0, 0, 0);
	}

	/**
	 * Creates a new Date object from the given values.
	 *
	 * @param year
	 *            The year.
	 * @param month
	 *            The month.
	 * @param day
	 *            The day.
	 * @param hour
	 *            The hour.
	 * @param min
	 *            The minute.
	 * @param sec
	 *            The second.
	 * @return Returns the created Date object.
	 */
	public static Date newDate(final int year, final int month, final int day, final int hour,
		final int min, final int sec)
	{
		return newDate(year, month, day, hour, min, sec, 0);
	}

	/**
	 * Creates a new Date object from the given values.
	 *
	 * @param year
	 *            The year.
	 * @param month
	 *            The month.
	 * @param day
	 *            The day.
	 * @param hour
	 *            The hour.
	 * @param minute
	 *            The minute.
	 * @param seconds
	 *            The second.
	 * @param milliSecond
	 *            The millisecond.
	 * @return Returns the created Date object.
	 */
	public static Date newDate(final int year, final int month, final int day, final int hour,
		final int minute, final int seconds, final int milliSecond)
	{
		final Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DATE, day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, seconds);
		calendar.set(Calendar.MILLISECOND, milliSecond);
		return calendar.getTime();
	}

	/**
	 * Creates the random date.
	 *
	 * @param from
	 *            the from
	 * @return the date
	 */
	public static Date newRandomDate(final Date from)
	{
		final Random secrand = new SecureRandom();
		final double randDouble = -secrand.nextDouble() * from.getTime();
		final double randomDouble = from.getTime() - secrand.nextDouble();
		final double result = randDouble * randomDouble;
		return new Date((long)result);
	}

	/**
	 * Creates a date from the current system time.
	 *
	 * @return the date
	 */
	public static Date now()
	{
		return new Date(System.currentTimeMillis());
	}

	/**
	 * Util-class. Do not make instances from this class.
	 */
	private CreateDateUtils()
	{
	}

}
