package Hilos.ejercicio_1.ejerc3.controller;

public class main {

	public static void main(String[] args) {

		HiloThread hilo1 = new HiloThread();
		HiloThread hilo2 = new HiloThread();

		hilo1.setName("Persona 1");
		hilo2.setName("Persona 2");

		hilo1.start();
		hilo2.start();
	}

}

class HiloThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread().getName() + " numero de operaciones: " + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
