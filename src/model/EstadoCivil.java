package model;

public class EstadoCivil
{
	private int id;
	private String nombre;
	private String descripcion;
	
	public EstadoCivil()
	{
	
	}

	public EstadoCivil(int id) 
	{
		this.id = id;
	}

	public EstadoCivil(int id, String nombre, String descripcion)
	{
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
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
	
}
