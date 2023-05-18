package model;

public class TipoIdentificacion 
{
	private int id;
	private String nombre;
	private String descripcion;
	
	public TipoIdentificacion()
	{
		
	}
	
	public TipoIdentificacion(int id) {
		this.id = id;
	}

	public TipoIdentificacion(int id, String nombre, String descripcion) 
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
