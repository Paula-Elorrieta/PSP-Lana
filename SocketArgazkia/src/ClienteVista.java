import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.Icon;

public class ClienteVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ClienteVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelImagen = new JPanel();
		panelImagen.setBackground(new Color(128, 0, 255));
		panelImagen.setBounds(116, 72, 508, 305);
		contentPane.add(panelImagen);
		
		ImageIcon imagen = new ImageIcon(Cliente.rutaImagen);
		panelImagen.add(new JLabel(imagen));
		
		
		
	}
}
