package Hilos.ejercicio_7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewPrioridades extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textPrioridad1;
	private JTextField textPrioridad2;
	private JTextField textPrioridad3;
	private JTextField textPrioridad4;

	public ViewPrioridades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPrioridad1 = new JLabel("Caballo 1:");
		lblPrioridad1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrioridad1.setBounds(10, 11, 108, 28);
		contentPane.add(lblPrioridad1);

		JLabel lblPrioridad2 = new JLabel("Caballo 2:");
		lblPrioridad2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrioridad2.setBounds(10, 54, 108, 28);
		contentPane.add(lblPrioridad2);

		JLabel lblPrioridad3 = new JLabel("Caballo 3:");
		lblPrioridad3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrioridad3.setBounds(10, 93, 108, 28);
		contentPane.add(lblPrioridad3);

		JLabel lblPrioridad4 = new JLabel("Caballo 4:");
		lblPrioridad4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrioridad4.setBounds(10, 132, 108, 28);
		contentPane.add(lblPrioridad4);

		textPrioridad1 = new JTextField();
		textPrioridad1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPrioridad1.setBounds(85, 13, 151, 26);
		contentPane.add(textPrioridad1);
		textPrioridad1.setColumns(10);

		textPrioridad2 = new JTextField();
		textPrioridad2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPrioridad2.setColumns(10);
		textPrioridad2.setBounds(85, 60, 151, 26);
		contentPane.add(textPrioridad2);

		textPrioridad3 = new JTextField();
		textPrioridad3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPrioridad3.setColumns(10);
		textPrioridad3.setBounds(85, 99, 151, 26);
		contentPane.add(textPrioridad3);

		textPrioridad4 = new JTextField();
		textPrioridad4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPrioridad4.setColumns(10);
		textPrioridad4.setBounds(85, 138, 151, 26);
		contentPane.add(textPrioridad4);

		textPrioridad1.setText("6");
		textPrioridad2.setText("6");
		textPrioridad3.setText("6");
		textPrioridad4.setText("6");

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (textPrioridad1.getText().isEmpty() || textPrioridad2.getText().isEmpty()
							|| textPrioridad3.getText().isEmpty() || textPrioridad4.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Las prioridades no pueden estar vacías", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					int prioridad1 = Integer.parseInt(textPrioridad1.getText());
					int prioridad2 = Integer.parseInt(textPrioridad2.getText());
					int prioridad3 = Integer.parseInt(textPrioridad3.getText());
					int prioridad4 = Integer.parseInt(textPrioridad4.getText());

					if (prioridad1 < 1 || prioridad1 > 10 || prioridad2 < 1 || prioridad2 > 10 || prioridad3 < 1
							|| prioridad3 > 10 || prioridad4 < 1 || prioridad4 > 10) {
						JOptionPane.showMessageDialog(null, "Las prioridades deben estar entre 1 y 10", "Error",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					ViewCaballos viewCaballos = new ViewCaballos(prioridad1, prioridad2, prioridad3, prioridad4);
					viewCaballos.setVisible(true);
					dispose();

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Por favor ingresa solo números en las prioridades", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnGuardar.setBounds(264, 207, 132, 43);
		contentPane.add(btnGuardar);
	}
}
