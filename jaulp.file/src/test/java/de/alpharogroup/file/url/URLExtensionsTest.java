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
package de.alpharogroup.file.url;

import java.net.MalformedURLException;
import java.net.URL;

import lombok.experimental.ExtensionMethod;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import de.alpharogroup.file.zip.ZipTestCase;


@ExtensionMethod({ URLExtensions.class })
public class URLExtensionsTest extends ZipTestCase
{


	@Test
	public void testIsJar() throws MalformedURLException
	{
		final URL myURL = new URL("http://example.com/");
		AssertJUnit.assertFalse(myURL.isJar());
		final URL jarUrl = new URL("jar:file:/home/root/jdk/rt.jar!/test.xml");
		AssertJUnit.assertTrue(jarUrl.isJar());

	}


}
