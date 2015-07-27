package at.ac.tuwien.ps.calculator.data;

import java.io.IOException;

import at.ac.tuwien.ps.calculator.io.CalculatorInput;

public class BlockToken extends Token<Character> {

	@Override
	public void executeStackOperation(CalculatorStack stack, CalculatorInput input) {
		try {
			stack.addOnTop("'" + input.readUntil('\'') + "'");
		} catch (IOException e) {
			throw new IllegalStateException("Could not read an Integer from the InputStream!", e);
		}
	}
}
