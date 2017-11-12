/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario;

import inventario.control.Controlador;
import inventario.vista.VistaIngresoUsuario;

/**
 *
 * @author USER
 */
public class Inventario {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Controlador control = new Controlador();
		VistaIngresoUsuario asd = new VistaIngresoUsuario(control);
	}
	
}
