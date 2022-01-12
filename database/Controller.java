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
		
		String tmp [] = query.split(" ");
		return tmp;
	}
	
	public static void main(String [] args) {
		
		Controller server = new Controller(3000);
	
	}
}
