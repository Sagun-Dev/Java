package lab4.Q2;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",9000);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF("Hello Server");
		dos.flush();
		socket.close();
	}

}
