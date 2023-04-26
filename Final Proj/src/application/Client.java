package application;
/**
 * Import to scan and use Data stream
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

public static void main(String[] args) {
		
	/**
	 * Scanner for user input
	 */
	Scanner scan = new Scanner(System.in);
	try{
	Socket s=new Socket("localhost",1900);
	DataInputStream dis=new DataInputStream(s.getInputStream());
	DataOutputStream dout=new DataOutputStream(s.getOutputStream());

	/**
	 *  Ask user for a number to input
	 */
	System.out.print("\nEnter a Number : ");
	int num = scan.nextInt();
			
	/**
	 *  Write integer to the server
	 */
	dout.writeInt(num);
	String ans = (String)dis.readUTF();
	System.out.println("\nNumber "+num+
	" Is Prime Number: "+ans);
	dout.flush();
	dout.close();
	s.close();
	}		catch(Exception e){
	System.out.println(e);
	}
	scan.close();
			
	}

}//End of Client Class
