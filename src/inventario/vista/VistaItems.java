/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.vista;

import inventario.control.Controlador;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class VistaItems extends JFrame implements ActionListener {

	JButton bcata;
	JButton bprod;
	Controlador control;

	public VistaItems(Controlador control) {
		((JPanel) getContentPane()).setOpaque(false);
		ImageIcon uno = new ImageIcon(this.getClass().getResource("/Fondos/29.jpg"));
		JLabel fondo = new JLabel();
		fondo.setIcon(uno);
		getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
		this.control = control;
		bprod = new JButton("Agregar Producto");
		bcata = new JButton("Ver Catálogo");
		setDefaultCloseOperation(3);
		setLayout(null);
		setBounds(100, 100, 610, 400);
		getContentPane().add(bprod);
		getContentPane().add(bcata);
		bcata.setBounds(50, 140, 140, 50);
		bprod.setBounds(50, 80, 140, 50);
		setVisible(true);
		bcata.addActionListener(this);
		bprod.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(bcata)) {
			control.verTodosLosItems();
		} else if (e.getSource().equals(bprod)) {
			control.abrirCrearProducto();
		}
	}

}
