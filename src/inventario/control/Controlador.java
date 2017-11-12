/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.control;

import inventario.modelo.ModeloItem;
import inventario.modelo.ModeloUsuario;
import inventario.vista.VistaCreacionItem;
import inventario.vista.VistaLista;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class Controlador {

	String url = "C:\\Users\\USER\\Music\\clase.db";
	public Connection connect;

	public void conectar() {
		try {
			connect = DriverManager.getConnection("jdbc:sqlite:" + url);
			if (connect != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException ex) {
			System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
		}
	}

	public void cerrar() {
		try {
			connect.close();
		} catch (SQLException ex) {
			System.out.println("Error en el cierre" + ex.getMessage());
		}
	}

	public Boolean ingresar(ModeloUsuario user) {

		PreparedStatement st;
		try {
			if (!user.getUsuario().equals("") && !user.getUsuario().equals("")) {
				st = connect.prepareStatement("select * from usuario where usuario = ?");
				st.setString(1, user.getUsuario());
				ResultSet result = st.executeQuery();
				String u = "", p = "";
				while (result.next()) {
					u = result.getString("usuario");
					p = result.getString("pass");
				}
				if (u.equals(user.getUsuario()) && p.equals(user.getContra())) {
					return true;
				} else {
					JOptionPane.showMessageDialog(null, "Combinación de usuario y contraseña invalidos");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Los campos están vacíos");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return false;
	}

	public void registrarse(String us, String pass) {
		PreparedStatement st;
		try {
			if (!us.equals("") && !pass.equals("")) {
				st = connect.prepareStatement("select * from usuario where usuario = ?");
				st.setString(1, us);
				ResultSet result = st.executeQuery();
				if (result.next()) {
					JOptionPane.showMessageDialog(null, "Ya existe ese usuario");
				} else {
					st = connect.prepareStatement("insert into usuario (usuario, pass) values(?,?);");
					st.setString(1, us);
					st.setString(2, pass);
					st.execute();
					JOptionPane.showMessageDialog(null, "Se creó exitosamente el usuario");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos");
			}
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public void verTodosLosItems() {
		new VistaLista(this);
	}

	public List<ModeloItem> cargarItems() {
		List<ModeloItem> item = new ArrayList();
		PreparedStatement st;
		try {
			st = connect.prepareStatement("select * from item");
			ResultSet result = st.executeQuery();
			while (result.next()) {
				ModeloItem temp = new ModeloItem();
				temp.setDesc(result.getString("descripcion"));
				temp.setImagen(result.getString("foto"));
				temp.setPrecio(result.getDouble("precio"));
				temp.setNombre(result.getString("nombre"));
				item.add(temp);
			}
			return item;
		} catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
		return null;
	}

	public void abrirCrearProducto() {
		new VistaCreacionItem(this);
	}

	public void crearProducto(ModeloItem item) {
		PreparedStatement st;
		try {
			st = connect.prepareStatement("insert into item (nombre, descripcion, foto, precio) values(?,?,?,?);");
			st.setString(1, item.getNombre());
			st.setString(2, item.getDesc());
			st.setString(3, item.getImagen());
			st.setDouble(4, item.getPrecio());
			st.execute();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void borrarItemPorNombre(String nombre) {
		PreparedStatement st;
		try {
			st = connect.prepareStatement("delete from item where nombre = '"+nombre+"'");
			st.executeUpdate();
			System.out.println("sad");
			JOptionPane.showMessageDialog(null, "Se ha borrado el Item");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
