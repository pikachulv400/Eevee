package com.Eevee.net;

import java.util.ArrayList;

public class Room {
	private int CreatorID;
	private String CreatorIP;
	private int RoomNumber;
	private ArrayList<String> PeersIP;

	public Room(int CreatorID, String CreatorIP, int RoomNumber) {
		System.out.println("a new room #" + RoomNumber
				+ " has created with ID:" + CreatorID + "and IP:" + CreatorIP);
		PeersIP.add(CreatorIP);
	}
}
