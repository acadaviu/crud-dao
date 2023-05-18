package dao;

import java.util.List;

import dto.FuncionarioDTO;
import model.Funcionario;

public interface FuncionarioDao 
{
	//CRUD
	
	List<FuncionarioDTO> findall();
	
	Funcionario findByDocumento(String documento);
	
	int save(Funcionario funcionario);
	
	int update(Funcionario funcionario);
	
	void delete(String documento);
}
