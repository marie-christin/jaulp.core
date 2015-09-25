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
package de.alpharogroup.designpattern.state;

/**
 * The class StateContext.
 */
public class StateContext
{

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public static void main(final String[] args) throws InterruptedException
	{
		final StateContext context = new StateContext();
		context.start();
		Thread.sleep(1000);
		context.pause();
		Thread.sleep(1000);
		context.start();
		Thread.sleep(1000);
		context.stop();
		context.reset();
		context.start();
	}

	/** The stop watch. */
	private StopWatch stopWatch = new StopWatch();

	/** The current. */
	private State current = State.READY;

	/**
	 * Gets the current.
	 *
	 * @return the current
	 */
	public State getCurrent()
	{
		return current;
	}

	/**
	 * Gets the stop watch.
	 *
	 * @return the stop watch
	 */
	public StopWatch getStopWatch()
	{
		return stopWatch;
	}

	/**
	 * Pause.
	 */
	public void pause()
	{
		getCurrent().pause(this);
	}

	/**
	 * Reset.
	 */
	public void reset()
	{
		getCurrent().reset(this);
	}


	/**
	 * Sets the current.
	 *
	 * @param current
	 *            the new current
	 */
	public void setCurrent(final State current)
	{
		this.current = current;
	}

	/**
	 * Sets the stop watch.
	 *
	 * @param stopWatch
	 *            the new stop watch
	 */
	public void setStopWatch(final StopWatch stopWatch)
	{
		this.stopWatch = stopWatch;
	}

	/**
	 * Start.
	 */
	public void start()
	{
		getCurrent().start(this);
	}

	/**
	 * Stop.
	 */
	public void stop()
	{
		getCurrent().stop(this);
	}
}
