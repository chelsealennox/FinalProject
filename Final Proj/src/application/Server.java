package application;
/**
 * Imports to use a server
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

public static String isPrime(int num) {
	if(num<2) {
	return "No";
	}
	int i=2;
	while(i<num) {
	if(num%i==0) {
	return "No";
	}
	i++;
	}
	return "Yes"; 
	}

public static void main(String[] args) {
		// TODO Auto-generated method stub

		try{
		ServerSocket ss=new ServerSocket(1900);
			/**
			 * establishes connection
			 */
		Socket s=ss.accept();
		DataInputStream dis=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());

		int num = (int)dis.readInt();
			
		/**
		 * Write return value to Client
		 */
		dout.writeUTF(isPrime(num));
		dout.flush();

		dout.close();
		ss.close();
			}
			
		catch(Exception e){
		System.out.println(e);
		}
		}
}//End of Server Class

