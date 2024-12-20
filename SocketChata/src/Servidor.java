import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static int PORT = 3333;

	public static void main(String[] args) {
		try (ServerSocket servidor = new ServerSocket(PORT)) {
			System.out.println("Server hasieratuta...");
			Socket socket = servidor.accept();
			System.out.println("Bezero bat konektatu da.");
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);
			Thread escuchar = new Thread(new KonexioHaria(socket, entrada, salida, "Zerbitzaria"));
			escuchar.start();
			BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
			String mensaje;
			while ((mensaje = con.readLine()) != null) {
				if ("atera".equalsIgnoreCase(mensaje.trim())) {
					salida.println("atera");
					System.out.println("Konexioa amaituta.");
					break;
				}
				salida.println(mensaje);
			}
			socket.close();
		} catch (IOException e) {
			System.out.println("Server error: " + e.getMessage());
		}
	}

}