package at.ac.tuwien.ps.calculator.data;

import at.ac.tuwien.ps.calculator.io.CalculatorInput;

public interface StackOperation {

	void executeStackOperation(CalculatorStack stack, CalculatorInput input);
}
