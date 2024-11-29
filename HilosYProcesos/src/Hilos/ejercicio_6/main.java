package Hilos.ejercicio_6;

public class main {

	public static void main(String[] args) {
		Buffer buffer = new Buffer(); 

		Productor productor = new Productor(buffer); 
		Consumidor consumidor = new Consumidor(buffer); 

		productor.start();
		consumidor.start();

		try {
			productor.join(); 
			consumidor.join(); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Cuando hayan terminado los dos hilos, se imprime un mensaje
		System.out.println("Ejecución completada.");
	}

}
