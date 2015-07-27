package at.ac.tuwien.ps.calculator.data;

import at.ac.tuwien.ps.calculator.io.CalculatorInput;

public class NegationToken extends Token<Character> {

	@Override
	public void executeStackOperation(CalculatorStack stack, CalculatorInput input) {
		Integer first = stack.consumeObject(Integer.class);
		stack.addOnTop(-first);
	}
}
