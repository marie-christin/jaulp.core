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

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for the class ConvertDateUtils.
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public class ConvertDateUtilsTest
{

	/** The Constant YYYY_MM_DD. */
	private static final String YYYY_MM_DD = "yyyy-MM-dd";


	/** The format1. */
	private String format1 = null;

	/**
	 * Sets up method will be invoked before every unit test method in this class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@BeforeMethod
	protected void setUp() throws Exception
	{
		this.format1 = YYYY_MM_DD;
	}

	/**
	 * Tear down method will be invoked after every unit test method in this class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@AfterMethod
	protected void tearDown() throws Exception
	{
	}

	/**
	 * Test method for {@link de.alpharogroup.date.ConvertDateUtils#toCalendar(java.util.Date)} .
	 */
	@Test
	public void testConvertDateToCalendar()
	{

		final Date now = new Date();
		final Calendar calendar = ConvertDateUtils.toCalendar(now);
		final Date expected = calendar.getTime();
		AssertJUnit.assertTrue("The calendar should be equal with the date.", expected.equals(now));
	}

	/**
	 * Test method for {@link de.alpharogroup.date.ConvertDateUtils#toCalendar(java.util.Date)} .
	 * 
	 * @throws ParseException
	 *             occurs when their are problems with parsing the String to Date.
	 */
	@Test
	public void testConvertToCalendar() throws ParseException
	{
		final Date test = ParseDateUtils.parseToDate("1900-10-01", this.format1);
		final Calendar calendar = ConvertDateUtils.toCalendar(test);
		final Calendar compare = Calendar.getInstance();
		compare.setTime(test);
		AssertJUnit.assertTrue(calendar.equals(compare));
	}

	/**
	 * Test method for {@link de.alpharogroup.date.ConvertDateUtils#toDate(java.util.Calendar)} .
	 * 
	 * @throws ParseException
	 *             occurs when their are problems with parsing the String to Date.
	 */
	@Test
	public void testConvertToDate() throws ParseException
	{
		final Date expected = ParseDateUtils.parseToDate("1900-10-01", this.format1);
		final Calendar compare = Calendar.getInstance();
		compare.setTime(expected);
		final Date date = ConvertDateUtils.toDate(compare);
		AssertJUnit.assertTrue(date.equals(expected));
	}

	@Test
	public void testToCalendar() throws ParseException
	{
		final Date test = ParseDateUtils.parseToDate("1900-10-01", this.format1);
		final Calendar calendar = ConvertDateUtils.toCalendar(test.getTime());
		final Calendar compare = Calendar.getInstance();
		compare.setTime(test);
		AssertJUnit.assertTrue(calendar.equals(compare));
	}

	@Test
	public void testToDate() throws ParseException
	{
		final Date expected = ParseDateUtils.parseToDate("1900-10-01", this.format1);
		final long millis = expected.getTime();
		final Calendar compare = Calendar.getInstance();
		compare.setTime(expected);
		final Date actual = ConvertDateUtils.toDate(millis);
		AssertJUnit.assertTrue(actual.equals(expected));
	}

}
