package at.ac.tuwien.ps.calculator.data;

import at.ac.tuwien.ps.calculator.io.CalculatorInput;

public class DeleteToken extends Token<Character> {

	@Override
	public void executeStackOperation(CalculatorStack stack, CalculatorInput input) {
		Integer first = stack.consumeObject(Integer.class);
		Object consumed = stack.consumeObject(first.intValue());
		System.out.println("delete level {" + first + "} element {" + consumed.toString() + "}");
	}
}
