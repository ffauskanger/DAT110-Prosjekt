package no.hvl.dat110.messaging;

import java.util.Arrays;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		
		if(payload.length > MessageConfig.SEGMENTSIZE)		
		{
			payload = Arrays.copyOf(payload, MessageConfig.SEGMENTSIZE);
		}
		
		this.payload = payload;

	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

	public byte[] encapsulate() {
		
		byte[] encoded;

		encoded = new byte[MessageConfig.SEGMENTSIZE];
		encoded[0] = (byte)(payload.length);
		
		for(int i = 1; i < payload.length+1; i++)
		{
			encoded[i] = this.payload[i-1];
		}
		
		return encoded;
		
	}

	public void decapsulate(byte[] received) {

		int size = received[0];		
		byte[] data = new byte[size];
		for(int i = 0; i < size; i++)
		{
			data[i] = received[i+1];
		}

		
		this.payload = data;
		
	
	}
}
