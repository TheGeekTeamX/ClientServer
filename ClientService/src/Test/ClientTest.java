package Test;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import Utils.Client;

public class ClientTest {
	public int test() {
		initServer();
		try {
			Socket sock=new Socket("localhost", 9999);
			Client c=new Client("1234", sock);
			String str="helloworld";
			c.getCs().sendMessage(str+'\n');
			System.out.println("send "+str);
			String res=c.getCs().GetMessage();
			if(str.compareTo(res)==0)
				return 1;
			else
				return -1;
				
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return 0;
	}

	public ClientTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void initServer() {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				String clientSentence;
				String capitalizedSentence;
				try {
					ServerSocket welcomeSocket = new ServerSocket(9999);
					Socket cs = welcomeSocket.accept();
					System.out.println("client login");
					BufferedReader inFromClient = new BufferedReader(new InputStreamReader(cs.getInputStream()));
					DataOutputStream outToClient = new DataOutputStream(cs.getOutputStream());
					clientSentence = inFromClient.readLine();
					System.out.println("recv: "+clientSentence);
					outToClient.writeBytes(clientSentence+'\n');
				} catch (IOException  e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		t.start();
	}

}
