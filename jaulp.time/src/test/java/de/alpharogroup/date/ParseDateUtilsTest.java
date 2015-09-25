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

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for the class ParseDateUtils.
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public class ParseDateUtilsTest
{

	/** The Constant DD_MM. */
	private static final String DD_MM = "dd.MM";

	/** The Constant YYYY_MMDD_HHMMSS. */
	private static final String YYYY_MMDD_HHMMSS = "yyyyMMddHHmmss";

	/** The Constant DD_MM_YYYY_HH_MM_SS. */
	private static final String DD_MM_YYYY_HH_MM_SS = "dd.MM.yyyy HH:mm:ss";

	/** The Constant YYYY_MM_DD. */
	private static final String YYYY_MM_DD = "yyyy-MM-dd";

	/** The datum1. */
	private String datum1 = null;

	/** The datum2. */
	private String datum2 = null;

	/** The datum3. */
	private String datum3 = null;

	/** The datum4. */
	private String datum4 = null;

	/** The format1. */
	private String format1 = null;

	/** The format2. */
	private String format2 = null;

	/** The format3. */
	private String format3 = null;

	/** The format4. */
	private String format4 = null;

	/** The expected date1. */
	private Date expectedDate1 = null;

	/** The expected date2. */
	private Date expectedDate2 = null;

	/** The expected date3. */
	private Date expectedDate3 = null;

	/** The expected date4. */
	private Date expectedDate4 = null;

	/**
	 * Sets up method will be invoked before every unit test method in this class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@BeforeMethod
	protected void setUp() throws Exception
	{
		this.datum1 = "2000-12-31";

		this.datum2 = "22.06.2005 09:04:55";
		this.datum3 = "20050621134451";
		this.datum4 = "32.13";
		this.format1 = YYYY_MM_DD;
		this.format2 = DD_MM_YYYY_HH_MM_SS;
		this.format3 = YYYY_MMDD_HHMMSS;
		this.format4 = DD_MM;

		this.expectedDate1 = CreateDateUtils.newDate(2000, 12, 31);
		this.expectedDate2 = CreateDateUtils.newDate(2005, 06, 22, 9, 4, 55);
		this.expectedDate3 = CreateDateUtils.newDate(2005, 6, 21, 13, 44, 51);
		this.expectedDate4 = CreateDateUtils.newDate(1971, 2, 1, 0, 0, 0);

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
		this.expectedDate1 = null;
		this.expectedDate2 = null;
		this.expectedDate3 = null;
		this.expectedDate4 = null;
	}

	/**
	 * Test method for
	 * {@link de.alpharogroup.date.ParseDateUtils#parseDate(java.lang.String, java.util.List)} .
	 */
	@Test
	public void testParseDate()
	{
		final Date date = ParseDateUtils.parseDate(this.datum1, DateUtils.getAllDateFormats());
		System.out.println(date);
		AssertJUnit.assertTrue(date.equals(this.expectedDate1));
	}

	/**
	 * Testparse to date.
	 *
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testparseToDate() throws ParseException
	{
		final Date date = ParseDateUtils.parseToDate("11.12.1960", DatePatterns.DOT_DD_MM_YYYY);
		System.out.println(date);
		// ----------------------------------------------
		final DateFormat df1 = new SimpleDateFormat(this.format1);
		final Date date1 = df1.parse(this.datum1);
		final Date test1 = ParseDateUtils.parseToDate(this.datum1, this.format1);
		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate1.equals(date1));
		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate1.equals(test1));
		AssertJUnit.assertTrue("Dates should be equal.", date1.equals(test1));
		// ----------------------------------------------
		final DateFormat df2 = new SimpleDateFormat(this.format2);
		final Date date2 = df2.parse(this.datum2);
		final Date test2 = ParseDateUtils.parseToDate(this.datum2, this.format2);

		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate2.equals(date2));
		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate2.equals(test2));
		AssertJUnit.assertTrue("Dates should be equal.", date2.equals(test2));
		// -----------------------------------------------
		final DateFormat df3 = new SimpleDateFormat(this.format3);
		final Date date3 = df3.parse(this.datum3);
		final Date test3 = ParseDateUtils.parseToDate(this.datum3, this.format3);

		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate3.equals(date3));
		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate3.equals(test3));
		AssertJUnit.assertTrue("Dates should be equal.", date3.equals(test3));
		// -----------------------------------------------
		final DateFormat df4 = new SimpleDateFormat(this.format4);
		final Date date4 = df4.parse(this.datum4);
		final Date test4 = ParseDateUtils.parseToDate(this.datum4, this.format4);

		System.out.println("date4:" + date4.toString());
		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate4.equals(date4));
		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate4.equals(test4));
		AssertJUnit.assertTrue("Dates should be equal.", date4.equals(test4));


		// -----------------------------------------------

	}

	@Test
	public void testParseToDateAndParseToString()
	{
		final String expected = "20120810";
		String actual = null;
		try
		{
			actual = ParseDateUtils.parseToString("10.08.2012", "dd.MM.yyyy", "yyyyMMdd");
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}
		AssertJUnit.assertTrue("Generated actual date string '" + actual
			+ "' should be equal with the expected value '" + expected + "'.",
			expected.equals(actual));
	}

	/**
	 * Test method for
	 * {@link de.alpharogroup.date.ParseDateUtils#parseToDateLenient(java.lang.String, java.lang.String, boolean)}
	 * .
	 *
	 * @throws ParseException
	 *             the parse exception
	 */
	@Test
	public void testParseToDateLenient() throws ParseException
	{
		// ----------------------------------------------
		final DateFormat df1 = new SimpleDateFormat(this.format1);
		final Date date1 = df1.parse(this.datum1);
		final Date test1 = ParseDateUtils.parseToDateLenient(this.datum1, this.format1, false);
		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate1.equals(date1));
		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate1.equals(test1));
		AssertJUnit.assertTrue("Dates should be equal.", date1.equals(test1));
		// ----------------------------------------------
		final DateFormat df2 = new SimpleDateFormat(this.format2);
		final Date date2 = df2.parse(this.datum2);
		final Date test2 = ParseDateUtils.parseToDateLenient(this.datum2, this.format2, false);

		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate2.equals(date2));
		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate2.equals(test2));
		AssertJUnit.assertTrue("Dates should be equal.", date2.equals(test2));
		// -----------------------------------------------
		final DateFormat df3 = new SimpleDateFormat(this.format3);
		final Date date3 = df3.parse(this.datum3);
		final Date test3 = ParseDateUtils.parseToDateLenient(this.datum3, this.format3, false);

		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate3.equals(date3));
		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate3.equals(test3));
		AssertJUnit.assertTrue("Dates should be equal.", date3.equals(test3));
		// -----------------------------------------------
		final DateFormat df4 = new SimpleDateFormat(this.format4);
		final Date date4 = df4.parse(this.datum4);
		final Date test4 = ParseDateUtils.parseToDateLenient(this.datum4, this.format4, false);

		AssertJUnit.assertNull("Dates should be equal.", test4);
		AssertJUnit.assertTrue("Dates should be equal.", this.expectedDate4.equals(date4));

		// -----------------------------------------------
	}

	/**
	 * Test method for
	 * {@link de.alpharogroup.date.ParseDateUtils#parseToDate(java.lang.String, java.lang.String)} .
	 */
	@Test
	public void testParseToDateStringString()
	{
		Date testDate = null;
		try
		{
			testDate = ParseDateUtils.parseToDate(this.datum1, this.format1);
		}
		catch (final ParseException e)
		{
			e.printStackTrace();
		}
		AssertJUnit.assertTrue("The expectedDate1 is not equal with the testDate.",
			this.expectedDate1.equals(testDate));
	}

	/**
	 * Test method for
	 * {@link de.alpharogroup.date.ParseDateUtils#parseToDate(java.lang.String, java.lang.String[], java.util.Locale)}
	 * .
	 */
	@Test
	public void testParseToDateStringStringArrayLocale()
	{
		final Locale de = new Locale("de", "DE");
		final String formats[] = { this.format2, this.format3 };
		Date testDate = ParseDateUtils.parseToDate(this.datum1, formats, de);
		assertNull(testDate);
		formats[0] = this.format1;
		testDate = ParseDateUtils.parseToDate(this.datum1, formats, de);
		assertNotNull(testDate);
		AssertJUnit.assertTrue("Generated testDate should be equal with the expectedDate1.",
			testDate.equals(this.expectedDate1));

	}

	/**
	 * Test method for
	 * {@link de.alpharogroup.date.ParseDateUtils#parseToString(java.util.Date, java.lang.String)} .
	 */
	@Test
	public void testParseToString()
	{
		final String testString = ParseDateUtils.parseToString(this.expectedDate1, this.format1);
		AssertJUnit.assertTrue("Generated testString should be equal with the datum1.",
			testString.equals(this.datum1));
		System.out.println();
	}

}
