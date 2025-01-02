package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

import vista.ServidorVista;

public class Servidor {
	private ServerSocket serverSocket;
	public static final int port = 3333;
	private ServidorVista servidorVista;

	public Servidor() {
		servidorVista = new ServidorVista(this);
	}

	public ServidorVista getServidorVista() {
		return servidorVista;
	}

	public void zerbitzariaPiztu() {
		try {
			serverSocket = new ServerSocket(port);
			servidorVista.textuErakutsi("Esperando conexiones...");

			while (true) {
				Socket clientSocket = serverSocket.accept();
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String alias = in.readLine();

				if (alias != null && !alias.isEmpty()) {
					PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
					servidorVista.bezeroGehitu(alias);
					servidorVista.textuErakutsi(alias + " ha entrado al chat.");

					out.println("Konektatuta");

					new Thread(new HariHartzailea(clientSocket, alias, this)).start();
				}
			}
		} catch (IOException e) {
			zerbitzariaItzali();
		}

	}

	public void bezeroaKendu(String alias) {
		servidorVista.bezeroEzabatu(alias);
	}

	public void zerbitzariaItzali() {
		try {
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
				servidorVista.textuErakutsi("Servidor detenido.");
				System.exit(0);

			}
		} catch (IOException e) {
			servidorVista.textuErakutsi("Error al cerrar el servidor: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		servidor.zerbitzariaPiztu();
	}
}