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
package de.alpharogroup.designpattern.observer.ifaces;

import java.util.Collection;

/**
 * The Interface Subject.
 * 
 * @param <T>
 *            the generic type of the observable.
 * @param <O>
 *            the generic type of the observer
 */
public interface Subject<T, O extends Observer<T>>
{

	/**
	 * Adds the given observer.
	 *
	 * @param observer
	 *            the observer to be added.
	 */
	void addObserver(final O observer);

	/**
	 * Removes the given observer.
	 *
	 * @param observer
	 *            the observer to be remove.
	 */
	void removeObserver(final O observer);

	/**
	 * Adds the given observers.
	 *
	 * @param observers
	 *            the observers to be added.
	 */
	void addObservers(final Collection<O> observers);

	/**
	 * Removes the given observers.
	 *
	 * @param observers
	 *            the observers to be remove.
	 */
	void removeObservers(final Collection<O> observers);

	/**
	 * Update observers.
	 */
	void updateObservers();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	T getObservable();

	/**
	 * Sets the observable.
	 *
	 * @param observable
	 *            the new observable
	 */
	void setObservable(final T observable);

}
