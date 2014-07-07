package com.Eevee.net.Master;

/*  The java.net package contains the basics needed for network operations. */
import java.net.*;
/* The java.io package contains the basics needed for IO operations. */
import java.io.*;

import com.Eevee.net.pack.MasterPacket;
import com.Eevee.net.pack.MasterPacketACKLogin;
import com.Eevee.net.pack.MasterPacketLogin;

/**
 * The SocketClient class is a simple example of a TCP/IP Socket Client.
 * 
 */

public class MasterClient {
	
	public static void main(String[] args) {
		/** Define a host server */
		String host = "localhost";
		/** Define a port */
		int port = 19999;

		StringBuffer instr = new StringBuffer();
		String TimeStamp;
		System.out.println("SocketClient initialized");

		try {
				/** Obtain an address object of the server */
				InetAddress address = InetAddress.getByName(host);
				/** Establish a socket connetion */
				Socket connection = new Socket(address, port);
				/** Instantiate a BufferedOutputStream object */
				ObjectOutputStream oos = new ObjectOutputStream(connection.getOutputStream());

				/**
				 * Instantiate a BufferedInputStream object for reading /**
				 * Instantiate a BufferedInputStream object for reading incoming
				 * socket streams.
				 */
				oos.writeObject(new MasterPacketLogin("Kevin"));
				ObjectInputStream ois = new ObjectInputStream(connection.getInputStream());
				parsePacket(ois.readObject());
				/**
				 * Instantiate an InputStreamReader with the optional character
				 * encoding.
				 */
				connection.close();
			
			/** Close the socket connection. */

		} catch (IOException f) {
			System.out.println("IOException: " + f);
		} catch (Exception g) {
			System.out.println("Exception: " + g);
		}

	}
	public static void parsePacket(Object packetReceived) {
		if (packetReceived instanceof MasterPacket) {
			switch (((MasterPacket) packetReceived).packetType) {
			case ACKLOGIN:
				System.out.println("Welcome"
						+ ((MasterPacketACKLogin) packetReceived).getUsername());
				break;
			}
		}
	}

}