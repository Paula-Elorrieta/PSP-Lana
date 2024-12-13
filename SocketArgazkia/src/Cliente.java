import java.awt.EventQueue;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static String rutaImagen;

	public static void main(String[] args) {

		Socket miCliente;

		try {
			miCliente = new Socket("localhost", Servidor.PORT);

			DataInputStream entrada = new DataInputStream(miCliente.getInputStream());

			if (entrada != null) {
				System.out.println("Recibiendo imagen...");
				File copia = new File("copia.jpg");
				FileOutputStream fileOS = new FileOutputStream(copia);

				byte[] buffer = new byte[4096];
				int leido;

				while ((leido = entrada.read(buffer)) != -1) {
					fileOS.write(buffer, 0, leido);
				}

				rutaImagen = "copia.jpg";

				fileOS.close();
				entrada.close();
				miCliente.close();

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			rutaImagen = "src/no_disponible.jpg";
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteVista frame = new ClienteVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
