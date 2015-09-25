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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Utility class for the use of Date and Calendar object.
 *
 * @author Asterios Raptis
 * @version 1.0
 */
public class CalculateDateUtils implements DatePatterns
{

	/**
	 * Adds days to the given Date object and returns it. Note: you can add negative values too for
	 * get date in past.
	 *
	 * @param date
	 *            The Date object to add the days.
	 * @param addDays
	 *            The days to add.
	 * @return The resulted Date object.
	 */
	public static Date addDays(final Date date, final int addDays)
	{
		final Calendar dateOnCalendar = Calendar.getInstance();
		dateOnCalendar.setTime(date);
		dateOnCalendar.add(Calendar.DATE, addDays);
		return dateOnCalendar.getTime();
	}

	/**
	 * Adds hours to the given Date object and returns it. Note: you can add negative values too for
	 * get date in past.
	 *
	 * @param date
	 *            The Date object to add the hours.
	 * @param addHours
	 *            The days to add.
	 * @return The resulted Date object.
	 */
	public static Date addHours(final Date date, final int addHours)
	{
		final Calendar dateOnCalendar = Calendar.getInstance();
		dateOnCalendar.setTime(date);
		dateOnCalendar.add(Calendar.HOUR, addHours);
		return dateOnCalendar.getTime();
	}

	/**
	 * Adds milliseconds to the given Date object and returns it. Note: you can add negative values
	 * too for get date in past.
	 *
	 * @param date
	 *            The Date object to add the milliseconds.
	 * @param addMilliseconds
	 *            The milliseconds to add.
	 * @return The resulted Date object.
	 */
	public static Date addMilliseconds(final Date date, final int addMilliseconds)
	{
		final Calendar dateOnCalendar = Calendar.getInstance();
		dateOnCalendar.setTime(date);
		dateOnCalendar.add(Calendar.MILLISECOND, addMilliseconds);
		return dateOnCalendar.getTime();
	}

	/**
	 * Adds minutes to the given Date object and returns it. Note: you can add negative values too
	 * for get date in past.
	 *
	 * @param date
	 *            The Date object to add the minutes.
	 * @param addMinutes
	 *            The days to add.
	 * @return The resulted Date object.
	 */
	public static Date addMinutes(final Date date, final int addMinutes)
	{
		final Calendar dateOnCalendar = Calendar.getInstance();
		dateOnCalendar.setTime(date);
		dateOnCalendar.add(Calendar.MINUTE, addMinutes);
		return dateOnCalendar.getTime();
	}

	/**
	 * Adds months to the given Date object and returns it. Note: you can add negative values too
	 * for get date in past.
	 *
	 * @param date
	 *            The Date object to add the years.
	 * @param addMonths
	 *            The months to add.
	 * @return The resulted Date object.
	 */
	public static Date addMonths(final Date date, final int addMonths)
	{
		final Calendar dateOnCalendar = Calendar.getInstance();
		dateOnCalendar.setTime(date);
		dateOnCalendar.add(Calendar.MONTH, addMonths);
		return dateOnCalendar.getTime();
	}

	/**
	 * Adds seconds to the given Date object and returns it. Note: you can add negative values too
	 * for get date in past.
	 *
	 * @param date
	 *            The Date object to add the seconds.
	 * @param addSeconds
	 *            The seconds to add.
	 * @return The resulted Date object.
	 */
	public static Date addSeconds(final Date date, final int addSeconds)
	{
		final Calendar dateOnCalendar = Calendar.getInstance();
		dateOnCalendar.setTime(date);
		dateOnCalendar.add(Calendar.SECOND, addSeconds);
		return dateOnCalendar.getTime();
	}

	/**
	 * Adds weeks to the given Date object and returns it. Note: you can add negative values too for
	 * get date in past.
	 *
	 * @param date
	 *            The Date object to add the weeks.
	 * @param addWeeks
	 *            The weeks to add.
	 * @return The resulted Date object.
	 */
	public static Date addWeeks(final Date date, final int addWeeks)
	{
		return addDays(date, addWeeks * 7);
	}

	/**
	 * Adds years to the given Date object and returns it. Note: you can add negative values too for
	 * get date in past.
	 *
	 * @param date
	 *            The Date object to add the years.
	 * @param addYears
	 *            The years to add.
	 * @return The resulted Date object.
	 */
	public static Date addYears(final Date date, final int addYears)
	{
		final Calendar dateOnCalendar = Calendar.getInstance();
		dateOnCalendar.setTime(date);
		dateOnCalendar.add(Calendar.YEAR, addYears);
		return dateOnCalendar.getTime();
	}

	/**
	 * Returns true if the given from Date is after the given when Date otherwise false.
	 *
	 * @param point
	 *            the point of time from where to check if it is after.
	 * @param when
	 *            the when
	 * @return true, if successful
	 */
	public static boolean after(final Date point, final Date when)
	{
		final Calendar pointCalendar = Calendar.getInstance();
		pointCalendar.setTime(point);
		final Calendar whenCalendar = Calendar.getInstance();
		whenCalendar.setTime(when);
		return pointCalendar.after(whenCalendar);
	}

	/**
	 * Returns true if the given from Date is before the given when Date otherwise false.
	 *
	 * @param point
	 *            the point of time from where to check if it is before.
	 * @param when
	 *            the when
	 * @return true, if successful
	 */
	public static boolean before(final Date point, final Date when)
	{
		final Calendar pointCalendar = Calendar.getInstance();
		pointCalendar.setTime(point);
		final Calendar whenCalendar = Calendar.getInstance();
		whenCalendar.setTime(when);
		return pointCalendar.before(whenCalendar);
	}

	/**
	 * Calculates the elapsed time from the past to now.
	 *
	 * @param past
	 *            The Date object in the past.
	 * @param now
	 *            The Date from now.
	 * @return The elapsed time in long.
	 */
	public static long calculateElapsedTime(final Date past, final Date now)
	{
		final long elapsedTime = now.getTime() - past.getTime();
		return elapsedTime;
	}

	/**
	 * Calculates the elapsed time from the future to now.
	 *
	 * @param now
	 *            The Date from now.
	 * @param future
	 *            The Date in the future.
	 * @return The elapsed time in long.
	 */
	public static long calculateTimeFromNow(final Date now, final Date future)
	{
		final long elapsedTime = future.getTime() - now.getTime();
		return elapsedTime;
	}

	/**
	 * Computes the Age from the birthday till the computeDate object.
	 *
	 * @param birthday
	 *            The Date object from the birthday.
	 * @param computeDate
	 *            The Date-object from where to compute.
	 * @return Returns the computed age.
	 */
	public static int computeAge(final Date birthday, final Date computeDate)
	{
		final long ageInLong = CalculateDateUtils.calculateElapsedTime(birthday, computeDate);
		final Age age = new Age(ageInLong);
		return (int)age.calculateInYears();
	}

	/**
	 * Computes the eastern sunday for the given year. Year should be greater than 1583.
	 *
	 * @param year
	 *            The year to compute the eastern sunday.
	 * @return The eastern sunday.
	 */
	public static Date computeEasternSunday(final int year)
	{

		final int easternSundayNumber = computeEasternSundayNumber(year);
		final int month = easternSundayNumber / 31;
		final int day = easternSundayNumber % 31 + 1;

		return CreateDateUtils.newDate(year, month - 1, day);
	}

	/**
	 * Computes the number from eastern sunday for the given year. Year should be greater the 1583.
	 *
	 * @param year
	 *            The year to compute the number from eastern sunday.
	 * @return The number from eastern sunday.
	 */
	public static int computeEasternSundayNumber(final int year)
	{
		final int i = year % 19;
		final int j = year / 100;
		final int k = year % 100;
		final int l = (19 * i + j - j / 4 - (j - (j + 8) / 25 + 1) / 3 + 15) % 30;
		final int m = (32 + 2 * (j % 4) + 2 * (k / 4) - l - k % 4) % 7;
		final int n = l + m - 7 * ((i + 11 * l + 22 * m) / 451) + 114;
		return n;
	}

	/**
	 * Checks if the Date object "between" is between from the given to Date objects.
	 *
	 * @param start
	 *            the start time.
	 * @param end
	 *            the end time.
	 * @param between
	 *            the date to compare if it is between.
	 * @return true, if is between otherwise false.
	 */
	public static boolean isBetween(final Date start, final Date end, final Date between)
	{
		final long min = start.getTime();
		final long max = end.getTime();
		final long index = between.getTime();
		if (min <= index && index <= max)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Checks if the given date object is in the future.
	 *
	 * @param date
	 *            The date to check.
	 * @return Returns true if the given date is in the future otherwise false.
	 */
	public static boolean isDateInTheFuture(final Date date)
	{
		return !CalculateDateUtils.isDateInThePast(date);
	}

	/**
	 * Checks if the given date object is in the past.
	 *
	 * @param date
	 *            The date to check.
	 * @return Returns true if the given date is in the past otherwise false.
	 */
	public static boolean isDateInThePast(final Date date)
	{
		boolean inPast = false;
		final Calendar compare = Calendar.getInstance();
		compare.setTime(date);
		final Calendar now = Calendar.getInstance();
		now.setTime(new Date(System.currentTimeMillis()));
		inPast = now.after(compare);
		return inPast;
	}

	/**
	 * Determines if the given year is a leap year. Wrappes the method isLeapYear(int) from the
	 * GregorianCalendar.
	 *
	 * @param year
	 *            The year to determine.
	 * @return True if the year is a leap year otherwise false.
	 */
	public static boolean isLeapYear(final int year)
	{
		final GregorianCalendar gc = new GregorianCalendar();
		return gc.isLeapYear(year);
	}

	/**
	 * Checks if the Date is valid to convert.
	 *
	 * @param date
	 *            The Date as String
	 * @param format
	 *            The Format for the Date to parse
	 * @param lenient
	 *            Specify whether or not date/time interpretation is to be lenient.
	 * @return True if the Date is valid otherwise false.
	 */
	public static boolean isValidDate(final String date, final String format, final boolean lenient)
	{
		boolean isValid = true;
		if (date == null || format == null || format.length() <= 0)
		{
			return false;
		}
		final DateFormat df = new SimpleDateFormat(format);
		df.setLenient(lenient);
		try
		{
			df.parse(date);
		}
		catch (final ParseException e)
		{
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Substract days to the given Date object and returns it.
	 *
	 * @param date
	 *            The Date object to substract the days.
	 * @param substractDays
	 *            The days to substract.
	 * @return The resulted Date object.
	 */
	public static Date substractDaysFromDate(final Date date, final int substractDays)
	{
		final Calendar dateOnCalendar = Calendar.getInstance();
		dateOnCalendar.setTime(date);
		dateOnCalendar.add(Calendar.DATE, substractDays * -1);
		return dateOnCalendar.getTime();
	}

	/**
	 * Substract months to the given Date object and returns it.
	 *
	 * @param date
	 *            The Date object to substract the months.
	 * @param substractMonths
	 *            The months to substract.
	 * @return The resulted Date object.
	 */
	public static Date substractMonthsFromDate(final Date date, final int substractMonths)
	{
		final Calendar dateOnCalendar = Calendar.getInstance();
		dateOnCalendar.setTime(date);
		dateOnCalendar.add(Calendar.MONTH, substractMonths * -1);
		return dateOnCalendar.getTime();
	}

	/**
	 * Substract weeks to the given Date object and returns it.
	 *
	 * @param date
	 *            The Date object to substract the weeks.
	 * @param substractWeeks
	 *            The weeks to substract.
	 * @return The resulted Date object.
	 */
	public static Date substractWeeksFromDate(final Date date, final int substractWeeks)
	{
		return substractDaysFromDate(date, substractWeeks * 7);
	}

	/**
	 * Substract years to the given Date object and returns it.
	 *
	 * @param date
	 *            The Date object to substract the years.
	 * @param substractYears
	 *            The years to substract.
	 * @return The resulted Date object.
	 */
	public static Date substractYearsFromDate(final Date date, final int substractYears)
	{
		final Calendar dateOnCalendar = Calendar.getInstance();
		dateOnCalendar.setTime(date);
		dateOnCalendar.add(Calendar.YEAR, substractYears * -1);
		return dateOnCalendar.getTime();
	}

	/**
	 * Util-class. Do not make instances from this class.
	 */
	private CalculateDateUtils()
	{
	}

}
