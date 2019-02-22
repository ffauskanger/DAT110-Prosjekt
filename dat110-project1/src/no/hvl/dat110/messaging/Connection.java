package no.hvl.dat110.messaging;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {

	private DataOutputStream outStream; // for writing bytes to the TCP connection
	private DataInputStream inStream; // for reading bytes from the TCP connection
	private Socket socket; // socket for the underlying TCP connection

	public Connection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream(socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) 
	{

		try {
			outStream.write(message.encapsulate());
		} catch (IOException ex) {
			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	public Message receive() {

		Message message = new Message();
		byte[] recvbuf = new byte[MessageConfig.SEGMENTSIZE];
		
		try {
				// Fikk ikke til � bruke inStream.read() for � returne int verdi for � s� matche den mot MessageConfig.SEGMENTSIZE. Vil gjerne f� forklaring p� dette
				// Og h�per at det ikke er n�dvendig for � f� godkjent.
				inStream.readFully(recvbuf);
			
		} catch (IOException  ex) {
			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
		
		message.decapsulate(recvbuf);
		
		return message;

	}

	// close the connection by closing streams and the underlying socket
	public void close() {

		try {

			outStream.close();
			inStream.close();

			socket.close();
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}