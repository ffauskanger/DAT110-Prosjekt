package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;

public class TemperatureDevice {
	
	private static final int COUNT = 10;
	
	public static void main(String[] args) {
		
		TemperatureSensor sn = new TemperatureSensor();
		
		// TODO - start
			
		Client client = new Client("temperatureDevice", Common.BROKERHOST, Common.BROKERPORT);
		String temp = "";
		client.connect();
		
		for(int i = 0; i < COUNT; i++)
		{
			temp = Integer.toString(sn.read());
			client.publish(Common.TEMPTOPIC, temp);
			
			// Sleeper for å gi den tid til å publishe
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		client.disconnect();
		
		// TODO - end
		
		System.out.println("Temperature device stopping ... ");
		
		//throw new RuntimeException("not yet implemented");
		
	}
}
