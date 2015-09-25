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

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * Helper class to present one long value from a calculate two Dates in a human readable string.
 * 
 * @version 1.0
 * @author Asterios Raptis
 */
public class Age implements Serializable
{

	/**
	 * The serialVersionUID from Age.
	 */
	private static final long serialVersionUID = -1110889254918807595L;

	/** The Constant ONE_SECOND. */
	public static final long ONE_SECOND = 1000l;

	/** The Constant ONE_MINUTE. */
	public static final long ONE_MINUTE = ONE_SECOND * 60l;

	/** The Constant ONE_HOUR. */
	public static final long ONE_HOUR = ONE_MINUTE * 60l;

	/** The Constant ONE_DAY. */
	public static final long ONE_DAY = ONE_HOUR * 24l;

	/** The Constant ONE_DEFAULT_MONTH. */
	public static final long ONE_DEFAULT_MONTH = ONE_DAY * 30l;

	/** The Constant ONE_YEAR. */
	public static final long ONE_YEAR = ONE_DAY * 365l + ONE_HOUR * 6l;

	/** The elapsed time in long. */
	private long elapsed;

	/** The birthday. */
	private Calendar birthday;

	/** The point where the Age stops. */
	private Calendar till;

	/**
	 * Instantiates a new Age object from the given Date objects.
	 * 
	 * @param birthday
	 *            The birthday.
	 */
	public Age(final Date birthday)
	{
		this(birthday, new Date(System.currentTimeMillis()));
	}

	/**
	 * Instantiates a new Age object from the given Date objects.
	 * 
	 * @param birthday
	 *            The birthday.
	 * @param till
	 *            The point where the Age stops.
	 */
	public Age(final Date birthday, final Date till)
	{
		this.elapsed = CalculateDateUtils.calculateElapsedTime(birthday, till);
		this.birthday = Calendar.getInstance();
		this.birthday.setTime(birthday);
		this.till = Calendar.getInstance();
		this.till.setTime(till);
	}

	/**
	 * Default constructor.
	 * 
	 * @param elapsed
	 *            The elapsed time in long.
	 */
	public Age(final long elapsed)
	{
		this.elapsed = elapsed;
	}

	/**
	 * Calculate in days.
	 * 
	 * @return the double
	 */
	public double calculateInDays()
	{

		return this.calculateInDays(this.elapsed);

	}

	/**
	 * Calculate in days.
	 * 
	 * @param time
	 *            the time
	 * @return the double
	 */
	public double calculateInDays(final long time)
	{

		return (double)time / (double)ONE_DAY;

	}

	/**
	 * Calculate in default month.
	 * 
	 * @return the double
	 */
	public double calculateInDefaultMonth()
	{
		return this.calculateInDefaultMonth(this.elapsed);
	}

	/**
	 * Calculate in default month. It is calculated that one default month is 30 days.
	 * 
	 * @param time
	 *            the time.
	 * @return the result as double.
	 */
	public double calculateInDefaultMonth(final long time)
	{
		return (double)time / (double)ONE_DEFAULT_MONTH;
	}

	/**
	 * Calculate in hours.
	 * 
	 * @return the double
	 */
	public double calculateInHours()
	{

		return this.calculateInHours(this.elapsed);

	}

	/**
	 * Calculate in hours.
	 * 
	 * @param time
	 *            the time
	 * @return the double
	 */
	public double calculateInHours(final long time)
	{

		return (double)time / (double)ONE_HOUR;

	}

	/**
	 * Calculate in minutes.
	 * 
	 * @return the double
	 */
	public double calculateInMinutes()
	{

		return this.calculateInMinutes(this.elapsed);

	}

	/**
	 * Calculate in minutes.
	 * 
	 * @param time
	 *            the time
	 * @return the double
	 */
	public double calculateInMinutes(final long time)
	{

		return (double)time / (double)ONE_MINUTE;

	}

	/**
	 * Calculate in seconds.
	 * 
	 * @return the double
	 */
	public double calculateInSeconds()
	{

		return this.calculateInSeconds(this.elapsed);

	}

	/**
	 * Calculate in minutes.
	 * 
	 * @param time
	 *            the time
	 * @return the double
	 */
	public double calculateInSeconds(final long time)
	{

		return (double)time / (double)ONE_SECOND;

	}

	/**
	 * Calculate in years.
	 * 
	 * @return the double
	 */
	public double calculateInYears()
	{

		return this.calculateInYears(this.elapsed);

	}

	/**
	 * Calculate in years.
	 * 
	 * @param el
	 *            The time.
	 * @return the double
	 */
	public double calculateInYears(final long el)
	{

		return (double)el / (double)ONE_YEAR;

	}

	/**
	 * Calculate in years months days hours minutes and seconds.
	 * 
	 * @return the int[] Returns an int array where the first element is the years the second
	 *         element the months the third element the days then hours, minutes and seconds.
	 */
	public int[] calculateInYearsMonthsDaysHoursMinutesAndSeconds()
	{

		return this.calculateInYearsMonthsDaysHoursMinutesAndSeconds(this.elapsed);

	}

	/**
	 * Calculate in years months days hours minutes and seconds.
	 * 
	 * @param compute
	 *            The long to calculate.
	 * @return the int[] Returns an int array where the first element is the years the second
	 *         element the months the third element the days then hours, minutes and seconds.
	 */
	public int[] calculateInYearsMonthsDaysHoursMinutesAndSeconds(final long compute)
	{
		long uebrig = -1;
		final int[] result = new int[6];
		final int years = (int)this.calculateInYears(compute);

		if (0 < years)
		{
			result[0] = years;
			uebrig = compute - years * ONE_YEAR;
		}
		else
		{
			result[0] = 0;
		}
		final int months = (int)this.calculateInDefaultMonth(uebrig);

		if (0 < months)
		{
			result[1] = months;
			uebrig -= months * ONE_DEFAULT_MONTH;
		}
		else
		{
			result[1] = 0;
		}

		final int days = (int)this.calculateInDays(uebrig);
		if (0 < days)
		{
			result[2] = days;
			uebrig -= days * ONE_DAY;
		}
		else
		{
			result[2] = 0;
		}
		final int hours = (int)this.calculateInHours(uebrig);
		if (0 < hours)
		{
			result[3] = hours;
			uebrig -= hours * ONE_HOUR;
		}
		else
		{
			result[3] = 0;
		}
		final int minutes = (int)this.calculateInMinutes(uebrig);
		if (0 < minutes)
		{
			result[4] = minutes;
			uebrig -= minutes * ONE_MINUTE;
		}
		else
		{
			result[4] = 0;
		}
		final int seconds = (int)this.calculateInSeconds(uebrig);
		if (0 < seconds)
		{
			result[5] = seconds;
			uebrig -= seconds * ONE_SECOND;
		}
		else
		{
			result[5] = 0;
		}

		return result;

	}

	/**
	 * Gets a human readable string from the age.
	 * 
	 * @return Returns a human readable string from the age.
	 */
	public String getHumanReadableAge()
	{
		return this.getHumanReadableAge(this.calculateInYearsMonthsDaysHoursMinutesAndSeconds());
	}

	/**
	 * Gets a human readable string from the age.
	 * 
	 * @param readableAge
	 *            The int array with the age values.
	 * @return Returns a human readable string from the age.
	 */
	public String getHumanReadableAge(final int[] readableAge)
	{
		if (null == readableAge || readableAge.length != 6)
		{
			throw new IllegalArgumentException(
				"Int array should not be null and the length should be equal 6.");
		}
		final StringBuffer result = new StringBuffer();
		result.append("Your are ");
		result.append(readableAge[0]).append(" years");
		result.append(" ");
		result.append(readableAge[1]).append(" months");
		result.append(" ");
		result.append(readableAge[2]).append(" days");
		result.append(" ");
		result.append(readableAge[3]).append(" hours");
		result.append(" ");
		result.append(readableAge[4]).append(" minutes");
		result.append(" ");
		result.append(readableAge[5]).append(" seconds");
		result.append(" young!");
		return result.toString();
	}

}
