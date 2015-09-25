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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.alpharogroup.designpattern.observer.ifaces.Observer;
import de.alpharogroup.designpattern.observer.ifaces.Subject;

/**
 * The Class AbstractSubject is an implementation from the interface Subject. This class
 * encapsulates the observable and fires an update if the observable changes. The update informs all
 * registered observers about the change of the observable.
 *
 * @param <T>
 *            the generic type of the observable.
 * @param <O>
 *            the generic type of the observer
 */
public abstract class AbstractSubject<T, O extends Observer<T>> implements Subject<T, O>
{

	/**
	 * Initialize block.
	 **/
	{
		observers = new ArrayList<>();
	}

	/** The observers. */
	private final List<O> observers;

	/** The observable object. */
	private T observable;

	/**
	 * Default constructor for a new subject.
	 */
	public AbstractSubject()
	{
		super();
	}

	/**
	 * Constructor for a new subject with an observable.
	 *
	 * @param observable
	 *            the observable
	 */
	public AbstractSubject(final T observable)
	{
		super();
		this.observable = observable;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void addObserver(final O observer)
	{
		observers.add(observer);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void addObservers(final Collection<O> observers)
	{
		this.observers.addAll(observers);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized T getObservable()
	{
		return observable;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void removeObserver(final O observer)
	{
		final int index = this.observers.indexOf(observer);
		if (0 <= index)
		{
			this.observers.remove(observer);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void removeObservers(final Collection<O> observers)
	{
		this.observers.removeAll(observers);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void setObservable(final T observable)
	{
		this.observable = observable;
		updateObservers();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void updateObservers()
	{
		for (final O observer1 : this.observers)
		{
			final Observer<T> observer = observer1;
			observer.update(observable);
		}
	}

}
