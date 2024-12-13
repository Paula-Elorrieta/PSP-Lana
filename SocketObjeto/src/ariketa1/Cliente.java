package ariketa1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class Cliente {

	public static void main(String[] args) throws ClassNotFoundException {
		Socket miCliente;

		try {
			miCliente = new Socket("localhost", Servidor.PORT);
			ObjectInputStream entrada;

			entrada = new ObjectInputStream(miCliente.getInputStream());
			Persona p = (Persona) entrada.readObject();
			Date fecha = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);

			p.setNombre("Carmen");
			p.setFechaNaciniento(fecha);

			ObjectOutputStream salida;
			salida = new ObjectOutputStream(miCliente.getOutputStream());
			salida.writeObject(p);

			entrada.close();
			salida.close();
			miCliente.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
