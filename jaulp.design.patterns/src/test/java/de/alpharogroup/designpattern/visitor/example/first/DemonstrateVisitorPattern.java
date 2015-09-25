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

import java.util.ArrayList;

/**
 * The Class DemonstrateVisitorPattern.
 */
public class DemonstrateVisitorPattern
{

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		// The main menu.
		final Menu mainMenu = new Menu("Main", new ArrayList<MenuVisitableObject>());
		// Sub menu 'new' from main menu.
		final Menu mainMenuNew = new Menu("New", new ArrayList<MenuVisitableObject>());
		// Sub menuitems from the sub menu 'new'.
		mainMenuNew.getChildren().add(new MenuItem("File", "File action"));
		mainMenuNew.getChildren().add(new MenuItem("Folder", "Folder action"));
		// Sub menuitems from the main menu.
		mainMenu.getChildren().add(mainMenuNew);
		mainMenu.getChildren().add(new MenuItem("Open", "Open action"));
		mainMenu.getChildren().add(new MenuItem("Save", "Save action"));
		mainMenu.getChildren().add(new MenuItem("Print", "Print action"));

		// Test the PrintActionCommandsMenuVisitor...
		final MenuVisitor menuVisitor = new PrintActionCommandsMenuVisitor();
		menuVisitor.visit(mainMenu);
	}

}
