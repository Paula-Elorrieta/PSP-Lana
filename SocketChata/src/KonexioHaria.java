
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class KonexioHaria implements Runnable {
	private BufferedReader entrada;
	private Socket socket;
	private boolean activo = true;
	private String izena;

	public KonexioHaria(Socket socket, BufferedReader entrada, PrintWriter salida, String izena) {
		this.socket = socket;
		this.entrada = entrada;
		this.izena = izena;
	}

	@Override
	public void run() {
		try {
			String mensaje;
			while (activo && (mensaje = entrada.readLine()) != null) {
				if ("atera".equalsIgnoreCase(mensaje.trim())) {
					activo = false;
					break;
				}
				System.out.println(izena + ": " + mensaje);
			}
		} catch (IOException e) {
			System.out.println("Errorea" + e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}