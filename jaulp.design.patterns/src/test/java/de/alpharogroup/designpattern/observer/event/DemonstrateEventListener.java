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

import javax.swing.JTextField;

/**
 * This class is to demonstrate the Event Listener interface.
 */
public class DemonstrateEventListener
{

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{

		withoutEventObject();

		withEventObject();
	}

	private static void withEventObject()
	{
		final EventListener<EventObject<JTextField>> printString = new EventListener<EventObject<JTextField>>()
		{

			@Override
			public void onEvent(final EventObject<JTextField> event)
			{
				System.out.println(event.getSource().getText());

			}
		};
		final EventListener<EventObject<JTextField>> printStringReverse = new EventListener<EventObject<JTextField>>()
		{

			@Override
			public void onEvent(final EventObject<JTextField> event)
			{
				System.out.println(new StringBuffer(event.getSource().getText()).reverse()
					.toString());

			}
		};
		final JTextField tx = new JTextField("Hello");
		final EventObject<JTextField> eventObject = new EventObject<>(tx);
		final EventSource<EventObject<JTextField>> eventSource = new EventSubject<>();
		eventSource.addEventListener(printString);
		eventSource.addEventListener(printStringReverse);
		eventSource.fireEvent(eventObject);
		tx.setText("good bye...");
		eventSource.fireEvent(eventObject);
	}

	private static void withoutEventObject()
	{
		final EventListener<String> printString = new EventListener<String>()
		{

			@Override
			public void onEvent(final String event)
			{
				System.out.println(event);

			}
		};
		final EventListener<String> printStringReverse = new EventListener<String>()
		{

			@Override
			public void onEvent(final String event)
			{
				System.out.println(new StringBuffer(event).reverse().toString());

			}
		};
		final EventSource<String> eventSource = new EventSubject<>();
		eventSource.addEventListener(printString);
		eventSource.addEventListener(printStringReverse);
		eventSource.fireEvent("Hallo");
	}
}
