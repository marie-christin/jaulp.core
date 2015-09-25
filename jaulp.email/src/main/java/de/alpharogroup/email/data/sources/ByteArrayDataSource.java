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
package de.alpharogroup.email.data.sources;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataSource;

import lombok.Getter;

/**
 * DataSource object for a byte array.
 */
public class ByteArrayDataSource implements DataSource
{

	/** The OutputStream for the Bytearray. */
	@Getter
	private final ByteArrayOutputStream outputStream;

	/** The contenttype. */
	@Getter
	private final String contentType;

	/**
	 * Constructor with the bytearray and the contenttype.
	 *
	 * @param byteArray
	 *            the bytearray.
	 * @param contenttype
	 *            the contenttype.
	 */
	public ByteArrayDataSource(final byte[] byteArray, final String contenttype)
	{
		this.contentType = contenttype;
		final int len = byteArray.length;
		outputStream = new ByteArrayOutputStream(len);
		outputStream.write(byteArray, 0, len);
	}

	/**
	 * Gets the byte array.
	 *
	 * @return Returns the data.
	 */
	public byte[] getByteArray()
	{
		return outputStream.toByteArray();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return the input stream
	 *
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 *
	 * @see javax.activation.DataSource#getInputStream()
	 */
	@Override
	public InputStream getInputStream() throws IOException
	{

		return new ByteArrayInputStream(outputStream.toByteArray());
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return the name
	 *
	 * @see javax.activation.DataSource#getName()
	 */
	@Override
	public String getName()
	{
		return this.getClass().getCanonicalName();
	}

}
