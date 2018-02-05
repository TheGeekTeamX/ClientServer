package Utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ConnectionSocket  {
	private Socket sock;
	private BufferedReader inFromClient;
	private DataOutputStream outToClient;
	/*Getters And Setters*/
	
	public Socket getSock() {
		return sock;
	}
	public ConnectionSocket(Socket s) {
		super();
		// TODO Auto-generated constructor stub
		if(s!=null)
		{
			try {
				this.inFromClient =new BufferedReader(new InputStreamReader(s.getInputStream()));
				this.outToClient = new DataOutputStream(s.getOutputStream());
				this.sock=s;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void setSock(Socket sock) {
		this.sock = sock;
	}
	public BufferedReader getInFromClient() {
		return inFromClient;
	}
	public void setInFromClient(BufferedReader inFromClient) {
		this.inFromClient = inFromClient;
	}
	public DataOutputStream getOutToClient() {
		return outToClient;
	}
	public void setOutToClient(DataOutputStream outToClient) {
		this.outToClient = outToClient;
	}
	
	/*Other Functions*/
	public void sendMessage(String msg)
	{
		try {
			this.outToClient.writeBytes(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String GetMessage()
	{
		try {
			return this.inFromClient.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void close()
	{
		try {
			this.sock.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
