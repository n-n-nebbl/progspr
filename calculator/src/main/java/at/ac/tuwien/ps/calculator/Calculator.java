package at.ac.tuwien.ps.calculator;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import at.ac.tuwien.ps.calculator.data.AndToken;
import at.ac.tuwien.ps.calculator.data.ApplyToken;
import at.ac.tuwien.ps.calculator.data.BlockToken;
import at.ac.tuwien.ps.calculator.data.CalculatorStack;
import at.ac.tuwien.ps.calculator.data.CopyToken;
import at.ac.tuwien.ps.calculator.data.DeleteToken;
import at.ac.tuwien.ps.calculator.data.DivideToken;
import at.ac.tuwien.ps.calculator.data.EqualsToken;
import at.ac.tuwien.ps.calculator.data.GreaterThanToken;
import at.ac.tuwien.ps.calculator.data.IntegerToken;
import at.ac.tuwien.ps.calculator.data.LessThanToken;
import at.ac.tuwien.ps.calculator.data.MinusToken;
import at.ac.tuwien.ps.calculator.data.ModuloToken;
import at.ac.tuwien.ps.calculator.data.MultiplyToken;
import at.ac.tuwien.ps.calculator.data.NegationToken;
import at.ac.tuwien.ps.calculator.data.OrToken;
import at.ac.tuwien.ps.calculator.data.PlusToken;
import at.ac.tuwien.ps.calculator.data.PrimitiveToken;
import at.ac.tuwien.ps.calculator.data.Token;
import at.ac.tuwien.ps.calculator.data.WriteToken;
import at.ac.tuwien.ps.calculator.io.CalculatorInput;

public class Calculator {

	private Map<Character, Token> tokenMap = new HashMap<>();
	
	public static void main(String[] args) {
		new Calculator();
	}
	
	public Calculator() {
		initMap();
		
		InputStream inputStream = System.in;
		
		CalculatorStack stack = new CalculatorStack();
		CalculatorInput input = new CalculatorInput();
		
		input.setInputStream(inputStream);
		input.setTokenMap(tokenMap);
		
		Token token;
		try {
			while((token = input.getNextToken()) != null) {
				token.executeStackOperation(stack, input);
				System.out.println(stack);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void initMap() {
		tokenMap.put('0', new PrimitiveToken(0));
		tokenMap.put('1', new PrimitiveToken(1));
		tokenMap.put('2', new PrimitiveToken(2));
		tokenMap.put('3', new PrimitiveToken(3));
		tokenMap.put('4', new PrimitiveToken(4));
		tokenMap.put('5', new PrimitiveToken(5));
		tokenMap.put('6', new PrimitiveToken(6));
		tokenMap.put('7', new PrimitiveToken(7));
		tokenMap.put('8', new PrimitiveToken(8));
		tokenMap.put('9', new PrimitiveToken(9));
		tokenMap.put('+', new PlusToken());
		tokenMap.put('-', new MinusToken());
		tokenMap.put('/', new DivideToken());
		tokenMap.put('*', new MultiplyToken());
		tokenMap.put('%', new ModuloToken());
		tokenMap.put('&', new AndToken());
		tokenMap.put('|', new OrToken());
		tokenMap.put('=', new EqualsToken());
		tokenMap.put('<', new LessThanToken());
		tokenMap.put('>', new GreaterThanToken());
		tokenMap.put('~', new NegationToken());
		tokenMap.put('c', new CopyToken());
		tokenMap.put('d', new DeleteToken());
		tokenMap.put('a', new ApplyToken());
		tokenMap.put('i', new IntegerToken());
		tokenMap.put('\'', new BlockToken());
		tokenMap.put('w', new WriteToken());
	}

}
