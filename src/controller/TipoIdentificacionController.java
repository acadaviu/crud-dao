package controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import dao.TipoIdentificacionDao;
import model.TipoIdentificacion;

public class TipoIdentificacionController
{
	private TipoIdentificacionDao tipoIdentificacionDao;

	public TipoIdentificacionController(TipoIdentificacionDao tipoIdentificacionDao)
	{
		this.tipoIdentificacionDao = tipoIdentificacionDao;
	}
	
	public DefaultComboBoxModel llenarCombo()
	{
		DefaultComboBoxModel modelo = new DefaultComboBoxModel();
		
		List<TipoIdentificacion> tiposIds = tipoIdentificacionDao.findAll();
		for(TipoIdentificacion t:tiposIds)
		{
			modelo.addElement(t.getDescripcion());
		}
		
		return modelo;
	}

	
}
