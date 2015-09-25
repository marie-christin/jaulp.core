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

import java.io.IOException;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import de.alpharogroup.collections.ListExtensions;
import de.alpharogroup.date.CreateDateUtils;
import de.alpharogroup.lang.PackageUtils;
import de.alpharogroup.lang.PropertiesUtils;


public class PropertiesKeysListResolverTest
{

	@Test
	public void testGetResultListWithResourceBundleKey()
	{
		final Date now = CreateDateUtils.now();
		final List<ResourceBundleKey> values = Arrays.asList(ResourceBundleKey.builder().key("1")
			.parameters(ListExtensions.toObjectArray(now)).build(), ResourceBundleKey.builder()
			.key("2").parameters(ListExtensions.toObjectArray(7)).build(), ResourceBundleKey
			.builder().key("3").parameters(ListExtensions.toObjectArray("wonderful")).build());

		final PropertiesKeysListResolver<ResourceBundleKey> resolver = new PropertiesKeysListResolver<ResourceBundleKey>(
			"prefix", "suffix", values)
		{
			Properties properties;

			@Override
			public String getDisplayValue(final ResourceBundleKey object)
			{
				return MessageFormat.format(
					getProperties().getProperty(getPropertiesKey(object.getKey())),
					object.getParameters());
			}

			public Properties getProperties()
			{
				if (properties == null)
				{
					final String propertiesFilename = "resourcesWithParameters.properties";
					final String pathFromObject = PackageUtils.getPackagePathWithSlash(this);
					final String path = pathFromObject + propertiesFilename;

					try
					{
						properties = PropertiesUtils.loadProperties(path);
					}
					catch (final IOException e)
					{
						e.printStackTrace();
					}
				}
				return properties;
			}
		};
		final List<String> listDisplayValues = resolver.getResultList();
		AssertJUnit.assertEquals("Time of now is "
			+ DateFormat.getTimeInstance(DateFormat.SHORT).format(now) + " on "
			+ DateFormat.getDateInstance(DateFormat.LONG).format(now), listDisplayValues.get(0));
		AssertJUnit.assertEquals("The week have 7 days", listDisplayValues.get(1));
		AssertJUnit.assertEquals("It is a wonderful day", listDisplayValues.get(2));
	}


	@Test
	public void testGetResultListWithString()
	{
		final List<String> values = Arrays.asList("1", "2", "3");

		final PropertiesKeysListResolver<String> resolver = new PropertiesKeysListResolver<String>(
			"prefix", "suffix", values)
		{
			Properties properties;

			@Override
			public String getDisplayValue(final String object)
			{
				return getProperties().getProperty(getPropertiesKey(object));
			}

			public Properties getProperties()
			{
				if (properties == null)
				{
					final String propertiesFilename = "resources.properties";
					final String pathFromObject = PackageUtils.getPackagePathWithSlash(this);
					final String path = pathFromObject + propertiesFilename;

					try
					{
						properties = PropertiesUtils.loadProperties(path);
					}
					catch (final IOException e)
					{
						e.printStackTrace();
					}
				}
				return properties;
			}
		};
		final List<String> listDisplayValues = resolver.getResultList();
		AssertJUnit.assertEquals("testvalue1", listDisplayValues.get(0));
		AssertJUnit.assertEquals("testvalue2", listDisplayValues.get(1));
		AssertJUnit.assertEquals("testvalue3", listDisplayValues.get(2));

	}

}
