package ariketa1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Zerbitzaria {
	public static final int PORT = 9999;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socketBezeroa = null;

		try {
			// 9999 portua jarriko dugu martxan
			serverSocket = new ServerSocket(PORT);
			System.out.println("Zerbitzaria martxan...");

			for (int i = 0; i <= 3; i++) {
				socketBezeroa = serverSocket.accept();
				System.out.println("Recibido ------------");

				// Leer datos del cliente
				DataInputStream entrada;
				entrada = new DataInputStream(socketBezeroa.getInputStream());
				System.out.println(entrada.readUTF());

				// Mandarle datos al cliente
				DataOutputStream salida;
				salida = new DataOutputStream(socketBezeroa.getOutputStream());
				salida.writeUTF("“saludos desde el servidor al cliente num: " + i);

				// Cerrar el socket
				socketBezeroa.close();
				salida.close();
				entrada.close();

			}

			System.out.println("Demasiadas conexiones. Cerrando el servidor.");
			serverSocket.close();

		} catch (IOException e) {
			System.err.println("Errorea zerbitzaria martxean jartzean.");
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					System.err.println("Errorea zerbitzaria ixtean.");
				}
			}
		}
	}

}
