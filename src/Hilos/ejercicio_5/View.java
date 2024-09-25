package Hilos.ejercicio_5;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private HiloContador hilo1, hilo2, hilo3; // Instancias de los hilos

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 573);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Paneles y botones ya creados en tu interfaz
        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 414, 64);
        contentPane.add(panel);
        panel.setLayout(new BorderLayout(0, 0));

        JButton btnMasHilo1 = new JButton("++");
        panel.add(btnMasHilo1, BorderLayout.WEST);

        JButton btnMenosHilo1 = new JButton("--");
        panel.add(btnMenosHilo1, BorderLayout.EAST);

        JButton btnFinHilo1 = new JButton("Fin hilo 1");
        panel.add(btnFinHilo1, BorderLayout.CENTER);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 86, 414, 64);
        contentPane.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));

        JButton btnMasHilo2 = new JButton("++");
        panel_1.add(btnMasHilo2, BorderLayout.WEST);

        JButton btnMenosHilo2 = new JButton("--");
        panel_1.add(btnMenosHilo2, BorderLayout.EAST);

        JButton btnFinHilo2 = new JButton("Fin hilo 2");
        panel_1.add(btnFinHilo2, BorderLayout.CENTER);

        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 161, 414, 64);
        contentPane.add(panel_2);
        panel_2.setLayout(new BorderLayout(0, 0));

        JButton btnMasHilo3 = new JButton("++");
        panel_2.add(btnMasHilo3, BorderLayout.WEST);

        JButton btnMenosHilo3 = new JButton("--");
        panel_2.add(btnMenosHilo3, BorderLayout.EAST);

        JButton btnFinHilo3 = new JButton("Fin hilo 3");
        panel_2.add(btnFinHilo3, BorderLayout.CENTER);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(10, 236, 414, 64);
        contentPane.add(panel_3);
        panel_3.setLayout(new BorderLayout(0, 0));

        JButton btnFinTodos = new JButton("Finalizar todos");
        panel_3.add(btnFinTodos, BorderLayout.CENTER);

        JLabel lblHilo1Cont = new JLabel("Contador: 0");
        lblHilo1Cont.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblHilo1Cont.setBounds(10, 311, 180, 42);
        contentPane.add(lblHilo1Cont);

        JLabel lblHilo2Cont = new JLabel("Contador: 0");
        lblHilo2Cont.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblHilo2Cont.setBounds(10, 382, 180, 42);
        contentPane.add(lblHilo2Cont);

        JLabel lblHilo3Cont = new JLabel("Contador: 0");
        lblHilo3Cont.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblHilo3Cont.setBounds(10, 457, 180, 42);
        contentPane.add(lblHilo3Cont);

        JLabel lblPrioridadHilo1 = new JLabel("Prioridad: " + Thread.NORM_PRIORITY);
        lblPrioridadHilo1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPrioridadHilo1.setBounds(224, 311, 180, 42);
        contentPane.add(lblPrioridadHilo1);

        JLabel lblPrioridadHilo2 = new JLabel("Prioridad: " + Thread.NORM_PRIORITY);
        lblPrioridadHilo2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPrioridadHilo2.setBounds(224, 382, 180, 42);
        contentPane.add(lblPrioridadHilo2);

        JLabel lblPrioridadHilo3 = new JLabel("Prioridad: " + Thread.NORM_PRIORITY);
        lblPrioridadHilo3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPrioridadHilo3.setBounds(224, 457, 180, 42);
        contentPane.add(lblPrioridadHilo3);

        hilo1 = new HiloContador(lblHilo1Cont, lblPrioridadHilo1);
        hilo2 = new HiloContador(lblHilo2Cont, lblPrioridadHilo2);
        hilo3 = new HiloContador(lblHilo3Cont, lblPrioridadHilo3);

        btnMasHilo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hilo1.setPriority(Thread.MAX_PRIORITY);
            }
        });

        btnMenosHilo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hilo1.setPriority(Thread.MIN_PRIORITY);
            }
        });

        btnFinHilo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hilo1.detenerHilo();
            }
        });

        btnMasHilo2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hilo2.setPriority(Thread.MAX_PRIORITY);
            }
        });

        btnMenosHilo2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hilo2.setPriority(Thread.MIN_PRIORITY);
            }
        });

        btnFinHilo2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hilo2.detenerHilo();
            }
        });

        btnMasHilo3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hilo3.setPriority(Thread.MAX_PRIORITY);
            }
        });

        btnMenosHilo3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hilo3.setPriority(Thread.MIN_PRIORITY);
            }
        });

        btnFinHilo3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hilo3.detenerHilo();
            }
        });

        btnFinTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hilo1.detenerHilo();
                hilo2.detenerHilo();
                hilo3.detenerHilo();
            }
        });

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }

}
