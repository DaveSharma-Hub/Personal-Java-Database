package database;
import java.net.*;
import java.io.*;

public class Connection {

	private Socket socket = null;
    private DataInputStream  input = null;
    private DataOutputStream output = null;
	
	public Connection(String address, int port) {
		try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
 
            // takes input from terminal
            input = new DataInputStream(System.in);
 
            // sends output to the socket
            output = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
 
        // string to read message from input
        String line = "";
 
        // keep reading until "Over" is input
        while (!line.equals("exit"))
        {
            try
            {
                line = input.readLine();
                output.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
 
        // close the connection
        try
        {
            input.close();
            output.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
	}
	public static void main(String args[]) {
		try {
		String ipAddress="";
		Connection client = new Connection(ipAddress,3000);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
