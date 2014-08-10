package se.culvertsoft.vectorrally.network;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

import se.culvertsoft.mgen.javapack.serialization.JsonWriter;
import se.culvertsoft.vectorrally.model.ClassRegistry;
import se.culvertsoft.vectorrally.model.wish.Wish;

public class Sender extends Thread {
	private DataOutputStream streamOut = null;
	private Receiver receiver = null;
	private boolean stop = false;
	private ConcurrentLinkedQueue<Wish> sendWishes;

	public Sender(ConcurrentLinkedQueue<Wish> sendWishes, Socket socket) {
		this.sendWishes = sendWishes;
		try {
			streamOut = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Establishing connection. Please wait ...");

	}

	public void run() {
		while (!stop) {
			if(sendWishes.size() > 0){
				try {
					Wish w = sendWishes.poll();
					ClassRegistry cr = new ClassRegistry();
					JsonWriter jw = new JsonWriter(streamOut, cr);
					jw.writeObject(w);
				} catch (IOException ioe) {
					System.out.println("Sending error: " + ioe.getMessage());
				}
				
			} else {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void kill() {
		this.stop = true;
		this.receiver.kill();
	}
}
