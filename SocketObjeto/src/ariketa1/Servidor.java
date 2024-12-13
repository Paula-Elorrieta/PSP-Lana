package ariketa1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Servidor {
	public static final int PORT = 9999;

	public static void main(String[] args) throws ClassNotFoundException {
		ServerSocket serverSocket = null;
		Socket socketBezeroa = null;
		Date fecha = new Date(System.currentTimeMillis());
		Persona p = new Persona("12345678A", "Pepito", "Grillo", fecha, 'M');

		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Zerbitzaria martxan...");

			socketBezeroa = serverSocket.accept();
			if (socketBezeroa != null) {
				System.out.println("Conexión recibida");
				System.out.println("Nombre antes de mandar:" + p.getNombre());
				System.out.println("Fecha antes de mandar:" + p.getFechaNaciniento());

				ObjectOutputStream salida;
				salida = new ObjectOutputStream(socketBezeroa.getOutputStream());
				salida.writeObject(p);

				ObjectInputStream entrada;
				entrada = new ObjectInputStream(socketBezeroa.getInputStream());
				p = (Persona) entrada.readObject();
				System.out.println("Nombre despues de mandar:" + p.getNombre());
				System.out.println("Fecha despues de mandar:" + p.getFechaNaciniento());

				salida.close();
				entrada.close();
				socketBezeroa.close();
				serverSocket.close();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
