package at.ac.tuwien.ps.calculator.data;

import at.ac.tuwien.ps.calculator.io.CalculatorInput;

public class LessThanToken extends Token<Character> {
	
	@Override
	public void executeStackOperation(CalculatorStack stack, CalculatorInput input) {
		int first = stack.consumeObject(Integer.class).intValue();
		int second = stack.consumeObject(Integer.class).intValue();
		Integer result = (first < second) ? 1 : 0;
		stack.addOnTop(result);
	}
}
