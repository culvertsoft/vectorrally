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
	private JsonWriter jw;

	public Sender(ConcurrentLinkedQueue<Wish> sendWishes, Socket socket) {
		this.sendWishes = sendWishes;
		try {
			streamOut = new DataOutputStream(socket.getOutputStream());
			ClassRegistry cr = new ClassRegistry();
			jw = new JsonWriter(streamOut, cr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Establishing connection. Please wait ...");

	}

	public void run() {
		while (!stop) {
			if(sendWishes.size() > 0){
				try {
					jw.writeObject(sendWishes.poll());
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
