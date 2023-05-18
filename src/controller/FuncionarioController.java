package controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import dao.FuncionarioDao;
import dto.FuncionarioDTO;
import model.EstadoCivil;
import model.Funcionario;

public class FuncionarioController 
{
	private FuncionarioDao funacionarioDao;

	public FuncionarioController(FuncionarioDao funacionarioDao)
	{
		this.funacionarioDao = funacionarioDao;
	}
	
	public DefaultTableModel llenarTabla()
	{
		DefaultTableModel modelo = new DefaultTableModel()
				{
					public boolean isCellEditable(int row, int column)
					{
						return false;
					}
				};
		
		modelo.addColumn("Id");
		modelo.addColumn("Numero Doc.");
		modelo.addColumn("nombres");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Sexo");
		modelo.addColumn("direccion");
		modelo.addColumn("Telefono");
		modelo.addColumn("Fecha Nac.");
		modelo.addColumn("Tipo Identif.");
		modelo.addColumn("Estado civil");
		
		
		List<FuncionarioDTO> funcionarios = funacionarioDao.findall();
		String [] registros = new String[10];
		
		for(FuncionarioDTO f:funcionarios)
		{
			registros[0] = String.valueOf(f.getId());
			registros[1] = f.getNumeroIdentificacion();
			registros[2] = f.getNombres();
			registros[3] = f.getApellidos();
			registros[4] = String.valueOf(f.getSexo());
			registros[5] = f.getDireccion();
			registros[6] = f.getTelefono();
			registros[7] = f.getFechaNacimiento().toString();
			registros[8] = String.valueOf(f.getDescripcionTipoIdentificacion());
			registros[9] = String.valueOf(f.getDescripcionEstadoCivil());
			
			modelo.addRow(registros);
		}
		
		return modelo;
	}

	public Funcionario listarById(String documento) 
	{
		return funacionarioDao.findByDocumento(documento);
	}
	
	public  int save(Funcionario funcionario)
	{
		return funacionarioDao.save(funcionario);
	}
	
	public int update(Funcionario funcionario)
	{
		return funacionarioDao.update(funcionario);
	}

	public void eliminar(String documento)
	{
		funacionarioDao.delete(documento);
	}
	
}
