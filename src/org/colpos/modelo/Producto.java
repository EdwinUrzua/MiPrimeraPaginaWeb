package org.colpos.modelo;

public class Producto {
	private int id;
	private String nombreProducto;
	private String precioUnitario;
	private String precioMayoreo;
	private String nombreCliente;
	private String telefono;
	public Producto(int id, String nombreProducto, String precioUnitario, String precioMayoreo, String nombreCliente,
			String telefono) {
		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.precioUnitario = precioUnitario;
		this.precioMayoreo = precioMayoreo;
		this.nombreCliente = nombreCliente;
		this.telefono = telefono;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(String precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	public String getPrecioMayoreo() {
		return precioMayoreo;
	}
	public void setPrecioMayoreo(String precioMayoreo) {
		this.precioMayoreo = precioMayoreo;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
