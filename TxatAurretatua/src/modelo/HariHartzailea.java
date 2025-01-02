package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HariHartzailea implements Runnable {

	private final Socket clientSocket;
	private final Servidor servidor;
	private final String alias;
	private final BufferedReader in;

	public HariHartzailea(Socket clientSocket, String alias, Servidor servidor) throws IOException {
		this.clientSocket = clientSocket;
		this.alias = alias;
		this.servidor = servidor;
		this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	}

	@Override
	public void run() {
		try {
			String mensaje;
			while ((mensaje = in.readLine()) != null) {

				servidor.getServidorVista().textuErakutsi(mensaje);
			}
		} catch (IOException e) {
			servidor.getServidorVista().textuErakutsi("Error en la comunicación con " + alias + ": " + e.getMessage());
		}

		if (!clientSocket.isClosed()) {
			try {
				clientSocket.close();
				servidor.getServidorVista().bezeroEzabatu(alias);
			} catch (IOException e) {
				servidor.getServidorVista()
						.textuErakutsi("Error al cerrar el socket de " + alias + ": " + e.getMessage());
			}
		}
	}

}
