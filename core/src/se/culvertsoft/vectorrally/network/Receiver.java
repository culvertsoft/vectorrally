package se.culvertsoft.vectorrally.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import se.culvertsoft.mgen.javapack.serialization.JsonReader;
import se.culvertsoft.vectorrally.model.ClassRegistry;
import se.culvertsoft.vectorrally.model.wish.Wish;

public class Receiver extends Thread {

	private ConcurrentLinkedQueue<Wish> receviedWishes = null;
	private volatile boolean stop = false;
	private JsonReader jr;
	private DataInputStream streamIn;

	public Receiver(ConcurrentLinkedQueue<Wish> receviedWishes, Socket socket) {
		this.receviedWishes = receviedWishes;
		try {
			streamIn = new DataInputStream(socket.getInputStream());
			ClassRegistry cr = new ClassRegistry();
			jr = new JsonReader(streamIn, cr);
		} catch (IOException ioe) {
			System.out.println("Error getting input stream: " + ioe);
		}
	}

	public void kill() {
		this.stop = true;
	}

	public void run() {
		if (stop) {
			try {
				streamIn.close();
			} catch (IOException e) {
				System.out.println("closing error: " + e.getMessage());
			}
		}
		while (!stop) {
			try {
				receviedWishes.add(jr.readObject(Wish.class));
			} catch (IOException ioe) {
				System.out.println("Listening error: " + ioe.getMessage());
			}
		}
	}
}
