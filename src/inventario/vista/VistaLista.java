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
public class VistaLista extends JFrame implements ActionListener {

	JButton bsig, borrarItem;
	JButton bant, volver;
	JLabel nombre;
	JLabel precio;
	JLabel imagen;
	JTextArea desc;
	java.util.List<ModeloItem> item;
	Controlador control;
	int conteoDatos;

	public VistaLista(Controlador control) {
		this.control = control;
		this.control.conectar();
		this.item = control.cargarItems();
		nombre = new JLabel();
		precio = new JLabel();
		imagen = new JLabel();
		desc = new JTextArea();
		bsig = new JButton();
		bant = new JButton();
		volver = new JButton();
		borrarItem = new JButton("Borrar");

		setDefaultCloseOperation(2);
		setLayout(null);

		add(nombre);
		nombre.setBounds(40, 10, 120, 30);

		add(precio);
		precio.setBounds(210, 180, 130, 30);

		imagen.setHorizontalAlignment(SwingConstants.CENTER);
		add(imagen);
		imagen.setBounds(10, 70, 140, 140);

		add(desc);
		desc.setBounds(180, 20, 190, 140);
		desc.setEditable(false);
		desc.setFocusable(false);
		desc.setLineWrap(true);
		desc.setColumns(3);
		bsig.setText("Siguiente");
		add(bsig);
		bsig.setBounds(243, 240, 130, 23);

		bant.setText("Anterior");
		add(bant);
		bant.setBounds(30, 240, 120, 23);
		volver.setText("Volver");
		add(volver);
		volver.setBounds(30, 280, 120, 23);
		setBounds(100, 100, 400, 400);
		add(borrarItem);
		borrarItem.setBounds(243, 280, 130, 23);
		conteoDatos = 0;
		nombre.setText(item.get(conteoDatos).getNombre());
		imagen.setIcon(ponerIcono(item.get(conteoDatos).getImagen()));
		desc.setText(item.get(conteoDatos).getDesc());
		precio.setText(Double.toString(item.get(conteoDatos).getPrecio()));

		this.control.cerrar();
		bant.addActionListener(this);
		bsig.addActionListener(this);
		volver.addActionListener(this);
		borrarItem.addActionListener(this);
		setVisible(true);
	}

	ImageIcon ponerIcono(String ruta) {
		ImageIcon imageIcon = new ImageIcon(ruta);
		Image image = imageIcon.getImage();
		Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		imageIcon = new ImageIcon(newimg);
		return imageIcon;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		control.conectar();
		if (e.getSource().equals(bsig)) {
			if (conteoDatos < item.size() - 1) {
				conteoDatos++;
				nombre.setText(item.get(conteoDatos).getNombre());
				imagen.setIcon(ponerIcono(item.get(conteoDatos).getImagen()));
				desc.setText(item.get(conteoDatos).getDesc());
				precio.setText("$" + String.format("%,.2f", item.get(conteoDatos).getPrecio()));
			} else {
				JOptionPane.showMessageDialog(null, "No hay mas items");
			}
		} else if (e.getSource().equals(bant)) {
			if (conteoDatos > 0) {
				conteoDatos--;
				nombre.setText(item.get(conteoDatos).getNombre());
				imagen.setIcon(ponerIcono(item.get(conteoDatos).getImagen()));
				desc.setText(item.get(conteoDatos).getDesc());
				precio.setText("$" + String.format("%,.2f", item.get(conteoDatos).getPrecio()));
			} else {
				JOptionPane.showMessageDialog(null, "No hay mas items");
			}
		} else if (e.getSource().equals(volver)) {
			dispose();
		} else if (e.getSource().equals(borrarItem)) {
			control.borrarItemPorNombre(nombre.getText());
			dispose();
		}
		control.cerrar();
	}
}
