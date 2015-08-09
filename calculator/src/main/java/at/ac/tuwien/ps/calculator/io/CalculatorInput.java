package at.ac.tuwien.ps.calculator.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

import at.ac.tuwien.ps.calculator.data.PrimitiveToken;
import at.ac.tuwien.ps.calculator.data.Token;

public class CalculatorInput {

	public static final String DELIMITERS = " +-/*%&|=<>~cdai\\w";
	
	private Map<Character, Token> tokenMap;
	private InputStreamReader inputStream;
	private Queue<Token> lifoQueue = Collections.asLifoQueue(new LinkedList<Token>()) ;
	private List<Token> tokenList = new LinkedList<>();
	
	public CalculatorInput() {
	}
	
	public Token getNextToken() throws IOException {
		
		if(!lifoQueue.isEmpty()) {
			return lifoQueue.remove();
		}
		
		if(!tokenList.isEmpty()) {
			return tokenList.remove(0);
		}
		
		return null;
//		int read = inputStream.read();
//		if(read == -1) {
//			return null;
//		}
//		Character c = (char) read;
//		System.out.println("read:" + c);
//		return tokenMap.get(c);
	}
	
	public void addToken(String tokenString) {
		
		tokenList.add(getTokenFromString(tokenString));
	}
	
	private Token getTokenFromString(String tokenString) {
		if(tokenString == null) {
			throw new IllegalArgumentException("Null is not a token");
		}
		
		if(tokenString.length() == 1) {
			Character c = tokenString.charAt(0);
			Token t = tokenMap.get(c);
			if (t == null) {
				throw new IllegalArgumentException("This is not a token: " + tokenString); 
			}
			
			return t;
		} else {
			try {
				Integer integer = Integer.parseInt(tokenString);
				return new PrimitiveToken(integer);
			} catch (NumberFormatException ex) {
				throw new IllegalArgumentException("This is not a token: " + tokenString);
			}
		}
	}
	
	public String readUntil(Character end) throws IOException {
		StringBuilder result = new StringBuilder("");
		int read;
		while((read = inputStream.read()) != -1) {
			Character c = (char) read;
			if(c.equals(end)){
				break;
			}
			result.append(c);
		}
		return result.toString();
	}
	
	public Integer readInteger() throws IOException {
		StringBuilder result = new StringBuilder("");
		int read;
		while((read = inputStream.read()) != -1) {
			char c = (char) read;
			if('0' >= c || '9' <= c){
				break;
			}
			result.append(c);
		}
		return Integer.parseInt(result.toString());
	}
	
	public void pushBack(String s) {
		StringTokenizer tokenizer = new StringTokenizer(s, DELIMITERS, true);
		List<String> tokenStrings = new ArrayList<>(tokenizer.countTokens());
		
		while(tokenizer.hasMoreTokens()) {
			tokenStrings.add(tokenizer.nextToken());
		}
		
		for(int i=tokenStrings.size()-1; i>=0; i--){
			if (" ".equals(tokenStrings.get(i))) {
				continue;
			}
			lifoQueue.add(getTokenFromString(tokenStrings.get(i)));
		}
	}
	
	public void pushBack(Character c) {
		lifoQueue.add(tokenMap.get(c));
	}
	
	public void setTokenMap(Map<Character, Token> tokenMap) {
		this.tokenMap = tokenMap;
	}
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = new InputStreamReader(inputStream);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(Token t : lifoQueue) {
			builder.append(t.getToken() + " ");
		}
		for(Token t : tokenList) {
			builder.append(t.getToken() + " ");
		}
		return builder.toString();
	}
}
