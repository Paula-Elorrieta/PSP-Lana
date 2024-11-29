package Hilos.ejercicio_1.ejerc2.controller;

public class main {

	public static void main(String[] args) {

		HiloThread hilo1 = new HiloThread();
		HiloThread hilo2 = new HiloThread();

		hilo1.setName("Hilo1");
		hilo2.setName("Hilo2");

		hilo1.start();
		hilo2.start();
	}

}

class HiloThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 1; i++) {
			System.out.println(Thread.currentThread().getName() + " is alive: " + Thread.currentThread().isAlive());
		}
	}

}
