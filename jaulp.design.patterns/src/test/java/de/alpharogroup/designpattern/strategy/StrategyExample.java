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
package de.alpharogroup.designpattern.strategy;

import de.alpharogroup.test.objects.AlgorithmModel;

public class StrategyExample
{

	public static void main(final String[] args)
	{
		Strategy<Integer, AlgorithmModel> strategy = new AdditionStrategy();
		Context<Integer, AlgorithmModel> context = new Context<>(strategy);
		Integer i = context.execute(new AlgorithmModel().setA(5).setB(15));
		System.out.println("Result from ComputeAddStrategy's execute():" + i);
		strategy = new SubtractionStrategy();
		context = new Context<>(strategy);
		i = context.execute(new AlgorithmModel().setA(5).setB(15));
		System.out.println("Result from ComputeSubtractStrategy's execute():" + i);
		strategy = new MultiplicationStrategy();
		context = new Context<>(strategy);
		i = context.execute(new AlgorithmModel().setA(5).setB(15));
		System.out.println("Result from MultiplicationStrategy's execute():" + i);

	}
}