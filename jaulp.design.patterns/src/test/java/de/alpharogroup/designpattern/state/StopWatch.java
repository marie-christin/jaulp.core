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
 * The Class StopWatch.
 */
public class StopWatch
{

	/** The start time. */
	private long startTime = 0;

	/** The stop time. */
	private long stopTime = 0;

	/** The elapsed milliseconds. */
	private long elapsedMilliseconds = 0;

	/** The running. */
	private boolean running = false;

	/**
	 * Gets the elapsed milliseconds.
	 *
	 * @return the elapsed milliseconds
	 */
	public long getElapsedMilliseconds()
	{
		return elapsedMilliseconds;
	}


	/**
	 * Gets the elapsed time in milliseconds.
	 *
	 * @return the elapsed time in milliseconds
	 */
	public long getElapsedTimeInMilliseconds()
	{
		if (running)
		{
			elapsedMilliseconds = elapsedMilliseconds + System.currentTimeMillis() - startTime;
		}
		else
		{
			elapsedMilliseconds = elapsedMilliseconds + stopTime - startTime;
		}
		return elapsedMilliseconds;
	}

	/**
	 * Gets the elapsed time in seconds.
	 *
	 * @return the elapsed time in seconds
	 */
	public long getElapsedTimeInSeconds()
	{
		if (running)
		{
			elapsedMilliseconds = elapsedMilliseconds + System.currentTimeMillis() - startTime;
		}
		else
		{
			elapsedMilliseconds = elapsedMilliseconds + stopTime - startTime;
		}
		return elapsedMilliseconds / 1000;
	}

	/**
	 * Start.
	 */
	public void start()
	{
		this.startTime = System.currentTimeMillis();
		this.running = true;
	}


	/**
	 * Stop.
	 */
	public void stop()
	{
		this.stopTime = System.currentTimeMillis();
		this.running = false;
	}
}