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
package de.alpharogroup.designpattern.visitor.example.first;

import java.util.Iterator;

/**
 * The Class PrintActionCommandsMenuVisitor.
 */
public class PrintActionCommandsMenuVisitor implements MenuVisitor
{

	/**
	 * (non-Javadoc)
	 * 
	 * @see de.alpharogroup.designpattern.visitor.example.first.MenuVisitor#visit(de.alpharogroup.designpattern.visitor.example.first.Menu)
	 */
	@Override
	public void visit(final Menu menu)
	{
		System.out.println(menu.getName());
		final Iterator<MenuVisitableObject> iterator = menu.getChildren().iterator();
		while (iterator.hasNext())
		{
			final MenuVisitableObject menuVisitableObject = iterator.next();
			menuVisitableObject.accept(this);
		}
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see de.alpharogroup.designpattern.visitor.example.first.MenuVisitor#visit(de.alpharogroup.designpattern.visitor.example.first.MenuItem)
	 */
	@Override
	public void visit(final MenuItem menuItem)
	{
		System.out.println(menuItem.getActionCommand());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void visit(final MenuVisitableObject visitable)
	{
		visitable.accept(this);
	}

}
