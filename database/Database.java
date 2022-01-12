package database;

import java.util.ArrayList;
import java.io.*;

public class Database {
	
	public ArrayList<String> tableName;
	public ArrayList<Data> tables;
	
	public Database() {
		tableName = new ArrayList<String>();
		tables = new ArrayList<Data>();
	}
	
	public void persistence() {
		try {
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\Daves\\eclipse-workspace\\database\\src\\database\\persistence\\name.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			out.writeObject(tableName);
		
			out.close();
			fileOut.close();
	        System.out.printf("Serialized data is saved in name.ser");
			
	               
	        FileOutputStream fileOut2 = new FileOutputStream("C:\\Users\\Daves\\eclipse-workspace\\database\\src\\database\\persistence\\data.ser");
			ObjectOutputStream out2 = new ObjectOutputStream(fileOut2);

			out2.writeObject(tables);
			
			out2.close();
			fileOut2.close();
	        System.out.printf("Serialized data is saved in data.ser");

		}catch(IOException i) {
			i.printStackTrace();
		}
	}
	
	public boolean dbQuerry(String arguments[]) {// ,String arguments2[]) {
		
	if(arguments[0].equals("CREATE") && arguments[1].equals("TABLE")) {
		try {
			tableName.add(arguments[2]);
			int numDouble=0;
			int numChar=0;
			int numString=0;
			int numInt=0;
			
			int insideLength = ((arguments.length - 5) / 2);
			for(int i=6;i<6+(insideLength-1)*2;i++) {
				if(arguments[i].equals("STRING")) {
					numString++;
				}
				else if(arguments[i].equals("DOUBLE")) {
					numDouble++;
				}
				else if(arguments[i].equals("INTEGER")) {
					numInt++;
					
				}else if(arguments[i].equals("CHARACTER")) {
					numChar++;
				}
			}
			Data addTable = new Data(numString!=0,numDouble!=0,numInt!=0,numChar!=0);
			
			for(int i=6;i<6+(insideLength-1)*2;i++) {
				if(arguments[i].equals("STRING")) {
					System.out.println(arguments[i+1]);

					addTable.addStringName(arguments[i+1]);
				}
				else if(arguments[i].equals("DOUBLE")) {
					addTable.addDoubleName(arguments[i+1]);

				}
				else if(arguments[i].equals("INTEGER")) {
					addTable.addIntName(arguments[i+1]);

				}else if(arguments[i].equals("CHARACTER")) {
					addTable.addCharName(arguments[i+1]);
				}
			}
			
			tables.add(addTable);
			
			return true;
		}catch(Exception e) {
			System.out.println("No table name specified");
		}
	}
	if(arguments[0].equals("INSERT") && arguments[1].equals("INTO")&& arguments[2].equals("TABLE")) {
		try {
			String nameHolder = String.valueOf(arguments[3]);
			
			int searchIndex = tableName.indexOf(nameHolder);
			Data tableHolder = tables.get(searchIndex); //reference
			int insideLength = ((arguments.length - 9) / 3);
		
			for(int i=5,k=0;i<5+2*insideLength;i+=2,k++) {
					boolean test = tableHolder.searchInsert(arguments[i],arguments[i+1] ,arguments[8+2*insideLength+k]);
					if(!test) {
						System.out.println("Error Inputting Data");
					}
			}
			tableHolder.insertID();
			return true;
			}catch(Exception e) {
				System.out.println("Error in insert function");
				return false;
			}
		}else {
			return false;
		}
	}
}

