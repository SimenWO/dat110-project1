package no.hvl.dat110.messaging;

import java.util.Arrays;

import static no.hvl.dat110.messaging.MessageConfig.SEGMENTSIZE;

public class Message {

	private byte[] payload;

	// check for length within boundary
	public Message(byte[] payload) {
		if(payload.length<SEGMENTSIZE){
			this.payload = payload;
		} else {
			System.out.println("The messeage is to long");
		}

	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload; 
	}

		public byte[] encapsulate() {

			byte[] encoded = new byte[MessageConfig.SEGMENTSIZE];

			encoded[0] = (byte) this.payload.length;

			for (int i = 0; i < this.payload.length; i++) {
				encoded[i + 1] = this.payload[i];
			}

			return encoded;
		
	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate data in received and put in payload
		
	   throw new RuntimeException("not yet implemented");
		
	}
}
