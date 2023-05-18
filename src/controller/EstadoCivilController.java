package controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import dao.EstadoCivilDao;
import model.EstadoCivil;
import model.TipoIdentificacion;

public class EstadoCivilController 
{
	private EstadoCivilDao estadoCivilDao;

	public EstadoCivilController(EstadoCivilDao estadoCivilDao) {
		this.estadoCivilDao = estadoCivilDao;
	}
	
	public DefaultComboBoxModel llenarCombo()
	{
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		List<EstadoCivil> estadosCiv = estadoCivilDao.findAll();
		for(EstadoCivil t:estadosCiv)
		{
			modelo.addElement(t.getDescripcion());
		}
		
		return modelo;
	}

}
