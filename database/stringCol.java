package database;

import java.io.Serializable;
import java.util.*;

public class stringCol implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> array;
	private ArrayList<String> name;
	
	public stringCol() {
		this.array = new ArrayList<String>();
		this.name = new ArrayList<String>();
	}
	public ArrayList<String> getArray() {
		return this.array;
	}
	public ArrayList<String> getName(){
		return this.name;
	}
	public String getVal(int index) {
		return array.get(index);
	}
	public void updateData(int index,String val) {
		array.set(index, val);
	}
	public void addData(String val) {
		array.add(val);
	}
	public void addName(String name) {
		this.name.add(name);
	}
	public void setArray(ArrayList<String> arr) {
		this.array=arr;
	}
}
