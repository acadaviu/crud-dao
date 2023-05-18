package model;

import java.time.LocalDateTime;

public class Universidad 
{
	private int id;
	private String nombre;
	private String descripcion;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaActualizacion;
	
	public Universidad() 
	{
	}

	public Universidad(int id) 
	{
		this.id = id;
	}

	public Universidad(int id, String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public int getId() {
		return id;
	}
	
	
	
	
}
