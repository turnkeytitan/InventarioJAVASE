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
public class ModeloItem {
	private String nombre;
	private String imagen;
	private String desc;
	private Double precio;
	public ModeloItem() {
		
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "ModeloItem{" + "nombre=" + nombre + ", imagen=" + imagen + ", desc=" + desc + ", precio=" + precio + '}';
	}

	
	
}
