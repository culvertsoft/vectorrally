package se.culvertsoft.vectorrally.network;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import se.culvertsoft.vectorrally.model.wish.Wish;

public class Receiver extends Thread {

	private Socket socket = null;
	private ConcurrentLinkedQueue<Wish> recevied_wishes = null;
	private DataInputStream streamIn = null;

	public Receiver(ConcurrentLinkedQueue<Wish> recevied_wishes, Socket socket) {
		this.recevied_wishes = recevied_wishes;
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

	public void close() {
		try {
			if (streamIn != null)
				streamIn.close();
		} catch (IOException ioe) {
			System.out.println("Error closing input stream: " + ioe);
		}
	}

	public void run() {
		while (true) {
			try {
				//read data and put in received wishes.
				streamIn.read();
			} catch (IOException ioe) {
				System.out.println("Listening error: " + ioe.getMessage());
			}
		}
	}
}
