package Hilos.ejercicio_5;

import java.awt.EventQueue;

import javax.swing.JLabel;

public class main {

	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View frame = new View();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
     

	}

}

class HiloContador extends Thread {
    private volatile boolean running = true; 
    private int contador = 0;
    private JLabel lblContador;
    private JLabel lblPrioridad;

    public HiloContador(JLabel lblContador, JLabel lblPrioridad) {
        this.lblContador = lblContador;
        this.lblPrioridad = lblPrioridad;
    }

    @Override
    public void run() {
        while (running) {
            try {
                contador++;
                lblContador.setText("Contador: " + contador);
                lblPrioridad.setText("Prioridad: " + this.getPriority());
                
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void detenerHilo() {
        running = false;
    }
}
