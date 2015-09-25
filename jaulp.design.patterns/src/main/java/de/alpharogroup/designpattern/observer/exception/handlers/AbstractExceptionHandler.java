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
package de.alpharogroup.designpattern.observer.exception.handlers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.alpharogroup.designpattern.observer.exception.ExceptionEvent;
import de.alpharogroup.designpattern.observer.exception.ExceptionListener;

/**
 * The abstract class that handles all exceptions.
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public abstract class AbstractExceptionHandler implements Serializable
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	/** Lists of the ExceptionListeners. */
	private final List<ExceptionListener> listeners = new ArrayList<>();


	/**
	 * Adds an ExceptionListener object.
	 *
	 * @param listener
	 *            the listener
	 */
	void addExceptionListener(final ExceptionListener listener)
	{
		listeners.add(listener);
	}

	/**
	 * Removes an ExceptionListener object.
	 *
	 * @param listener
	 *            the listener
	 */
	void removeExceptionListener(final ExceptionListener listener)
	{
		listeners.remove(listener);
	}

	/**
	 * Update the given event.
	 *
	 * @param event
	 *            the event
	 */
	void update(final ExceptionEvent event)
	{
		for (final ExceptionListener listener : listeners)
		{
			updateEvent(listener, event);
		}
	}

	/**
	 * This method updates the listener for this event.
	 *
	 * @param listener
	 *            the listener
	 * @param event
	 *            the event
	 */
	public abstract void updateEvent(final ExceptionListener listener, final ExceptionEvent event);


}
