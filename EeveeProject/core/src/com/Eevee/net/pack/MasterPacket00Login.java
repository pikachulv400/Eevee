package com.Eevee.net.pack;


public class MasterPacket00Login extends MasterPacket {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8391066221503266355L;
	private String username;


    public MasterPacket00Login(String username) {
        super(MasterPacket.PacketTypes.LOGIN);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


}
