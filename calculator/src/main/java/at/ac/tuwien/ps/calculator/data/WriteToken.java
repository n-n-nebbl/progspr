package at.ac.tuwien.ps.calculator.data;

import at.ac.tuwien.ps.calculator.io.CalculatorInput;

public class WriteToken extends Token<Character> {

	@Override
	public void executeStackOperation(CalculatorStack stack, CalculatorInput input) {
		String first = stack.consumeObject().toString();
		System.out.println(first);
	}
}
