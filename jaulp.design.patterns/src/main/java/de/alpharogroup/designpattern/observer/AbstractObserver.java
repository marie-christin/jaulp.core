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
package de.alpharogroup.designpattern.observer;

import de.alpharogroup.designpattern.observer.ifaces.DisplayViewElement;
import de.alpharogroup.designpattern.observer.ifaces.Observer;
import de.alpharogroup.designpattern.observer.ifaces.Subject;


/**
 * A generic implementation from the Observer-Pattern.
 * 
 * @param <T>
 *            the generic type
 */
public abstract class AbstractObserver<T> implements Observer<T>, DisplayViewElement
{

	/** The subject. */
	protected Subject<T, Observer<T>> subject;

	/** The observable. */
	private T observable;

	/**
	 * Constructor for a new observer object.
	 *
	 * @param subject
	 *            the subject
	 */
	public AbstractObserver(final Subject<T, Observer<T>> subject)
	{
		this.subject = subject;
		this.observable = subject.getObservable();
		this.subject.addObserver(this);
	}

	/**
	 * Gets the observable object.
	 *
	 * @return the observable
	 */
	public synchronized T getObservable()
	{
		return observable;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void update(final T observable)
	{
		this.observable = observable;
		displayView();
	}

}
