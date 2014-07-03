package com.Eevee.net.Master;

import java.net.*;
import java.io.*;
import java.util.*;

import com.Eevee.net.pack.MasterPacket;

public class MasterServer{

	private Socket connection;
	private int ID;
	private ArrayList<Room> rooms = new ArrayList<Room>();

	public static void main(String[] args) {
		new MasterServer();
		
	}
	MasterServer(){
		int port = 19999;
		int count = 0;
		try {
			ServerSocket socket1 = new ServerSocket(port);
			System.out.println("MultipleSocketServer Initialized");
			while (true) {
				Socket connection = socket1.accept();
				Runnable runnable = new ConnectionHandler(connection,++count,this);
				Thread thread = new Thread(runnable);
				thread.start();
			}
		} catch (Exception e) {
		}
	}
	public void HandleCreate(int CreatorID,String CreatorIP,int RoomNumber){
		rooms.add(new Room(CreatorID,CreatorIP,RoomNumber));
	}
	public void BroadCastToAll(MasterPacket masterPacket)
	{
		//
	}
}
/*
 * 
 * public class MasterServer { ServerSocketHints serverconfig = new
 * ServerSocketHints(); ServerSocket server ; public MultipleSocketServer(){
 * serverconfig.performancePrefBandwidth = 1;
 * serverconfig.performancePrefLatency = 0;
 * serverconfig.performancePrefConnectionTime = 2; server =
 * Gdx.net.newServerSocket(Protocol.TCP,6789,serverconfig); }
 * 
 * }
 */
