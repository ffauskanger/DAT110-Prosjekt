package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START
		
		Client client = new Client("displayDevice", Common.BROKERHOST, Common.BROKERPORT);
		client.connect();

		client.createTopic(Common.TEMPTOPIC);
		client.subscribe(Common.TEMPTOPIC);
		
		for(int i = 0; i < COUNT; i++)
		{
			client.receive();
		
			// Sleeper for å gi den tid til å recieve
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		client.disconnect();
				
		// TODO - END
		
		System.out.println("Display stopping ... ");
		
		//throw new RuntimeException("not yet implemented");
		
	}
}
