/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.vista;

import inventario.control.Controlador;
import inventario.modelo.ModeloItem;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author USER
 */
public class VistaCreacionItem extends JFrame implements ActionListener {

	JButton bagregar;
	JButton bvolver;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JTextField tdesc;
	JTextField timagen;
	JTextField tprecio;
	JTextField tnombre;
	Controlador control;

	public VistaCreacionItem(Controlador control) {
		((JPanel) getContentPane()).setOpaque(false);
		ImageIcon uno = new ImageIcon(this.getClass().getResource("/Fondos/03.jpg"));
		JLabel fondo = new JLabel();
		fondo.setIcon(uno);
		getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
		fondo.setBounds(0, 0, uno.getIconWidth(), uno.getIconHeight());
		this.control = control;
		timagen = new JTextField();
		tdesc = new JTextField();
		tprecio = new JTextField();
		tnombre = new JTextField();
		l1 = new JLabel("Agregar Imagen");
		l2 = new JLabel("Agregar Descripción");
		l3 = new JLabel("Agregar Precio");
		l4 = new JLabel("Agregar Nombre");
		bagregar = new JButton("Agregar");
		bvolver = new JButton("Volver");
		setDefaultCloseOperation(2);
		setLayout(null);
		timagen.setBounds(200, 30, 140, 20);
		tdesc.setBounds(200, 70, 140, 20);
		tprecio.setBounds(200, 110, 140, 20);
		tnombre.setBounds(200, 150, 140, 20);
		l1.setBounds(80, 30, 120, 14);
		l2.setBounds(80, 70, 120, 14);
		l3.setBounds(80, 110, 120, 14);
		l4.setBounds(80, 150, 120, 14);
		bagregar.setBounds(90, 180, 71, 23);
		bvolver.setBounds(220, 180, 63, 23);
		add(timagen);
		add(tdesc);
		add(tprecio);
		add(tnombre);
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(bagregar);
		add(bvolver);
		bagregar.addActionListener(this);
		bvolver.addActionListener(this);
		setBounds(400, 200, 758, 400);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		control.conectar();
		if (e.getSource().equals(bagregar)) {
			ModeloItem item = new ModeloItem();
			item.setNombre(tnombre.getText());
			item.setImagen(timagen.getText());
			item.setDesc(tdesc.getText());
			item.setPrecio(Double.parseDouble(tprecio.getText()));
			control.crearProducto(item);
			JOptionPane.showMessageDialog(null, "El item se ha creado");
			dispose();
		} else if (e.getSource().equals(bvolver)) {
			dispose();
		}
		control.cerrar();
	}

}
