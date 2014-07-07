package com.Eevee.net.Master;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.Eevee.net.pack.MasterPacket;
import com.Eevee.net.pack.MasterPacketACKLogin;
import com.Eevee.net.pack.MasterPacketLogin;

public class ConnectionHandler implements Runnable {

	Socket connection;
	private int ID;
	private String TimeStamp;
	private MasterServer master;
	ObjectInputStream ois;
	ObjectOutputStream oos;

	public ConnectionHandler(Socket connection, int i, MasterServer master) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
		this.master = master;
		this.ID = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ois = new ObjectInputStream(connection.getInputStream());
			oos = new ObjectOutputStream(connection.getOutputStream());
			parsePacket(ois.readObject());

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();
			} catch (IOException e) {
			}
		}
	}

	public void parsePacket(Object packetReceived) {
		if (packetReceived instanceof MasterPacket) {
			switch (((MasterPacket) packetReceived).packetType) {
			case LOGIN:
				System.out.println("Player"
						+ ((MasterPacketLogin) packetReceived).getUsername()
						+ " Has joined the lobby");
				try {
					oos.writeObject(new MasterPacketACKLogin("Kevin"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

}
