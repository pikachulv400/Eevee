package com.Eevee.net.pack;

import java.io.Serializable;

import com.Eevee.net.GameClient;
import com.Eevee.net.GameServer;
import com.Eevee.net.Master.MasterClient;
import com.Eevee.net.Master.MasterServer;

public abstract class MasterPacket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5189779165581423724L;

	public MasterPacket(PacketTypes packetType) {
		// TODO Auto-generated constructor stub
		this.packetType = packetType;
	}

	public static enum PacketTypes {
		INVALID, LOGIN, ACKLOGIN, DISCONNECT, ACKDISCONNECT, 
		CREATEROOM, ACKCREATEROOM, JOINROOM, ACKJOINROOM, 
		EXITROOM, ACKEXITROOM, CLOSEROOM, ACKCLOSEROOM, STARTGAME, ACKSTARTGAME;
	}

	public PacketTypes packetType;

}
