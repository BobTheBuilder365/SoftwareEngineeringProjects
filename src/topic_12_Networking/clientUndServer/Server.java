package topic_12_Networking.clientUndServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	// Der Code innerhalb von main, wäre in der "run" Methode
	public static void main(String[] args) {

		while (true) {
			try (ServerSocket listener = new ServerSocket(5004, 10, null);) {
				try (Socket socket = listener.accept();
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());) {
					// Vom CLient Nachricht lesen
					String message = in.readLine();
					System.out.println(message);
					out.write("Hello from server\n");
					out.flush();
					System.out.println("Reply sent");

				} catch (Exception e) {
					System.out.println(e.toString());
				}

			} catch (Exception e) {
				System.out.println(e.toString());

			}

		}
	}
}
