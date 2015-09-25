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

import java.util.Collection;

/**
 * The Interface MessageSource.
 * 
 * @param <T>
 *            the generic type
 */
public interface MessageSource<T>
{

	/**
	 * Adds the given messageListeners to the existing messageListeners list.
	 * 
	 * @param messageListener
	 *            the MessageListener object
	 */
	void addMessageListener(final MessageListener<T> messageListener);

	/**
	 * Adds the all given messageListener to the existing messageListeners list.
	 * 
	 * @param messageListeners
	 *            the MessageListener objects
	 */
	void addMessageListeners(final Collection<MessageListener<T>> messageListeners);

	/**
	 * Fire the given message.
	 * 
	 * @param source
	 *            the message source
	 */
	void fireMessage(final T source);

	/**
	 * Removes the given MessageListener object from the existing messageListeners list.
	 * 
	 * @param messageListener
	 *            the MessageListener object
	 */
	void removeMessageListener(final MessageListener<T> messageListener);

	/**
	 * Removes the all given MessageListener objects from the messageListeners list.
	 * 
	 * @param messageListeners
	 *            the MessageListener objects
	 */
	void removeMessageListeners(final Collection<MessageListener<T>> messageListeners);

}