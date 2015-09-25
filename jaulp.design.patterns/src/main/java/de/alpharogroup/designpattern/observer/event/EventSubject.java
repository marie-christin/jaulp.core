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
package de.alpharogroup.designpattern.observer.event;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The Class EventSubject.
 *
 * @param <T>
 *            the generic type
 */
public class EventSubject<T> implements EventSource<T>
{

	/**
	 * Initialize block.
	 **/
	{
		eventListeners = new ArrayList<EventListener<T>>();
	}

	/** The event listeners. */
	private List<EventListener<T>> eventListeners;

	/** The source. */
	private T source;

	/**
	 * Instantiates a new event subject.
	 */
	public EventSubject()
	{
		super();
	}

	/**
	 * Instantiates a new event subject.
	 *
	 * @param source
	 *            the source
	 */
	public EventSubject(final T source)
	{
		super();
		this.source = source;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void addEventListener(final EventListener<T> eventListener)
	{
		eventListeners.add(eventListener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void addEventListeners(final Collection<EventListener<T>> eventListeners)
	{
		this.eventListeners.addAll(eventListeners);
	}

	/**
	 * Fires the source event and inform all registered listeners.
	 */
	private synchronized void fireEvent()
	{
		for (final EventListener<T> eventListener : eventListeners)
		{
			eventListener.onEvent(source);
		}
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void fireEvent(final T source)
	{
		this.source = source;
		fireEvent();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void removeEventListener(final EventListener<T> eventListener)
	{
		eventListeners.remove(eventListener);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void removeEventListeners(final Collection<EventListener<T>> eventListeners)
	{
		this.eventListeners.removeAll(eventListeners);
	}
}
