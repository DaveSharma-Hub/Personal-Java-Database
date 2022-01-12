package database;

import java.io.Serializable;
import java.util.*;

public class charCol implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Character> array;
	private ArrayList<String> name;

	
	public charCol() {
		this.array = new ArrayList<Character>();
		this.name = new ArrayList<String>();
	}
	public ArrayList<Character> getArray() {
		return this.array;
	}
	public ArrayList<String> getName(){
		return this.name;
	}
	public Character getVal(int index) {
		return array.get(index);
	}
	public void updateData(int index,Character val) {
		array.set(index, val);
	}
	public void addData(Character val) {
		array.add(val);
	}
	public void addName(String name) {
		this.name.add(name);
	}
	public void setArray(ArrayList<Character> arr) {
		this.array= arr;
	}
}
