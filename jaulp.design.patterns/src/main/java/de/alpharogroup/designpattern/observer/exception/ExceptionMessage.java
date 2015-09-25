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
package de.alpharogroup.designpattern.observer.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for Messages in Exception classes.
 *
 * @version 1.0
 * @author Asterios Raptis
 * @param <T>
 *            the generic type
 */
public class ExceptionMessage<T> implements Serializable
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** Reference for the key in the resources bundle. */
	private String propertiesKey;

	/** Reference for the value in the resources bundle. */
	private String propertiesValue;

	/** Reference for the id in the database. */
	private String id;

	/** The additions. */
	private List<T> additions = new ArrayList<>();

	/**
	 * Default constructor.
	 *
	 * @param propertiesKey
	 *            the properties key
	 * @param propertiesValue
	 *            the properties value
	 * @param id
	 *            the id
	 */
	public ExceptionMessage(final String propertiesKey, final String propertiesValue,
		final String id)
	{
		this(propertiesKey, propertiesValue, id, null);
	}

	/**
	 * Default constructor.
	 *
	 * @param propertiesKey
	 *            the properties key
	 * @param propertiesValue
	 *            the properties value
	 * @param id
	 *            the id
	 * @param additions
	 *            The additions.
	 */
	public ExceptionMessage(final String propertiesKey, final String propertiesValue,
		final String id, final List<T> additions)
	{
		super();
		this.propertiesKey = propertiesKey;
		this.propertiesValue = propertiesValue;
		this.id = id;
		this.additions = additions;
	}


	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null)
		{
			return false;
		}
		if (o.getClass() != getClass())
		{
			return false;
		}
		final ExceptionMessage<T> castedObj = (ExceptionMessage<T>)o;
		return (this.propertiesKey == null ? castedObj.propertiesKey == null : this.propertiesKey
			.equals(castedObj.propertiesKey))
			&& (this.propertiesValue == null
				? castedObj.propertiesValue == null
				: this.propertiesValue.equals(castedObj.propertiesValue))
			&& (this.id == null ? castedObj.id == null : this.id.equals(castedObj.id))
			&& (this.additions == null ? castedObj.additions == null : this.additions
				.equals(castedObj.additions));
	}

	/**
	 * Gets the additions.
	 *
	 * @return the additions
	 */
	public List<T> getAdditions()
	{
		return this.additions;
	}

	/**
	 * Gets the exception code.
	 *
	 * @return the exception code
	 */
	public String getId()
	{
		return this.id;
	}

	/**
	 * Gets the properties key.
	 *
	 * @return the properties key
	 */
	public String getPropertiesKey()
	{
		return this.propertiesKey;
	}

	/**
	 * Gets the properties value.
	 *
	 * @return the properties value
	 */
	public String getPropertiesValue()
	{
		return this.propertiesValue;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (additions == null ? 0 : additions.hashCode());
		result = prime * result + (id == null ? 0 : id.hashCode());
		result = prime * result + (propertiesKey == null ? 0 : propertiesKey.hashCode());
		result = prime * result + (propertiesValue == null ? 0 : propertiesValue.hashCode());
		return result;
	}

	/**
	 * Sets the additions.
	 *
	 * @param additions
	 *            the new additions
	 */
	public void setAdditions(final List<T> additions)
	{
		this.additions = additions;
	}

	/**
	 * Sets the exception code.
	 *
	 * @param id
	 *            the new exception code
	 */
	public void setId(final String id)
	{
		this.id = id;
	}

	/**
	 * Sets the properties key.
	 *
	 * @param propertiesKey
	 *            the new properties key
	 */
	public void setPropertiesKey(final String propertiesKey)
	{
		this.propertiesKey = propertiesKey;
	}

	/**
	 * Sets the properties value.
	 *
	 * @param propertiesValue
	 *            the new properties value
	 */
	public void setPropertiesValue(final String propertiesValue)
	{
		this.propertiesValue = propertiesValue;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuffer buffer = new StringBuffer();
		buffer.append("[ExceptionMessage:");
		buffer.append(" propertiesKey: ");
		buffer.append(this.propertiesKey);
		buffer.append(" propertiesValue: ");
		buffer.append(this.propertiesValue);
		buffer.append(" exceptionCode: ");
		buffer.append(this.id);
		buffer.append(" additions: ");
		buffer.append(this.additions);
		buffer.append("]");
		return buffer.toString();
	}


}
