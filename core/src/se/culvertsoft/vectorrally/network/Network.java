package se.culvertsoft.vectorrally.network;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import se.culvertsoft.vectorrally.model.wish.Wish;

public class Network {
	private static Receiver receiver;
	private static ConcurrentLinkedQueue<Wish> sendWishes;
	private static ConcurrentLinkedQueue<Wish> receivedWishes;
	private static Sender sender;

	public static void initialize(String serverName, int serverPort) {
		try {
			Socket socket = new Socket(serverName, serverPort);
			System.out.println("Connected: " + socket);
			receiver = new Receiver(receivedWishes, socket);
			sender = new Sender(sendWishes, socket);
			receiver.start();
			sender.start();
		} catch (IOException uhe) {
			System.out.println("Error: " + uhe.getMessage());
		}
	}

	public static void sendWish(Wish w) {
		Network.sendWishes.add(w);
	}
	
	public static boolean hasWishes(){
		return !receivedWishes.isEmpty();
	}

	public static Wish getWish() {
		return receivedWishes.poll();
	}

	public static void destroy() {
		Network.receiver.kill();
		Network.sender.kill();
	}
}
