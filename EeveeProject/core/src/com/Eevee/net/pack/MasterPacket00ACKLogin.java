package com.Eevee.net.pack;

import com.Eevee.net.Master.MasterClient;
import com.Eevee.net.Master.MasterServer;


public class MasterPacket00ACKLogin extends MasterPacket {

    private String username;


    public MasterPacket00ACKLogin(String username) {
        super(MasterPacket.PacketTypes.ACKLOGIN);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


}
