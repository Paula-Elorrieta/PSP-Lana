import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static final int PORT = 9999;

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socketCliente = null;

		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("Zerbitzaria martxan...");

			socketCliente = serverSocket.accept();
			if (socketCliente != null) {
				DataOutputStream salida = new DataOutputStream(socketCliente.getOutputStream());
				String rutaImagen = "src/imagen.jpg";
				BufferedInputStream imagenBufferet = new BufferedInputStream(new FileInputStream(rutaImagen));
				byte[] buffer = new byte[4096];
				int leido;

				while ((leido = imagenBufferet.read(buffer)) != -1) {
					salida.write(buffer, 0, leido);
				}
				
				imagenBufferet.close();
				salida.close();
				socketCliente.close();
				serverSocket.close();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
