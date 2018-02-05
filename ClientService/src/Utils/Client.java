package Utils;

import java.net.Socket;

public class Client {
	private String id;
	private ConnectionSocket cs;
	
	/*Getters and Setters*/
	public Client(String id,Socket sock) {
		super();
		this.id = id;
		this.cs=new ConnectionSocket(sock);
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ConnectionSocket getCs() {
		return this.cs;
	}
	public void setCs(ConnectionSocket cs) {
		this.cs = cs;
	}

	/*Other Functions*/
}

