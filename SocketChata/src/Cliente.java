import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {
	public static void main(String[] args) {
		try (Socket socket = new Socket("localhost", Servidor.PORT)) {

			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			Thread entzutea = new Thread(new KonexioHaria(socket, entrada, salida, "Bezeroa"));
			entzutea.start();
			BufferedReader consola = new BufferedReader(new InputStreamReader(System.in));

			String mensaje;
			while ((mensaje = consola.readLine()) != null) {
				if ("atera".equalsIgnoreCase(mensaje.trim())) {
					salida.println("atera");
					System.out.println("Konexioa amaituta.");
					break;
				}
				salida.println(mensaje);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}