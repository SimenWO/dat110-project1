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

		int length = received[0];
		byte[] decoded = new byte[length];

		for (int i = 0; i < length; i++) {
			decoded[i] = received[i + 1];
		}

		this.payload = decoded;
		
	}
}
