/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.vista;

import inventario.control.Controlador;
import inventario.modelo.ModeloUsuario;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class VistaIngresoUsuario extends JFrame implements ActionListener {

	Boolean ingresado;
	JButton bing;
	JButton breg;
	JLabel lcontra;
	JLabel lusuario;
	JPasswordField tcontra;
	JTextField tusuario;
	Controlador control;

	public VistaIngresoUsuario(Controlador control) {
		((JPanel) getContentPane()).setOpaque(false);
		ImageIcon uno = new ImageIcon(this.getClass().getResource("/Fondos/inzone.jpeg"));
		JLabel fondo = new JLabel();
		fondo.setIcon(uno);
		getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
		this.control = control;
		lusuario = new JLabel();
		lcontra = new JLabel();
		tusuario = new JTextField();
		tcontra = new JPasswordField();
		bing = new JButton();
		breg = new JButton();
		setDefaultCloseOperation(3);
		setLayout(null);
		setBounds(100, 100, 640, 320);
		lusuario.setText("Usuario");
		lcontra.setText("Contraseña");
		bing.setText("Ingresar");
		breg.setText("Registrarse");
		lusuario.setBounds(20, 80, 80, 14);
		lcontra.setBounds(20, 110, 80, 14);
		tusuario.setBounds(130, 80, 140, 20);
		tcontra.setBounds(130, 110, 140, 20);
		bing.setBounds(130, 150, 140, 20);
		breg.setBounds(130, 190, 140, 20);
		add(lusuario);
		add(lcontra);
		add(tusuario);
		add(tcontra);
		add(bing);
		add(breg);
		bing.addActionListener(this);
		breg.addActionListener(this);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		control.conectar();

		if (e.getSource().equals(bing)) {
			ModeloUsuario user = new ModeloUsuario();
			user.setUsuario(tusuario.getText());
			user.setContra(String.valueOf(tcontra.getPassword()));
			ingresado = control.ingresar(user);
			if (ingresado) {
				this.setVisible(false);
				VistaItems items = new VistaItems(control);
			}
		} else {
			control.registrarse(tusuario.getText(), tcontra.getText());
		}
		control.cerrar();
	}
}
