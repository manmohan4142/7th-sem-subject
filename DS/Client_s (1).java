import java.io.*;
import java.net.*;
public class Client_s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Socket s;
int port=1200;
try
{
InetAddress ser=InetAddress.getLocalHost();
s=new Socket(ser,port);
Message m=new Message(6);
ObjectOutputStream w=new ObjectOutputStream(new BufferedOutputStream(s.getOutputStream()));
w.writeObject(m);
w.flush();
ObjectInputStream r=new ObjectInputStream(new BufferedInputStream (s.getInputStream()));
Message m1=(Message)r.readObject();
int x=m1.getdata();
System.out.println(x);
w.close();
r.close();
s.close();
}
catch(IOException e){e.printStackTrace();}
catch(ClassNotFoundException e1){e1.printStackTrace();}

}

}

