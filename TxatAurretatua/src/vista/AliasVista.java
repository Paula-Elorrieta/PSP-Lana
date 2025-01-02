package vista;

import java.awt.Color;
import java.awt.Font;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import modelo.Cliente;
import modelo.Servidor;

public class AliasVista extends JFrame {
	private static final long serialVersionUID = 1L;
	private HashSet<String> aliasSet;

	public AliasVista() {
		setTitle("Introduce tu Alias");
		setSize(430, 294);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JLabel lblNicknameSartu = new JLabel("nickname sartu:");
		lblNicknameSartu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNicknameSartu.setBounds(10, 31, 211, 31);
		JTextField aliasField = new JTextField();
		aliasField.setBounds(10, 73, 263, 31);
		JLabel errorLabel = new JLabel("", JLabel.CENTER);
		errorLabel.setBounds(56, 115, 311, 31);
		errorLabel.setForeground(Color.RED);

		aliasSet = new HashSet<>();
		System.out.println(aliasSet);

		JButton connectButton = new JButton("Conectar");
		connectButton.setBounds(66, 157, 273, 45);
		connectButton.addActionListener(e -> {
			String alias = aliasField.getText().trim();
			if (alias.isEmpty()) {
				errorLabel.setText("nicknamea sartu behar duzu");
			} else if (aliasSet.contains(alias)) {
				errorLabel.setText("El alias ya está en uso");
			} else {
				Cliente cliente = new Cliente();
				cliente.conectar("localhost", Servidor.port, alias);
				aliasSet.add(alias);
				dispose();
			}
		});
		getContentPane().setLayout(null);

		getContentPane().add(lblNicknameSartu);
		getContentPane().add(aliasField);
		getContentPane().add(errorLabel);
		getContentPane().add(connectButton);

		setVisible(true);
	}
}
