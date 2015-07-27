package at.ac.tuwien.ps.calculator.data;

import at.ac.tuwien.ps.calculator.io.CalculatorInput;

public class EqualsToken extends Token<Character> {

	@Override
	public void executeStackOperation(CalculatorStack stack, CalculatorInput input) {
		Integer first = stack.consumeObject(Integer.class);
		Integer second = stack.consumeObject(Integer.class);
		Integer result = (first.equals(second)) ? 1 : 0;
		stack.addOnTop(result);
	}
}
