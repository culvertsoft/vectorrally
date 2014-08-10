package se.culvertsoft.vectorrally.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import se.culvertsoft.mgen.javapack.serialization.JsonReader;
import se.culvertsoft.vectorrally.model.ClassRegistry;
import se.culvertsoft.vectorrally.model.wish.Wish;

public class Receiver extends Thread {

	private Socket socket = null;
	private ConcurrentLinkedQueue<Wish> receviedWishes = null;
	private DataInputStream streamIn = null;
	private boolean stop = false;

	public Receiver(ConcurrentLinkedQueue<Wish> receviedWishes, Socket socket) {
		this.receviedWishes = receviedWishes;
		this.socket = socket;
		open();
		start();
	}

	public void open() {
		try {
			streamIn = new DataInputStream(socket.getInputStream());
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
				ClassRegistry cr = new ClassRegistry();
				JsonReader jr = new JsonReader(streamIn, cr);
				// read data and put in received wishes.
				receviedWishes.add(jr.readObject(Wish.class));
			} catch (IOException ioe) {
				System.out.println("Listening error: " + ioe.getMessage());
			}
		}
	}
}
