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
package de.alpharogroup.locale;

import java.util.Locale;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for the class LocaleUtils.
 * 
 * @version 1.0
 * @author Asterios Raptis
 */
public class LocaleUtilsTest
{

	boolean result;

	/**
	 * Sets up method will be invoked before every unit test method in this class.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@BeforeMethod
	protected void setUp() throws Exception
	{
		this.result = false;
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

	@Test(enabled = false)
	public void testGetLocale()
	{
		String code = null;
		Locale actual = LocaleUtils.getLocale(code);
		code = "";
		actual = LocaleUtils.getLocale(code);
		AssertJUnit.assertNull(actual);
		code = "de";
		actual = LocaleUtils.getLocale(code);
		Locale expected = new Locale(code);
		AssertJUnit.assertEquals(expected, actual);
		code = "de_DE";
		actual = LocaleUtils.getLocale(code);
		expected = new Locale("de", "DE");
		AssertJUnit.assertEquals(expected, actual);
		code = "de_DE_platt";
		actual = LocaleUtils.getLocale(code);
		expected = new Locale("de", "DE", "platt");
		AssertJUnit.assertEquals(expected, actual);
		final String[] countryCodes = Locale.getISOCountries();
		System.out.println(countryCodes.length);

		final String[] languageCodes = Locale.getISOLanguages();
		System.out.println(languageCodes.length);
	}

	@Test(enabled = true)
	public void testGetLocaleFileSuffix()
	{
		String expected = "_de_DE";
		String actual = LocaleUtils.getLocaleFileSuffix(Locale.GERMANY, true, true);
		AssertJUnit.assertEquals(expected, actual);
		expected = "_de";
		actual = LocaleUtils.getLocaleFileSuffix(Locale.GERMANY, false, true);
		AssertJUnit.assertEquals(expected, actual);
		expected = "de";
		actual = LocaleUtils.getLocaleFileSuffix(Locale.GERMANY, false, false, false);
		AssertJUnit.assertEquals(expected, actual);
		expected = "_de";
		actual = LocaleUtils.getLocaleFileSuffix(Locale.GERMAN, true, true);
		AssertJUnit.assertEquals(expected, actual);
		expected = "_el_GR";
		actual = LocaleUtils.getLocaleFileSuffix(Locales.HELLENIC, true, true);
		AssertJUnit.assertEquals(expected, actual);
		expected = "_el";
		actual = LocaleUtils.getLocaleFileSuffix(Locales.HELLENIC, false, true);
		AssertJUnit.assertEquals(expected, actual);
		actual = LocaleUtils.getLocaleFileSuffix(Locales.GREEK, true, true);
		AssertJUnit.assertEquals(expected, actual);
		expected = "";
		actual = LocaleUtils.getLocaleFileSuffix(null, false, true);
		AssertJUnit.assertEquals(expected, actual);
		expected = "_de_DE_schw";
		actual = LocaleUtils.getLocaleFileSuffix(Locales.SCHWAEBISCH, true, true);
		AssertJUnit.assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link de.alpharogroup.locale.LocaleUtils#isISOCountryCode(java.lang.String)}
	 * .
	 */
	@Test(enabled = false)
	public void testIsISOCountryCode()
	{

		final String toSmall = "D";
		final String de = "de";
		final String doesNotExist = "AB";

		this.result = LocaleUtils.isISOCountryCode(toSmall);
		AssertJUnit.assertFalse("", this.result);

		this.result = LocaleUtils.isISOCountryCode(doesNotExist);
		AssertJUnit.assertFalse("", this.result);

		this.result = LocaleUtils.isISOCountryCode(de);
		AssertJUnit.assertTrue("", this.result);

	}

}
