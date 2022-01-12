package database;

import java.io.Serializable;
import java.util.*;
public class intCol implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> array;
	private ArrayList<String> name;

	
	public intCol() {
		this.array = new ArrayList<Integer>();
		this.name = new ArrayList<String>();

	}
	public ArrayList<Integer> getArray() {
		return this.array;
	}
	public ArrayList<String> getName(){
		return this.name;
	}
	public Integer getVal(int index) {
		return array.get(index);
	}
	public void updateData(int index,Integer val) {
		array.set(index,val);
	}
	public void addData(Integer val) {
		array.add(val);
	}
	public void addName(String name) {
		this.name.add(name);
	}
	public void setArray(ArrayList<Integer> arr) {
		this.array= arr;
	}
}
