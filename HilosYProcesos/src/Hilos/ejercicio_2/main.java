package Hilos.ejercicio_2;

public class main {

	public static void main(String[] args) {
		
		Escritora escritora1 = new Escritora(true);
		Escritora escritora2 = new Escritora(false);

		escritora1.start();
		escritora2.start();

		

	}

}

class Escritora extends Thread {
	
	private boolean escribiendo;
	
	Escritora(boolean escribiendo) {
		this.escribiendo = escribiendo;
	}
	
	public void run() {
		if (escribiendo) {
			escribir();
		}else {
			leer();
		}
	}
	
	public void escribir() {
		for (char letra = 'a'; letra <= 'z'; letra++) {
            System.out.print(letra);
		}
	}
	
	public void leer() {
		for (int i = 0; i < 30; i++) {
			System.out.print(i);
		}
	}
	
}


