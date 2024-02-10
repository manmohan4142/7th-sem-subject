import java.net.*;
import java.io.*;
public class Server_s {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
ServerSocket ser;
int port=1200;
try
{
	ser=new ServerSocket(port);
	while(true)
	{
		Socket ss=ser.accept();
		ObjectInputStream r=new ObjectInputStream(new BufferedInputStream(ss.getInputStream()));
		Message m=(Message) r.readObject();
		System.out.println("Message from Client is ");
		System.out.println(m.getdata());
		ObjectOutputStream w=new ObjectOutputStream(new BufferedOutputStream(ss.getOutputStream()));
		int data=m.getdata();
		int i=data * data;
		Message m1=new Message(i);
		w.writeObject(m1);
		w.flush();
		
	}
}catch(IOException e){e.printStackTrace();}
catch(ClassNotFoundException e1){e1.printStackTrace();}
	}

}
