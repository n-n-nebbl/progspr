package at.ac.tuwien.ps.calculator.data;

import java.util.LinkedList;

public class CalculatorStack {

	LinkedList<Object> list = new LinkedList<>();
	
	public void addOnTop(Object element){
		list.addFirst(element);;
	}
	
	public void add(Object element, int level) {
		list.add(level-1, element);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T consumeObject(Class<T> clazz) {
		return (T) list.removeFirst();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T consumeObject(Class<T> clazz, int level) {
		return (T) list.remove(level-1);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getObject(Class<T> clazz) {
		return (T) list.getFirst();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getObject(Class<T> clazz, int level) {
		return (T) list.get(level-1);
	}
	
	public Object consumeObject() {
		return list.removeFirst();
	}
	
	public Object getObject() {
		return list.getFirst();
	}
	
	public Object getObject(int level) {
		return list.get(level-1);
	}

	public Object consumeObject(int level) {
		return list.remove(level-1);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(int i=0; i<list.size(); i++) {
			result.append(list.get(i)).append(" ");
		}
		return result.reverse().toString().trim();
	}
}
