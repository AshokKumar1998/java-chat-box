import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class chat2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
					
		ServerSocket ss;
		Socket s;

		 ss=new ServerSocket(8080);
		 s=ss.accept();
		
		sin g1=new sin(s);
		sout g2=new sout(s);
		}

}




class sin  extends Thread{

		String  in1="";
		DataInputStream in;


		sin(Socket s) throws Exception
		{
		in=new DataInputStream(s.getInputStream());
		Thread t3=new Thread(this,"go_for_get");
		t3.start();
		//System.out.println("Ready to Recieve Message on server");
		}

public void run(){
			//System.out.println("Entered into thread  --> SERVER, RECEIVE");
	try {
	 while(!in1.equals("end"))
		{		
		//	System.out.println("Entered into thread loop --> SERVER, RECEIVE");
		in1=in.readUTF();
		System.out.println("\t\t\t"+in1);
		}
	}
	catch(Exception e) {
		System.out.println("may throw an exception  :  "+e);
	}
}
}

class sout  extends Thread{

	public String out1="";
	DataOutputStream out;		
	BufferedReader br;
	

sout(Socket s) throws Exception{
	
	 out=new DataOutputStream(s.getOutputStream());
	
	br=new BufferedReader(new InputStreamReader(System.in));

	Thread t4=new Thread(this,"go_for_out");
	t4.start();
		//System.out.println("Ready to Send Message on server");

}

public void run(){
try {
			//System.out.println("Entered into thread --> SERVER, SEND");
    while(!out.equals("end"))
	{
			//System.out.println("Entered into thread loop --> SERVER, SEND");
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


