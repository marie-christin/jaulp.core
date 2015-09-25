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
package de.alpharogroup.designpattern.builder;

public final class Car
{

	public static class Builder
	{
		// mandatory fields
		private final String type;
		// optional fields
		private int constructionYear;
		private String model;

		public Builder(final String type)
		{
			this.type = type;
		}

		public Car build()
		{
			return new Car(this);
		}

		public Builder constructionYear(final int constructionYear)
		{
			this.constructionYear = constructionYear;
			return this;
		}

		public Builder model(final String model)
		{
			this.model = model;
			return this;
		}
	}

	public static void main(final String... args)
	{
		// create the builder object...
		final Car.Builder builder = new Car.Builder("Lamborgini");
		// create Car object using the builder...
		final Car lamborgini = builder.model("Diablo").constructionYear(2006).build();
		System.out.println(lamborgini);
	}

	// all fields must be final so they are immutable objects
	private final String model;
	private final int constructionYear;

	private final String type;

	// private Constructor. Only the Builder can call it.
	private Car(final Builder builder)
	{
		this.model = builder.model;
		this.type = builder.type;
		this.constructionYear = builder.constructionYear;
	}

	public int getConstructionYear()
	{
		return constructionYear;
	}

	public String getModel()
	{
		return model;
	}

	public String getType()
	{
		return type;
	}

	@Override
	public String toString()
	{
		return "Car{" + "type='" + type + '\'' + ", model='" + model + '\'' + ", constructionYear="
			+ constructionYear + '}';
	}

}