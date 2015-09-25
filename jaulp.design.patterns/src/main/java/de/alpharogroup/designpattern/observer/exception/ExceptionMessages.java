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

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The Class ExceptionMessages.
 * 
 * @param <T>
 *            the generic type
 */
public class ExceptionMessages<T>
{

	/** Contains all exceptionmessages. */
	private final Map<String, Set<ExceptionMessage<T>>> exceptions = new HashMap<>();

	public void add(final Map<? extends String, ? extends Set<ExceptionMessage<T>>> keyListMap)
	{
		this.exceptions.putAll(keyListMap);
	}

	public void add(final String key, final ExceptionMessage<T> value)
	{
		Set<ExceptionMessage<T>> values = this.exceptions.get(key);
		if (null == values)
		{
			values = new HashSet<>();
			this.exceptions.put(key, values);
		}
		values.add(value);
	}

	public boolean containsKey(final String key)
	{
		return this.exceptions.containsKey(key);
	}

	public Set<ExceptionMessage<T>> get(final String key)
	{
		return this.exceptions.get(key);
	}

	public Set<String> getKeys()
	{
		return this.exceptions.keySet();
	}

	public int getSize()
	{
		return this.exceptions.size();
	}

	public boolean isEmpty()
	{
		return this.exceptions.isEmpty();
	}

	public Set<ExceptionMessage<T>> remove(final String key)
	{
		return this.exceptions.remove(key);
	}

	public void removeAll(final Collection<String> keys)
	{
		for (final String key : keys)
		{
			this.remove(key);
		}
	}

}
