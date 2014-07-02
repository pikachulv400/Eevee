package com.Eevee.net.pack;

import com.Eevee.net.Master.MasterClient;
import com.Eevee.net.Master.MasterServer;


public class MasterPacket00Login extends MasterPacket {

    private String username;


    public MasterPacket00Login(String username) {
        super(MasterPacket.PacketTypes.LOGIN);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


}
