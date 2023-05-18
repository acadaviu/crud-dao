package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FormacionAcademica 
{
	private int id;
	private LocalDate fechaInicio;
	private LocalDate fechaFinalizacion;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaActualizacion;
	private Funcionario funcionario;
	private Universidad universidad;
	
	public FormacionAcademica() 
	{
	}

	public FormacionAcademica(int id) 
	{
		this.id = id;
	}

	public FormacionAcademica(int id, LocalDate fechaInicio, LocalDate fechaFinalizacion, Funcionario funcionario,
			Universidad universidad) {
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.funcionario = funcionario;
		this.universidad = universidad;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(LocalDate fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Universidad getUniversidad() {
		return universidad;
	}

	public void setUniversidad(Universidad universidad) {
		this.universidad = universidad;
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
