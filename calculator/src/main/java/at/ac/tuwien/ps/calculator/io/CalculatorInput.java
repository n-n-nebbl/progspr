package at.ac.tuwien.ps.calculator.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import at.ac.tuwien.ps.calculator.data.Token;

public class CalculatorInput {

	private Map<Character, Token> tokenMap;
	private InputStreamReader inputStream;
	private Queue<Character> lifoQueue = Collections.asLifoQueue(new LinkedList<Character>()) ;
	
	public CalculatorInput() {
	}
	
	public Token getNextToken() throws IOException {
		
		if(!lifoQueue.isEmpty()) {
			return tokenMap.get(lifoQueue.remove());
		}
		
		int read = inputStream.read();
		if(read == -1) {
			return null;
		}
		Character c = (char) read;
		System.out.println("read:" + c);
		return tokenMap.get(c);
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
		for(int i=s.length()-1; i>=0; i--){
			lifoQueue.add(s.charAt(i));
		}
	}
	
	public void pushBack(Character c) {
		lifoQueue.add(c);
	}
	
	public void setTokenMap(Map<Character, Token> tokenMap) {
		this.tokenMap = tokenMap;
	}
	
	public void setInputStream(InputStream inputStream) {
		this.inputStream = new InputStreamReader(inputStream);
	}
}
