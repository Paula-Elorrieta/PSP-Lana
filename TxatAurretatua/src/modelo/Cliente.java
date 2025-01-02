package modelo;

import java.io.*;
import java.net.*;
import javax.swing.*;

import vista.*;

public class Cliente {
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private String alias;

	public void conectar(String host, int port, String alias) {
		this.alias = alias;
		try {
			socket = new Socket(host, port);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			out.println(alias);

			String respuesta = in.readLine();
			if ("Konektatuta".equals(respuesta)) {
				SwingUtilities.invokeLater(() -> new ClienteVista(this));
			} else {
				JOptionPane.showMessageDialog(null, "El servidor rechazó la conexión", "Error",
						JOptionPane.ERROR_MESSAGE);
				desconectar();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al conectar con el servidor: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			desconectar();
		}
	}

	public void enviarMensaje(String mensaje) {
		if (out != null) {
			out.println(alias + "> " + mensaje);
		}
	}

	public void desconectar() {
		try {
			if (out != null) {
				out.println(alias + " se ha desconectado");
			}
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
			System.err.println("Error al cerrar el cliente: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new AliasVista());
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
}