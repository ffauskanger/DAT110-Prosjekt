package no.hvl.dat110.messaging;

import java.io.IOException;

import java.net.Socket;
import java.net.UnknownHostException;

public class MessagingClient {

	private String server;
	private int port;

	public MessagingClient(String server, int port) {
		this.server = server;
		this.port = port;
	}

	// connect to messaging server
	public Connection connect() {

		Socket clientSocket;
		Connection connection = null;

		// TODO
		// create TCP socket for client and connection
		
		try {
			clientSocket = new Socket(this.server, this.port);
			connection = new Connection(clientSocket);	
		}
		catch (IOException ex) {
			System.out.println("TCP Client Error: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(1);
		}
		
		return connection;
	}
}
