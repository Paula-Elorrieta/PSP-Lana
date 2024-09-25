package Hilos.ejercicio_6;

public class Buffer {
	private char contenido;
	private boolean bufferLleno = false;

	// Synchronized, lo que significa que solo un hilo a la vez puede acceder a esta función.
	public synchronized void poner(char c) {
		while (bufferLleno) {
			try {
				wait(); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contenido = c;
		bufferLleno = true;
		System.out.println("Productor puso: " + c);
		// Notifica a todos los hilos que están esperando en este objeto, en caso de que haya algún hilo esperando
		notifyAll(); 
	}

	// Para evitar que un hilo consuma un valor que aún no ha sido producido, se usa un while loop
	public synchronized char recoger() {
		while (!bufferLleno) {
			try {
				wait(); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		bufferLleno = false;
		notifyAll(); 
		System.out.println("Consumidor recogió: " + contenido);
		return contenido;
	}
}
