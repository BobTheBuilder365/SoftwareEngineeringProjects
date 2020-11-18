package topic_12_Networking.clientUndServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try (Socket socket = new Socket("127.0.0.1", 5004);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());

		) {
			out.write("Hello vom Client");
			out.flush();
			
			// Warten auf ANtwort vom Server
			String message = in.readLine();
			System.out.println("Server said: " + message);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
