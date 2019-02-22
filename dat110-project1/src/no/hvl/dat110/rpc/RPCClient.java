package no.hvl.dat110.rpc;

import java.rmi.Remote;

import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void register(RPCStub remote) {
		remote.register(this);
	}
	
	public void connect() {
		
		// TODO: connect using the underlying messaging layer connection
		connection = msgclient.connect();
		
	}
	
	public void disconnect() {
		
		// TODO: disconnect/close the underlying messaging connection
		
		connection.close();	
		
	}
	
	public byte[] call(byte[] rpcrequest) {
		
		byte[] rpcreply;
		
		/* TODO: 
		
		Make a remote call on the RPC server by sending a request message
		and receive a reply message
		
		rpcrequest is the marshalled rpcrequest from the client-stub
		rpctreply is the rpcreply to be unmarshalled by the client-stub
		
		*/
		
		// Send
		Message sMessage = new Message(rpcrequest);
		connection.send(sMessage);
		
		// Receive
		Message rMessage = connection.receive();
		rpcreply = rMessage.getData();
		
		return rpcreply;
		
	}

}
