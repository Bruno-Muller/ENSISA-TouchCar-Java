package touchcar;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import car.can.CanMessage;

public class Client implements Runnable {

	public static final String DEFAULT_IP = "localhost";
	public static final int DEFAULT_PORT = 50885;
	private Controller controller;
	private Socket socket;
	private boolean terminating;

	public Client(Controller controller) throws UnknownHostException, IOException {

		File file = new File("config.txt");
		if (!file.exists()) {
			file.createNewFile();
			PrintStream printStream = new PrintStream(file);
			printStream.println(DEFAULT_IP);
			printStream.println(DEFAULT_PORT);
			printStream.close();
		}

		Scanner scanner = new Scanner(file);
		String ip = scanner.next();
		int port = scanner.nextInt();
		scanner.close();
		
		this.controller = controller;
		this.socket = new Socket(ip, port);
		this.terminating = false;
	}

	public void run() {
		try {
			byte bytes[] = new byte[6];
			while (this.socket.getInputStream().read(bytes,0,6) != -1) {
				this.controller.acceptCanMessage(new CanMessage(bytes));
			}

		} catch (IOException e) {
			if (!this.terminating)
				e.printStackTrace();
		}
	}

	public void close() throws IOException {
		this.socket.close();
	}

	public void sendCanMessage(CanMessage canMessage) {
		try {
			OutputStream outputStream = this.socket.getOutputStream();
			outputStream.write(canMessage.getBytes());
			outputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
