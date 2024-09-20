package ejercicio_4;

public class main {

	public static void main(String[] args) throws InterruptedException {

		DetonadorConRetardo detonador1 = new DetonadorConRetardo("Detonador 1", 10);
		DetonadorConRetardo detonador2 = new DetonadorConRetardo("Detonador 2", 10);
		DetonadorConRetardo detonador3 = new DetonadorConRetardo("Detonador 3", 10);
		DetonadorConRetardo detonador4 = new DetonadorConRetardo("Detonador 4", 10);

		Thread hilo1 = new Thread(detonador1);
		Thread hilo2 = new Thread(detonador2);
		Thread hilo3 = new Thread(detonador3);
		Thread hilo4 = new Thread(detonador4);

		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		
		if (hilo1.isAlive()) {
			hilo1.join();
			System.out.println("Hilo 1 terminado");
		}
		
		if (hilo2.isAlive()) {
			hilo2.join();
			System.out.println("Hilo 2 terminado");
		}
		
		if (hilo3.isAlive()) {
			hilo3.join();
			System.out.println("Hilo 3 terminado");
		}
		
		if (hilo4.isAlive()) {
			hilo4.join();
			System.out.println("Hilo 4 terminado");
		}
		
	}

}

class DetonadorConRetardo implements Runnable {

	private String nombre;
	private int contador;

	public DetonadorConRetardo(String nombre, int contador) {
		this.nombre = nombre;
		this.contador = contador;
	}

	@Override
	public void run() {

		while (contador > 0) {
			System.out.println(nombre + " " + contador);
			contador--;
		}

		System.out.println(nombre + " Kabum!");

	}

}