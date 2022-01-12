package database;

import java.io.Serializable;
import java.util.*;
public class doubleCol implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Double> array;
	private ArrayList<String> name;

	
	public doubleCol() {
		this.array = new ArrayList<Double>();
		this.name = new ArrayList<String>();

	}
	public ArrayList<Double> getArray() {
		return this.array;
	}
	public ArrayList<String> getName(){
		return this.name;
	}
	public Double getVal(int index) {
		return array.get(index);
	}
	public void updateData(int index,Double val) {
		array.set(index, val);
	}
	public void addData(Double val) {
		array.add(val);
	}
	public void addName(String name) {
		this.name.add(name);
	}
	public void setArray(ArrayList<Double> arr) {
		this.array= arr;
	}
	
}
