/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventario.modelo;

/**
 *
 * @author USER
 */
public class ModeloUsuario {
	private String usuario;
	private String contra;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	@Override
	public String toString() {
		return "ModeloUsuario{" + "usuario=" + usuario + ", contra=" + contra + '}';
	}
	
}
