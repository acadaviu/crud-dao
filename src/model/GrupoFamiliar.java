package model;

import java.time.LocalDateTime;

public class GrupoFamiliar 
{
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private Funcionario funcionario;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaActualizacion;
	private Rol rol;
	
	public GrupoFamiliar() 
	{
	}
	

	public GrupoFamiliar(int id) {
		this.id = id;
	}

	public GrupoFamiliar(int id, String nombre, String apellido, String direccion, Funcionario funcionario, Rol rol) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.funcionario = funcionario;
		this.rol = rol;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Funcionario getFuncionario() {
		return funcionario;
	}


	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
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
