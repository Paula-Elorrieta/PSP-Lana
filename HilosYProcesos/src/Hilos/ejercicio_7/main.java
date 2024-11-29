package Hilos.ejercicio_7;

import javax.swing.JProgressBar;

public class main {

	public static void main(String[] args) {
		ViewPrioridades viewPrioridades = new ViewPrioridades();
		viewPrioridades.setVisible(true);

	}
}

class HiloCaballo extends Thread {
    private JProgressBar progressBar;
    private String caballo;
    public boolean corriendo;
    private ViewCaballos view; 

    public HiloCaballo(JProgressBar progressBar, String caballo, int prioridad, ViewCaballos view) {
        this.progressBar = progressBar;
        this.caballo = caballo;
        this.corriendo = true;
        this.view = view; 
        setPriority(prioridad);
    }

    @Override
    public void run() {
        while (corriendo) {
            try {
                int progreso = progressBar.getValue() + (int) (Math.random() * 10);

                // Si el caballo llega al 100% del prpgressbar termina la carrera
                if (progreso >= 100) {
                    progreso = 100;
                    progressBar.setValue(progreso);
                    terminar();
                    // En cuanto llegue se ejecuta el método marcarGanador de la vista para mostrar el mensaje de quien gano
                    view.marcarGanador(caballo); 
                    break; 
                }

                progressBar.setValue(progreso);
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void terminar() {
        if (corriendo) {
            corriendo = false;
        }
    }
}
