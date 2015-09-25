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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;


/**
 * Utility class for the use of Date and Calendar object.
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public class DateUtils implements DatePatterns
{

	/**
	 * Returns a list with all dateformats from the Interface DateFormats.
	 *
	 * @return Returns a list with all dateformats from the Interface DateFormats.
	 */
	public static List<String> getAllDateFormats()
	{
		final Field[] fields = DatePatterns.class.getFields();
		final List<String> list = new ArrayList<>(fields.length);
		for (final Field field : fields)
		{
			try
			{
				list.add((String)field.get(field.getName()));
			}
			catch (final IllegalArgumentException e)
			{
				e.printStackTrace();
			}
			catch (final IllegalAccessException e)
			{
				e.printStackTrace();
			}
			finally
			{
			}
		}
		return list;
	}

	/**
	 * Returns a map with all datepatterns from the Interface DatePatterns. As key is the name from
	 * the pattern.
	 *
	 * @return Returns a Map with all datepatterns from the Interface DatePatterns.
	 */
	public static Map<String, Object> getAllDatePatterns()
	{
		final Field[] fields = DatePatterns.class.getFields();
		final Map<String, Object> patterns = new HashMap<>(fields.length);
		for (final Field field : fields)
		{
			try
			{
				patterns.put(field.getName(), field.get(field.getName()));
			}
			catch (final IllegalArgumentException e)
			{
				e.printStackTrace();
			}
			catch (final IllegalAccessException e)
			{
				e.printStackTrace();
			}
			finally
			{
			}
		}
		return patterns;
	}

	/**
	 * The Method from the Date.getDay is deprecated. This is a helper-Method.
	 *
	 * @param date
	 *            The Date-object to get the day.
	 * @return The day from the Date-object.
	 */
	public static int getDay(final Date date)
	{
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * The Method from the Date.getHours is deprecated. This is a helper-Method.
	 *
	 * @param date
	 *            The Date-object to get the hours.
	 * @return The hours from the Date-object.
	 */
	public static int getHours(final Date date)
	{
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * The Method from the Date.getMinutes is deprecated. This is a helper-Method.
	 *
	 * @param date
	 *            The Date-object to get the minutes.
	 * @return The minutes from the Date-object.
	 */
	public static int getMinutes(final Date date)
	{
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * The Method from the Date.getMonth is deprecated. This is a helper-Method.
	 *
	 * @param date
	 *            The Date-object to get the month.
	 * @return The month from the Date-object.
	 */
	public static int getMonth(final Date date)
	{
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH);
	}

	/**
	 * The Method from the Date.getSeconds is deprecated. This is a helper-Method.
	 *
	 * @param date
	 *            The Date-object to get the seconds.
	 * @return The seconds from the Date-object.
	 */
	public static int getSeconds(final Date date)
	{
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.SECOND);
	}

	/**
	 * The week of the year as an int from the given Date-object.
	 *
	 * @param date
	 *            The Date-object to get the week of the year.
	 * @return The week of the year from the Date-object.
	 */
	public static int getWeekOfYear(final Date date)
	{
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * The year as int from the Date-object.
	 *
	 * @param date
	 *            The Date-object to get the year.
	 * @return The year from the Date-object.
	 */
	public static int getYear(final Date date)
	{
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * Returns a new {@link Date} object from the given Date object and sets the given parameters.
	 *
	 * @param dateToSet
	 *            the date to set
	 * @param hours
	 *            the hours
	 * @param minutes
	 *            the minutes
	 * @param seconds
	 *            the seconds
	 * @param milisec
	 *            the milisec
	 * @param zone
	 *            the zone
	 * @param locale
	 *            the a locale
	 * @return the date
	 */
	public static Date setDate(final Date dateToSet, final int hours, final int minutes,
		final int seconds, final int milisec, final TimeZone zone, final Locale locale)
	{
		final Calendar cal = Calendar.getInstance(zone, locale);
		cal.setTime(dateToSet);
		cal.set(Calendar.HOUR_OF_DAY, hours);
		cal.set(Calendar.MINUTE, minutes);
		cal.set(Calendar.SECOND, seconds);
		cal.set(Calendar.MILLISECOND, milisec);
		return cal.getTime();
	}

	/**
	 * Util-class. Do not make instances from this class.
	 */
	private DateUtils()
	{
	}

}