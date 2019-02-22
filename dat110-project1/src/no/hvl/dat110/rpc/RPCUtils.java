package no.hvl.dat110.rpc;

import java.util.Arrays;

public class RPCUtils {

	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;
		
		byte[] byteStr = str.getBytes();
		int size = byteStr.length;
		encoded = new byte[size+1];
		encoded[0] = rpcid;
		
		for(int i = 0; i < size; i++)
		{
			encoded[i+1] = byteStr[i];
		}
		
		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		byte[] byteStr = new byte[data.length-1];
		
		// Ignorerer RPC identifier?
		for(int i = 1; i < data.length; i++)
		{
			byteStr[i-1] = data[i];
		}
	
		decoded = new String(byteStr);

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;

		// TODO: marshall RPC identifier in case of void type
		
		encoded = new byte[1];
		
		encoded[0] = rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
		
		// Skal det være noe her i hele tatt?
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded = new byte[5]; // int = 4 bytes + RPCID

		
		// TODO: marshall RPC identifier and string into byte array

		// Setting RPCID
		encoded[0] = rpcid;
		
		//Converting
		encoded[1] = (byte) ((x >> 24) & 0xFF);
		encoded[2] = (byte) ((x >> 16) & 0xFF);
		encoded[3] = (byte) ((x >> 8) & 0xFF);
		encoded[4] = (byte) (x & 0xFF);

		
		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded = 0;
		
		// Converting
		
		for(int i = 0; i < data.length-1; i++)
		{
			decoded = (decoded << 8) + (data[i+1] & 0xff);
		}

		return decoded;

	}
}
