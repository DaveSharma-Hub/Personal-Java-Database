package database;

import java.io.Serializable;
import java.util.*;

public class Data implements Serializable{

	private ArrayList<stringCol> stringData;
	private ArrayList<doubleCol> doubleData;
	private ArrayList<intCol> intData;
	private ArrayList<charCol> charData;
	private ArrayList<Integer> id;
	
	private boolean hasString;
	private boolean hasDouble;
	private boolean hasInt;
	private boolean hasChar;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*Used for testing purposes only*/
//	public ArrayList<stringCol> stringData;
//	public ArrayList<doubleCol> doubleData;
//	public ArrayList<intCol> intData;
//	public ArrayList<charCol> charData;
//	public ArrayList<Integer> id;
//	
//	public boolean hasString;
//	public boolean hasDouble;
//	public boolean hasInt;
//	public boolean hasChar;
	
	public Data(boolean hasString,boolean hasDouble,boolean hasInt,boolean hasChar){
			this.hasString =hasString;
			this.hasDouble=hasDouble;
			this.hasInt= hasInt;
			this.hasChar=hasChar;
			this.id = new ArrayList<Integer>();
			this.initializeArray();
	}
	public ArrayList<stringCol> getStringData(){
		return this.stringData;
	}
	public ArrayList<doubleCol> getDoubleData(){
		return this.doubleData;
	}
	
	public ArrayList<intCol> getIntData(){
		return this.intData;
	}
	public ArrayList<charCol> getCharData(){
		return this.charData;
	}
	public ArrayList<Integer> getID(){
		return this.id;
	}

	private void initializeArray() {
		if(hasString) {
			this.stringData=new ArrayList<stringCol>(0);
		}
		if(hasDouble) {
			this.doubleData=new ArrayList<doubleCol>(0);
		}
		if(hasInt) {
			this.intData=new ArrayList<intCol>(0);
		}
		if(hasChar) {
			this.charData=new ArrayList<charCol>(0);
		}
	}
	public void addStringName( String val) {
			if(stringData.size()==0) {
				stringCol c1 =new stringCol();
				c1.addName(val);
				stringData.add(c1);
			}else {
				stringData.get(0).addName(val);
			}
	}
	public void addIntName(String val) {
		if(intData.size()==0) {
			intCol c1 =new intCol();
			c1.addName(val);
			intData.add(c1);
		}else {
			intData.get(0).addName(val);
		}
	}
	public void addDoubleName(String val) {
		if(doubleData.size()==0) {
			doubleCol c1 =new doubleCol();
			c1.addName(val);
			doubleData.add(c1);
		}else {
			doubleData.get(0).addName(val);
		}
	}
	public void addCharName(String val) {
		if(charData.size()==0) {
			charCol c1 =new charCol();
			c1.addName(val);
			charData.add(c1);
		}else {
			charData.get(0).addName(val);
		}
	}
	public boolean searchInsert(String name,String type,String data) {
		boolean checked=false;
		if(type.equals("s")) {
			ArrayList<String> arr = stringData.get(0).getName();
			for(int i=0;i<arr.size();i++) {
				if(arr.get(i).equals(name)) {
					try {
					int index = arr.indexOf(name);
					if(stringData.get(stringData.size()-1).getArray().size()!=0) {
						stringData.get(stringData.size()-1).getArray().set(index, data);
					}else {
						ArrayList<String> tmp = new ArrayList<String>(arr.size());
						for(int k=0;k<arr.size();k++) {
							tmp.add("0");
						}
						tmp.set(index, data);
						stringCol insertNew= new stringCol();
						insertNew.setArray(tmp);
						stringData.add(insertNew);
						}
					}catch(Exception e) {
						System.out.println("Error String");
					}
					checked=true;

				}
			}
		}
		if(type.equals("i")) {
			ArrayList<String> arr1 = intData.get(0).getName();
			for(int i=0;i<arr1.size();i++) {
				if(arr1.get(i).equals(name)) {
					
					try {
						int realData = Integer.valueOf(data);
						int index = arr1.indexOf(name);
						if(intData.get(intData.size()-1).getArray().size()!=0) {
							intData.get(intData.size()-1).getArray().set(index, realData);
						}else {

							ArrayList<Integer> tmp = new ArrayList<Integer>(arr1.size());
							for(int k=0;k<arr1.size();k++) {
								tmp.add(0);
							}
							tmp.set(index, realData);
							intCol insertNew= new intCol();
							insertNew.setArray(tmp);
							intData.add(insertNew);
							}
					}catch(Exception e){
						System.out.println("Error Int");
					}
					checked=true;
				}
			  }
		   }
		else if(type.equals("d")) {
			ArrayList<String> arr1 = doubleData.get(0).getName();
			for(int i=0;i<arr1.size();i++) {
				if(arr1.get(i).equals(name)) {
					
					try {
						double realData = Double.parseDouble(data);
						
						int index = arr1.indexOf(name);
						if(doubleData.get(doubleData.size()-1).getArray().size()!=0) {
							doubleData.get(doubleData.size()-1).getArray().set(index, realData);
						}else {
							ArrayList<Double> tmp = new ArrayList<Double>(arr1.size());
							for(int k=0;k<arr1.size();k++) {
								tmp.add(0.00);
							}
							tmp.set(index, realData);
							doubleCol insertNew= new doubleCol();
							insertNew.setArray(tmp);
							doubleData.add(insertNew);
							}
					}catch(Exception e){
						System.out.println("Error Double");
					}
					checked=true;
				}
			  }
		   }
		else if(type.equals("c")) {
			ArrayList<String> arr1 = charData.get(0).getName();
			for(int i=0;i<arr1.size();i++) {
				if(arr1.get(i).equals(name)) {

					try {
						
						char realData = data.charAt(0);
						
						int index = arr1.indexOf(name);				
						System.out.println("data:"+realData);
						if(charData.get(charData.size()-1).getArray().size()!=0) {
							charData.get(charData.size()-1).getArray().set(index, realData);
						}else {

							ArrayList<Character> tmp = new ArrayList<Character>(arr1.size());
							for(int k=0;k<arr1.size();k++) {
								tmp.add('0');
							}
							tmp.set(index, realData);
							charCol insertNew= new charCol();
							System.out.println("CHECK:"+tmp.get(index));

							insertNew.setArray(tmp);
							charData.add(insertNew);
							//System.out.println(charData.get(charData.size()-1).getArray());

							}
					}catch(Exception e){
						System.out.println("Error Char");
					}
					checked=true;
				}
			  }
		   }
		return checked;
	}
	public void insertID() {
		if(this.id==null) {
			this.id.add(1);

		}else {
			this.id.add(this.id.size()+1);

		}
	}
}
