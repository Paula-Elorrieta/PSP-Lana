package Hilos.ejercicio_7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewCaballos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JProgressBar progressBar1;
	public JProgressBar progressBar2;
	public JProgressBar progressBar3;
	public JProgressBar progressBar4;
	public JLabel lblGanador;
	public JButton btnEmpezarCarrera;
	private boolean ganador = false; 

	public ViewCaballos(int prioridad1, int prioridad2, int prioridad3, int prioridad4) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCaballo1 = new JLabel("Caballo 1");
		lblCaballo1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCaballo1.setBounds(10, 34, 117, 19);
		contentPane.add(lblCaballo1);

		JLabel lblCaballo2 = new JLabel("Caballo 2");
		lblCaballo2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCaballo2.setBounds(10, 86, 117, 19);
		contentPane.add(lblCaballo2);

		JLabel lblCaballo3 = new JLabel("Caballo 3");
		lblCaballo3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCaballo3.setBounds(10, 144, 117, 19);
		contentPane.add(lblCaballo3);

		JLabel lblCaballo4 = new JLabel("Caballo 4");
		lblCaballo4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCaballo4.setBounds(10, 202, 117, 19);
		contentPane.add(lblCaballo4);

		progressBar1 = new JProgressBar();
		progressBar1.setBounds(85, 25, 426, 41);
		contentPane.add(progressBar1);

		progressBar2 = new JProgressBar();
		progressBar2.setForeground(new Color(255, 255, 0));
		progressBar2.setBounds(85, 77, 426, 41);
		contentPane.add(progressBar2);

		progressBar3 = new JProgressBar();
		progressBar3.setForeground(new Color(255, 128, 255));
		progressBar3.setBounds(85, 136, 426, 41);
		contentPane.add(progressBar3);

		progressBar4 = new JProgressBar();
		progressBar4.setForeground(new Color(128, 0, 255));
		progressBar4.setBounds(85, 194, 426, 41);
		contentPane.add(progressBar4);

		lblGanador = new JLabel("Ganador:");
		lblGanador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGanador.setBounds(323, 246, 201, 19);
		contentPane.add(lblGanador);

		btnEmpezarCarrera = new JButton("Empezar Carrera");
		btnEmpezarCarrera.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < 4; i++) {
					switch (i) {
					case 0:
						progressBar1.setValue(0);
						break;
					case 1:
						progressBar2.setValue(0);
						break;
					case 2:
						progressBar3.setValue(0);
						break;
					case 3:
						progressBar4.setValue(0);
						break;
					}
				}

				HiloCaballo caballo1 = new HiloCaballo(progressBar1, "Caballo 1", prioridad1, ViewCaballos.this);
				HiloCaballo caballo2 = new HiloCaballo(progressBar2, "Caballo 2", prioridad2, ViewCaballos.this);
				HiloCaballo caballo3 = new HiloCaballo(progressBar3, "Caballo 3", prioridad3, ViewCaballos.this);
				HiloCaballo caballo4 = new HiloCaballo(progressBar4, "Caballo 4", prioridad4, ViewCaballos.this);

				caballo1.start();
				caballo2.start();
				caballo3.start();
				caballo4.start();
				
				btnEmpezarCarrera.setEnabled(false);
			}
		});
		btnEmpezarCarrera.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEmpezarCarrera.setBounds(10, 287, 156, 47);
		contentPane.add(btnEmpezarCarrera);
	}

	public synchronized void marcarGanador(String caballo) {
		if (!ganador) {
			lblGanador.setText("Ganador: " + caballo);
			ganador = true; 
		}
	}
}
