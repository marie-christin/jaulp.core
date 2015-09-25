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
package de.alpharogroup.constructorcallorder;

class Child extends Parent
{
	// Static init block
	static
	{
		System.out.println("static block - child");
	}
	Printer printer = new Printer()
	{
		@Override
		void print()
		{
			System.out.println("instance variable substitution from child");
		}
	};
	// Instance init block
	{
		System.out.println("instance init block - child");
	}

	// Constructor
	public Child()
	{
		System.out.println("constructor - child");
	}
}

/**
 * The Class ConstructorCallOrderExample demonstrates the call hierarchy from classes.
 */
public class ConstructorCallOrderExample
{

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		System.out.println("START");
		new Child();
		System.out.println("END");
	}
}

class Grandparent
{
	// Static init block
	static
	{
		System.out.println("static block - grandparent");
	}
	Printer substitution = new Printer()
	{
		@Override
		void print()
		{
			System.out.println("instance variable substitution from grandparent");
		}
	};
	// Instance init block
	{
		System.out.println("instance init block - grandparent");
	}

	// Constructor
	public Grandparent()
	{
		System.out.println("constructor - grandparent");
	}
}

class Parent extends Grandparent
{
	// Static init block
	static
	{
		System.out.println("static block - parent");
	}
	Printer substitution = new Printer()
	{
		@Override
		void print()
		{
			System.out.println("instance variable substitution from parent");
		}
	};
	// Instance init block
	{
		System.out.println("instance init block - parent");
	}

	// Constructor
	public Parent()
	{
		System.out.println("constructor - parent");
	}
}

class Printer
{
	Printer()
	{
		print();
	}

	void print()
	{
	}
}