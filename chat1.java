import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class chat1  {


	public static void main(String[] args)  throws Exception{
		
		String ip;
		int port;
		ip="localhost";
		port=8080;
		Socket s=new Socket(ip,port);
		System.out.println("Request sent");
		
		in g1=new in(s);
		out g2=new out(s);
	}
	}


class in  extends Thread{

		String  in1="";
		DataInputStream in;


		in(Socket s) throws Exception
		{
		in=new DataInputStream(s.getInputStream());
		Thread t1=new Thread(this,"yoy");
		t1.start();
		//System.out.println("Ready to Recieve Message");
		}

public void run(){
			//System.out.println("Entered into thread --> CLIENT, RECEIVE");
	try {
	 while(!in1.equals("end"))
		{		
		//System.out.println("Entered into thread loop --> CLIENT, RECEIVE");
		in1=in.readUTF();
		System.out.println("\t\t\t"+in1);
		}
	}
	catch(Exception e) {
		System.out.println("may throw an exception   :  "+e);
	}
}
}

class out  extends Thread{

	public String out1="";
	DataOutputStream out;		
	BufferedReader br;
	

out(Socket s) throws Exception{
	
	out=new DataOutputStream(s.getOutputStream());
	
	br=new BufferedReader(new InputStreamReader(System.in));

	Thread t2=new Thread(this,"yo");
	t2.start();
		//System.out.println("Ready to Send Message");

}

public void run(){
		//	System.out.println("Entered into thread  --> CLIENT, SEND");
try {
	
    while(!out.equals("end"))
	{
		//	System.out.println("Entered into thread loop --> CLIENT, SEND");
	out1=br.readLine();
	out.writeUTF(out1);
	out.flush();		
	}

}
catch(Exception e) {
	System.out.println("may throw an exception  :  "+e);
}
}
}


