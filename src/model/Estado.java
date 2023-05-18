package model;

public class Estado 
{
	private int id;
	private String nombre;
	private String descripcion;
	private FormacionAcademica formacionAcademica;
	
	public Estado()
	{
	}

	public Estado(int id) {
		this.id = id;
	}

	public Estado(int id, String nombre, String descripcion, FormacionAcademica formacionAcademica) {
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
