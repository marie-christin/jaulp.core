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

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import de.alpharogroup.file.FilenameUtils;

/**
 * Utility class for Locales and Countries.
 * 
 * @author Asterios Raptis
 * @version 1.0
 */
public class LocaleUtils
{

	/**
	 * Array with all country codes.
	 */
	public static final String[] COUNTRY_CODES = Locale.getISOCountries();

	/** The Constant LANGUAGE_CODES. */
	public static final String[] LANGUAGE_CODES = Locale.getISOLanguages();

	/**
	 * Converts the given {@code String} code like "en", "en_US" or "en_US_win" to <b>new</b>
	 * {@code Locale}.
	 * 
	 * @param code
	 *            the code
	 * @return the {@code Locale} object or null.
	 */
	public static Locale getLocale(final String code)
	{
		if (code == null || code.isEmpty())
		{
			return null;
		}
		final String[] splitted = code.split("_");
		if (splitted.length == 1)
		{
			return new Locale(code);
		}
		if (splitted.length == 2)
		{
			return new Locale(splitted[0], splitted[1]);
		}
		if (splitted.length == 3)
		{
			return new Locale(splitted[0], splitted[1], splitted[2]);
		}
		return null;
	}

	/**
	 * Gets from the given properties file the locale code like "en", "en_US" or "en_US_win". For
	 * instance if the filename is resource_en.properties than it will return "en", if the filename
	 * is resource_en_US.properties than it will return "en_US". If nothing is found than it returns
	 * that the properties file is the "default".
	 * 
	 * @param propertiesFile
	 *            the properties file
	 * @return the locale code
	 */
	public static String getLocaleCode(final File propertiesFile)
	{
		final String filename = FilenameUtils.getFilenameWithoutExtension(propertiesFile);
		final int underscoreIndex = filename.indexOf("_");
		String stringCode = "default";
		if (0 < underscoreIndex)
		{
			stringCode = filename.substring(underscoreIndex + 1, filename.length());
		}
		return stringCode;
	}

	/**
	 * Gets the locale file name suffix that has the format 'language_COUNTRY_variant' for instance
	 * 'de_DE' for the Locale.GERMANY.
	 * 
	 * @param locale
	 *            the locale
	 * @return the locale name
	 */
	public static String getLocaleFilenameSuffix(final Locale locale)
	{
		return getLocaleFileSuffix(locale, true, true, false);
	}

	/**
	 * Gets the locale file name suffix for instance '_de_DE' for the Locale.GERMANY.
	 * 
	 * @param locale
	 *            the locale
	 * @param withCountry
	 *            the with country
	 * @return the locale file suffix
	 */
	public static String getLocaleFileSuffix(final Locale locale, final boolean withCountry)
	{
		return getLocaleFileSuffix(locale, withCountry, false);
	}

	/**
	 * Gets the locale file name suffix for instance '_de_DE' for the Locale.GERMANY.
	 * 
	 * @param locale
	 *            the locale
	 * @param withCountry
	 *            with country
	 * @param withVariant
	 *            with variant
	 * @return the locale file suffix
	 */
	public static String getLocaleFileSuffix(final Locale locale, final boolean withCountry,
		final boolean withVariant)
	{
		return getLocaleFileSuffix(locale, withCountry, withVariant, true);
	}

	/**
	 * Gets the locale file name suffix for instance '_de_DE' for the Locale.GERMANY.
	 * 
	 * @param locale
	 *            the locale
	 * @param withCountry
	 *            with country
	 * @param withVariant
	 *            with variant
	 * @param withUnderscorePrefix
	 *            true if the result has to have the underscore prefix
	 * @return the locale file suffix
	 */
	public static String getLocaleFileSuffix(final Locale locale, final boolean withCountry,
		final boolean withVariant, final boolean withUnderscorePrefix)
	{
		final StringBuilder localizedName = new StringBuilder();
		if (locale != null)
		{
			if (locale.getLanguage() != null && !locale.getLanguage().isEmpty())
			{
				if (withUnderscorePrefix)
				{
					localizedName.append("_");
				}
				localizedName.append(locale.getLanguage());
			}
			if (withCountry && locale.getCountry() != null && !locale.getCountry().isEmpty())
			{
				localizedName.append("_");
				localizedName.append(locale.getCountry());
			}
			if (withVariant && locale.getVariant() != null && !locale.getVariant().isEmpty())
			{
				localizedName.append("_");
				localizedName.append(locale.getVariant());
			}
		}
		return localizedName.toString().trim();
	}

	/**
	 * Gets the locale name for instance 'de_DE' for the Locale.GERMANY.
	 * 
	 * @param locale
	 *            the locale
	 * @return the locale name
	 * @deprecated use instead {@link LocaleUtils#getLocaleFilenameSuffix(Locale)}
	 */
	@Deprecated
	public static String getLocaleName(final Locale locale)
	{
		return getLocaleFileSuffix(locale, true, true, false);
	}

	/**
	 * Checks the given code if its a valide ISO 3166-1 countrycode.
	 * 
	 * @param code
	 *            The code to check.
	 * @return true if the code is valide otherwise false.
	 */
	public static boolean isISOCountryCode(String code)
	{
		if (code.length() == 2)
		{
			code = code.toUpperCase();
			final List<String> lc = Arrays.asList(LocaleUtils.COUNTRY_CODES);
			return lc.contains(code);
		}
		else
		{
			return false;
		}
	}

}
