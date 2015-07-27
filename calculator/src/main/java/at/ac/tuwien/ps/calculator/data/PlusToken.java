package at.ac.tuwien.ps.calculator.data;

import at.ac.tuwien.ps.calculator.io.CalculatorInput;

public class PlusToken extends Token<Character> {
	
	@Override
	public void executeStackOperation(CalculatorStack stack, CalculatorInput input) {
		stack.addOnTop(stack.consumeObject(Integer.class) + stack.consumeObject(Integer.class));
	}
}
