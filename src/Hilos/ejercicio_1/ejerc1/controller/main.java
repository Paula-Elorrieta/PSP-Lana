package Hilos.ejerc1.controller;

public class main {

	public static void main(String[] args) {
		
		Thread hilo1 = new Thread(new HiloRunnable());
		Thread hilo2 = new Thread(new HiloRunnable());
		
		hilo1.setName("Hilo1");
		hilo2.setName("Hilo2");
		
		hilo1.start();
		hilo2.start();
		

	}

}

class HiloRunnable implements Runnable {

	public void run() {
		
		for (int i = 0; i < 1; i++) {
			System.out.println(Thread.currentThread().getName() +  " is alive: " + Thread.currentThread().isAlive());
		}
		
	}

}
