package at.ac.tuwien.ps.calculator.data;

import at.ac.tuwien.ps.calculator.io.CalculatorInput;

public class ApplyToken extends Token<Character> {

	@Override
	public void executeStackOperation(CalculatorStack stack, CalculatorInput input) {
		String first = stack.getObject().toString();
		if(first.startsWith("'") && first.endsWith("'")){
			stack.consumeObject();
			input.pushBack(first.substring(1, first.length()-1));
		}
	}
}
