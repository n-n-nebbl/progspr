package at.ac.tuwien.ps.calculator.data;

import at.ac.tuwien.ps.calculator.io.CalculatorInput;

public class PrimitiveToken extends Token<Object> {

	public PrimitiveToken(Object token) {
		setToken(token);
	}
	
	@Override
	public void executeStackOperation(CalculatorStack stack, CalculatorInput input) {
		stack.addOnTop(getToken());
	}
}
