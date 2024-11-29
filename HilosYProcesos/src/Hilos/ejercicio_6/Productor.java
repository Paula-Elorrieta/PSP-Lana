package Hilos.ejercicio_6;

import java.util.Random;

public class Productor extends Thread {
	private Buffer buffer;
	private Random random = new Random();

	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			char letra = (char) (random.nextInt(26) + 'A'); 
			buffer.poner(letra); 
			try {
				Thread.sleep(500); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
