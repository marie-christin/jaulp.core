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
package de.alpharogroup.designpattern.observer.chat.listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MessageSubject<T> implements MessageSource<T>
{
	/**
	 * Initialize block.
	 **/
	{
		messageListeners = new ArrayList<>();
	}

	/** The source. */
	private T source;

	/** The event listeners. */
	private final List<MessageListener<T>> messageListeners;

	public MessageSubject()
	{
		super();
	}

	public MessageSubject(final T source)
	{
		super();
		this.source = source;
	}

	@Override
	public synchronized void addMessageListener(final MessageListener<T> messageListener)
	{
		messageListeners.add(messageListener);

	}

	@Override
	public synchronized void addMessageListeners(
		final Collection<MessageListener<T>> messageListeners)
	{
		this.messageListeners.addAll(messageListeners);
	}

	private synchronized void fireMessage()
	{
		for (final MessageListener<T> messageListener : messageListeners)
		{
			messageListener.onMessage(source);
		}
	}

	@Override
	public synchronized void fireMessage(final T source)
	{
		this.source = source;
		fireMessage();
	}

	@Override
	public synchronized void removeMessageListener(final MessageListener<T> messageListener)
	{
		messageListeners.remove(messageListener);
	}

	@Override
	public synchronized void removeMessageListeners(
		final Collection<MessageListener<T>> messageListeners)
	{
		this.messageListeners.removeAll(messageListeners);
	}

}
