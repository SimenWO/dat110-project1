package no.hvl.dat110.system.display;

import no.hvl.dat110.rpc.RPCImpl;
import no.hvl.dat110.rpc.RPCUtils;

public class DisplayImpl implements RPCImpl {

	public void write(String message) {
		System.out.println("DISPLAY:" + message);
	}
	
	public byte[] invoke(byte[] request) {

		String m = RPCUtils.unmarshallString(request);
		write(m);

		byte rpcid = request[0];
		byte[] reply = RPCUtils.marshallString(rpcid, m);

		return reply;
	}
}
