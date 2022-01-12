package database;

import java.util.*;
import java.net.*;
import java.io.*;
import java.io.*;

public class Controller {
	
	private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input =  null;
	
	public Controller(int portNumber) {
		 try
	        {
	            this.server = new ServerSocket(portNumber);
	            System.out.println("Server started");
	 
	            System.out.println("Waiting for a client ...");
	 
	            socket = server.accept();
	            System.out.println("Client accepted");
	 
	            // takes input from the client socket
	            this.input = new DataInputStream(
	                new BufferedInputStream(socket.getInputStream()));
	 
	            String line = "";
	 
	            // reads message from client until "Over" is sent
	            while (!line.equals("exit"))
	            {
	                try
	                {
	                    line = input.readUTF();
	                    
	                    
	                    String arguments[] = parseThroughLine(line);
	            		Database db = new Database();
	            		db.dbQuerry(arguments);
	            		db.persistence();
	                    for(String c:arguments) {
	                    	System.out.println(c);
	                    }
	                }
	                catch(IOException i)
	                {
	                    System.out.println(i);
	                }
	            }
	            System.out.println("Closing connection");
	 
	            // close connection
	            socket.close();
	            input.close();
	        }
	        catch(IOException i)
	        {
	            System.out.println(i);
	        }
	}
	
	private String[] parseThroughLine(String query) {
		
		//ArrayList<String> tmp = new ArrayList<String>();
		String tmp [] = query.split(" ");
		return tmp;
	}
	
	public static void main(String [] args) {
		
		Controller server = new Controller(3000);
		
		
//		String arguments[] = {"CREATE","TABLE","doctor","(","INTEGER","id","STRING","name","STRING","patient","CHARACTER","registered","CHARACTER","checkup",")"};
//		String arguments2 [] = {"INSERT","INTO","TABLE","doctor","(","name","s","patient","s","registered","c","checkup","c",")","VALUES","(","Bob Turner","Jane","Y","N",")"};
//		String arguments3 [] = {"CREATE","TABLE","chat","(","INTEGER","id","DOUBLE","people","STRING","data",")"};
//
//		Database db = new Database();
//		db.dbQuerry(arguments);
//		db.dbQuerry(arguments2);
//		db.dbQuerry(arguments3);
//		db.persistence();
		
//		try {
//	         FileInputStream fileIn = new FileInputStream("C:\\Users\\Daves\\eclipse-workspace\\database\\src\\database\\persistence\\name.ser");
//	         ObjectInputStream in = new ObjectInputStream(fileIn);
//	         
//	         ArrayList<String> arr= (ArrayList) in.readObject();
//	         
//	         FileInputStream fileIn2 = new FileInputStream("C:\\Users\\Daves\\eclipse-workspace\\database\\src\\database\\persistence\\data.ser");
//	         ObjectInputStream in2 = new ObjectInputStream(fileIn2);
//	         
//	         ArrayList<Data> arr2= (ArrayList) in2.readObject();
//	         
//	         for(int i=0;i<arr.size();i++) {
//	        	 System.out.println(arr.get(i));
//	         }
//	        
//	         in2.close();
//	         fileIn2.close();
//	         in.close();
//	         fileIn.close();
//	      } catch (IOException i) {
//	         i.printStackTrace();
//	         return;
//	      } catch (ClassNotFoundException c) {
//	         System.out.println("Employee class not found");
//	         c.printStackTrace();
//	         return;
//	      }

//		System.out.println(db.tables.get(0).charData.get(1).getArray().get(0));//.get(0).getName().get(0));
		
//		DBTest test1 = new DBTest();
//		test1.givenQuery_whenCreatedTable_thenInputtedCorrectly();
//		test1.givenQuery_whenCreatedTableAndInsert_thenCorrectlyAdded();
//		
//		String arguments[] = {"CREATE","TABLE","chat","(","INTEGER","id","DOUBLE","people","STRING","data",")"};
//		String arguments2 [] = {"INSERT","INTO","TABLE","chat","(","people","d","data","s",")","VALUES","(","100","Try NOw",")"};
//		
//		Database db = new Database();
//		db.dbQuerry(arguments, arguments2);
//		
		

//		ArrayList<String> tableName =new ArrayList<String>();
//		ArrayList<Data> tables = new ArrayList<Data>();
//		String arguments[] = {"CREATE","TABLE","chat","(","INTEGER","id","DOUBLE","people","STRING","data",")"};
//		String arguments2 [] = {"INSERT","INTO","TABLE","chat","(","people","d","data","s",")","VALUES","(","100","Try NOw",")"};
//		if(arguments[0].equals("CREATE") && arguments[1].equals("TABLE")) {
//			try {
//				tableName.add(arguments[2]);
//				int numDouble=0;
//				int numChar=0;
//				int numString=0;
//				int numInt=0;
//				
//				int insideLength = ((arguments.length - 5) / 2);
//				for(int i=6;i<6+insideLength;i++) {
//					if(arguments[i].equals("STRING")) {
//						numString++;
//					}
//					else if(arguments[i].equals("DOUBLE")) {
//						numDouble++;
//					}
//					else if(arguments[i].equals("INTEGER")) {
//						numInt++;
//						
//					}else if(arguments[i].equals("CHARACTER")) {
//						numChar++;
//					}
//				}
//				Data addTable = new Data(numString!=0,numDouble!=0,numInt!=0,numChar!=0);
//				
//				for(int i=6;i<6+insideLength;i++) {
//					if(arguments[i].equals("STRING")) {
//						addTable.addStringName(arguments[i+1]);
//					}
//					else if(arguments[i].equals("DOUBLE")) {
//						addTable.addDoubleName(arguments[i+1]);
//
//					}
//					else if(arguments[i].equals("INTEGER")) {
//						addTable.addIntName(arguments[i+1]);
//
//					}else if(arguments[i].equals("CHARACTER")) {
//						addTable.addCharName(arguments[i+1]);
//					}
//				}
//				
//				tables.add(addTable);
//				
//				ArrayList<String> arr = (tables.get(0).stringData.get(0).getName());
//				for(int i=0;i<arr.size();i++) {
//
//					System.out.println(arr.get(i));
//				}
//				
//				String arr2 = (tableName.get(0));
//				System.out.println(arr2);
//			}catch(Exception e) {
//				System.out.println("No table name specified");
//			}
//		}
//		if(arguments2[0].equals("INSERT") && arguments2[1].equals("INTO")&& arguments2[2].equals("TABLE")) {
//			//try {
//				String nameHolder = String.valueOf(arguments2[3]);
//				
//				int searchIndex = tableName.indexOf(nameHolder);
//				Data tableHolder = tables.get(searchIndex); //reference
//				int insideLength = ((arguments2.length - 9) / 3);
//			
//				for(int i=5,k=0;i<5+2*insideLength;i+=2,k++) {
//						boolean test = tableHolder.searchInsert(arguments2[i],arguments2[i+1] ,arguments2[8+2*insideLength+k]);
//						if(!test) {
//							System.out.println("Error Inputting Data");
//						}
//				}
//				tableHolder.insertID();
////				Data addTable = new Data(numString!=0,numDouble!=0,numInt!=0,numChar!=0);
////				
////				for(int i=6;i<6+insideLength;i++) {
////					if(args[i].equals("STRING")) {
////						addTable.addStringName(args[i+1]);
////					}
////					else if(args[i].equals("DOUBLE")) {
////						addTable.addDoubleName(args[i+1]);
////
////					}
////					else if(args[i].equals("INTEGER")) {
////						addTable.addIntName(args[i+1]);
////
////					}else if(args[i].equals("CHARACTER")) {
////						addTable.addCharName(args[i+1]);
////					}
////				}
////				
////				tables.add(addTable);
////				ArrayList<String> arr = (tables.get(0).stringData.get(0).getName());
////				for(int i=0;i<arr.size();i++) {
////
////					System.out.println(arr.get(i));
////				}
//////				
////				System.out.println("Names:"+tableName.size());
////				System.out.println("Tables"+tables.size());
////				System.out.println("Inside");
////					
////				System.out.println(tables.get(0).stringData.get(1).getArray().get(0));
////				
////				System.out.println();
//				//tables.get(0);
//				
//			//}catch(Exception e) {
//			//	System.out.println("No table name specified");
//			//}
//			
//		}
//		System.out.println(tableName.get(0));
//		System.out.println(args[1]);
		//System.out.println("Hello");
	}
}
