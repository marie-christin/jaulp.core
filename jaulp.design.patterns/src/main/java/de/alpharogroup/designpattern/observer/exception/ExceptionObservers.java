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

import java.util.ArrayList;
import java.util.List;

/**
 * The Class ExceptionObservers.
 */
public class ExceptionObservers
{

	/** The instance. */
	private static ExceptionObservers instance = null;

	/**
	 * Gets the single instance of ExceptionObservers.
	 *
	 * @return single instance of ExceptionObservers
	 */
	public static synchronized ExceptionObservers getInstance()
	{
		synchronized (ExceptionObservers.class)
		{
			if (instance == null)
			{
				instance = new ExceptionObservers();
			}
		}
		return instance;
	}

	/** The exception listeners. */
	protected List<ExceptionListener> exceptionListeners = new ArrayList<>();

	/**
	 * Instantiates a new exception observers.
	 */
	private ExceptionObservers()
	{
	}

	/**
	 * Adds the exception listener. This method allows classes to register for ExceptionEvents.
	 *
	 * @param listener
	 *            the listener
	 */
	public void addExceptionListener(final ExceptionListener listener)
	{
		exceptionListeners.add(listener);
	}

	/**
	 * Fire exception event.
	 *
	 * @param event
	 *            the event
	 */
	void fireExceptionEvent(final ExceptionEvent event)
	{
		final int listenerSize = exceptionListeners.size();
		for (int i = 0; i < listenerSize; i++)
		{
			final ExceptionListener lis = exceptionListeners.get(i);
			lis.onException(event);
		}
	}


	/**
	 * Removes the exception listener. This method allows classes to unregister for ExceptionEvents.
	 *
	 * @param listener
	 *            the listener
	 */
	public void removeExceptionListener(final ExceptionListener listener)
	{
		exceptionListeners.remove(listener);
	}
}
