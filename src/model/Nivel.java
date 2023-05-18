package model;

public class Nivel
{
	private int id;
	private String nombre;
	private String descripcion;
	private FormacionAcademica formacionAcademica;
	
	public Nivel() 
	{
	}

	public Nivel(int id) 
	{
		this.id = id;
	}

	public Nivel(int id, String nombre, String descripcion, FormacionAcademica formacionAcademica) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.formacionAcademica = formacionAcademica;
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

	public FormacionAcademica getFormacionAcademica() {
		return formacionAcademica;
	}

	public void setFormacionAcademica(FormacionAcademica formacionAcademica) {
		this.formacionAcademica = formacionAcademica;
	}

	public int getId() {
		return id;
	}
	
	
}
