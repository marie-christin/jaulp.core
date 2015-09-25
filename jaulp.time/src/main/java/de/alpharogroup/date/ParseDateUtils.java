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
import java.util.Date;
import java.util.List;
import java.util.Locale;


/**
 * Utility class for the use of Date and Calendar object.
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public class ParseDateUtils implements DatePatterns
{

	/**
	 * Tries to convert the given String to a Date.
	 *
	 * @param date
	 *            The date to convert as String.
	 * @param patterns
	 *            The date patterns to convert the String to a date-object.
	 * @return Gives a Date if the convertion was successfull otherwise false.
	 */
	public static Date parseDate(final String date, final List<String> patterns)
	{
		for (final String pattern : patterns)
		{
			final SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			try
			{
				final Date result = formatter.parse(date);
				return result;
			}
			catch (final ParseException e)
			{
				// Do nothing...
			}
		}
		return null;
	}

	/**
	 * Parses the String date to a date object. For example: USA-Format is : yyyy-MM-dd
	 *
	 * @param date
	 *            The Date as String
	 * @param format
	 *            The Format for the Date to parse
	 * @return The formated Date
	 * @throws ParseException
	 *             occurs when their are problems with parsing the String to Date.
	 */
	public static Date parseToDate(final String date, final String format) throws ParseException
	{
		final DateFormat df = new SimpleDateFormat(format);
		Date parsedDate = null;
		parsedDate = df.parse(date);
		return parsedDate;
	}

	/**
	 * Returns a date-object if the array with the formats are valid otherwise null.
	 *
	 * @param datum
	 *            The date as string which to parse to a date-object.
	 * @param formats
	 *            The string-array with the date-patterns.
	 * @param locale
	 *            THe Locale for the SimpleDateFormat.
	 * @return A date-object if the array with the formats are valid otherwise null.
	 */
	public static Date parseToDate(final String datum, final String[] formats, final Locale locale)
	{
		for (final String format : formats)
		{
			final SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
			try
			{
				return sdf.parse(datum);
			}
			catch (final ParseException e)
			{
				// Do nothing...
			}
		}
		return null;
	}

	/**
	 * Parses the String date to a date object. For example: USA-Format is : yyyy-MM-dd
	 *
	 * @param date
	 *            The Date as String
	 * @param format
	 *            The Format for the Date to parse
	 * @param lenient
	 *            Specify whether or not date/time interpretation is to be lenient.
	 * @return The formated Date or null.
	 */
	public static Date parseToDateLenient(final String date, final String format,
		final boolean lenient)
	{
		if (date == null || format == null || format.length() <= 0)
		{
			return null;
		}
		final DateFormat df = new SimpleDateFormat(format);
		df.setLenient(lenient);
		Date parsedDate = null;
		try
		{
			parsedDate = df.parse(date);
		}
		catch (final ParseException e)
		{
			// ignore...
		}
		return parsedDate;
	}

	/**
	 * The Method parseToString(Date, String) formats the given Date to the given Format. For
	 * Example: Date date =new Date(System.currentTimeMillis()); String format =
	 * "dd.MM.yyyy HH:mm:ss"; String now = UtilDate.parseToString(date, format);
	 * System.out.println(now); The output would be something like this:'15.07.2005 14:12:00'
	 *
	 * @param date
	 *            The Date to format to a String
	 * @param format
	 *            The Format for the date
	 * @return The formated String
	 */
	public static String parseToString(final Date date, final String format)
	{
		return parseToString(date, format, Locale.getDefault(Locale.Category.FORMAT));
	}

	/**
	 * The Method parseToString(Date, String) formats the given Date to the given Format. For
	 * Example: Date date =new Date(System.currentTimeMillis()); String format =
	 * "dd.MM.yyyy HH:mm:ss"; String now = UtilDate.parseToString(date, format);
	 * System.out.println(now); The output would be something like this:'15.07.2005 14:12:00'
	 *
	 * @param date
	 *            The Date to format to a String
	 * @param format
	 *            The Format for the date
	 * @param locale
	 *            The Locale object in which Language to get the format string.
	 * @return The formated String
	 */
	public static String parseToString(final Date date, final String format, final Locale locale)
	{
		final DateFormat df = new SimpleDateFormat(format, locale);
		final String result = df.format(date);
		return result;
	}

	/**
	 * The Method parseToString(String, String, String) formats the given Date as string from the
	 * current Format to the new given Format. For Example:<br>
	 * <br>
	 * <code> String expected = "20120810";<br>
	 * String actual = ParseDateUtils.parseToString(
	 *     			ParseDateUtils.parseToDate("10.08.2012", "dd.MM.yyyy"), "yyyyMMdd");
	 *     </code><br>
	 * <br>
	 * The output is:20120810
	 *
	 * @param date
	 *            The date as String object that shell be parsed to the new format
	 * @param currentformat
	 *            The current format from the date
	 * @param newFormat
	 *            The new format for the output date as String object
	 * @return The formated String in the new date format
	 * @throws ParseException
	 *             occurs when their are problems with parsing the String to Date.
	 */
	public static String parseToString(final String date, final String currentformat,
		final String newFormat) throws ParseException
	{
		final Date currentDate = parseToDate(date, currentformat);
		final String result = parseToString(currentDate, newFormat);
		return result;
	}

	/**
	 * Util-class. Do not make instances from this class.
	 */
	private ParseDateUtils()
	{
	}

}
