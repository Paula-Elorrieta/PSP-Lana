package ariketa1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Bezeroa {

	public static void main(String[] args) {
		Socket miCliente;

		try {
			miCliente = new Socket("localhost", Zerbitzaria.PORT);
			System.out.println("Konexia eginda.");

			// Salida es el flujo de datos que envio al servidor
			DataOutputStream salida;
			salida = new DataOutputStream(miCliente.getOutputStream());
			salida.writeUTF("Hola servidor, soy un cliente");

			// Entrada es el flujo de datos que recibo del servidor
			DataInputStream entrada;
			entrada = new DataInputStream(miCliente.getInputStream());
			System.out.println(entrada.readUTF());

			// Cierro el socket
			miCliente.close();
		} catch (IOException e) {
			System.err.println("Errorea bezeroa martxean jartzean.");
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Errorea zerbitzariarekin komunikatzean.");
			e.printStackTrace();
		}

	}

}
