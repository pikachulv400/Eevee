package com.Eevee.net.pack;

public class MasterPacket00ACKLogin extends MasterPacket {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6468280202691788036L;
	private String username;


    public MasterPacket00ACKLogin(String username) {
        super(MasterPacket.PacketTypes.ACKLOGIN);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


}
