package no.hvl.dat110.system.controller;

import no.hvl.dat110.rpc.RPCClient;
import no.hvl.dat110.rpc.RPCServerStopStub;

public class Controller {

	private static int N = 5;

	public static void main(String[] args) {

		Display display = new Display();
		Sensor sensor = new Sensor();
		RPCClient displayclient = new RPCClient(Common.DISPLAYHOST, Common.DISPLAYPORT);
		RPCClient sensorclient = new RPCClient(Common.SENSORHOST, Common.SENSORPORT);
		RPCServerStopStub stopdisplay = new RPCServerStopStub();
		RPCServerStopStub stopsensor = new RPCServerStopStub();

		System.out.println("Controller starting ...");

		displayclient.register(display);
		sensorclient.register(sensor);

		displayclient.register(stopdisplay);
		sensorclient.register(stopsensor);

		try {
			while (true) {
				int value = sensor.read();
				display.write(value+"°C");
				return;
			}
		} catch (Exception e) {
			System.out.println("Error occurred: " + e);
		}

		stopdisplay.stop();
		stopsensor.stop();

		displayclient.disconnect();
		sensorclient.disconnect();

		System.out.println("Controller stopping ...");

	}
}
