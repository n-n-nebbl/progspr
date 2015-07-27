package at.ac.tuwien.ps.calculator.data;

public abstract class Token<T> implements StackOperation {

	private T token;
	
	public T getToken() {
		return token;
	}
	
	public void setToken(T token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return token.toString();
	}
}
