package com.Eevee.net.pack;

public class MasterPacketACKLogin extends MasterPacket {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6468280202691788036L;
	private String username;


    public MasterPacketACKLogin(String username) {
        super(MasterPacket.PacketTypes.ACKLOGIN);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


}
