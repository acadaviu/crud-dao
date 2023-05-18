package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.result.LocalDateTimeValueFactory;

import dto.FuncionarioDTO;
import model.Conexion;
import model.EstadoCivil;
import model.Funcionario;
import model.TipoIdentificacion;
import util.Mensajes;

public class FuncionarioImpl implements FuncionarioDao
{
	private Conexion conexion;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;

	@Override
	public List<FuncionarioDTO> findall() {
		List<FuncionarioDTO> funcionarios = new ArrayList<>();

		try 
		{			
			//String sql="SELECT * FROM funcionarios";
			String sql = "SELECT f.*,t.descripcion nombret,e.descripcion desce "
                    + "FROM funcionarios f "
                    + "INNER JOIN tipos_identificacion t ON f.tipos_identificacion_id=t.id "
                    + "INNER JOIN estados_civil e "
                    + "ON f.estados_civil_id=e.id";
			
			conexion = new Conexion();
			
			st = conexion.getCon().createStatement();
			
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
				funcionarioDTO.setId(rs.getInt("id"));
				funcionarioDTO.setNumeroIdentificacion(rs.getString("numero_identificacion"));
				funcionarioDTO.setNombres(rs.getString("nombres"));
				funcionarioDTO.setApellidos(rs.getString("apellidos"));
				funcionarioDTO.setSexo((rs.getString("sexo").charAt(0)));
				funcionarioDTO.setDireccion(rs.getString("direccion"));
				funcionarioDTO.setTelefono(rs.getString("telefono"));
				funcionarioDTO.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
				funcionarioDTO.setDescripcionTipoIdentificacion(rs.getString("nombret"));
				funcionarioDTO.setDescripcionEstadoCivil(rs.getString("desce"));
				
				funcionarios.add(funcionarioDTO);
			}
			rs.close();
			st.close();
			conexion.getCon().close();
		} 
		catch (SQLException e) 
		{
			Mensajes.mendajeErro("Error de BBDD",e.getMessage() );
		}
		
		
		return funcionarios;
	}

	@Override
	public Funcionario findByDocumento(String documento) 
	{
		Funcionario funcionario = new Funcionario();

		try 
		{			
			String sql="SELECT * FROM funcionarios WHERE numero_identificacion = ?";
			conexion = new Conexion();
			
			pst = conexion.getCon().prepareStatement(sql);
			pst.setString(1,documento);
			rs = pst.executeQuery();
			
			if(rs.first())
			{
				funcionario.setId(rs.getInt("id"));
				funcionario.setNumeroIdentificacion(rs.getString("numero_identificacion"));
				funcionario.setNombre(rs.getString("nombres"));
				funcionario.setApellido(rs.getString("apellidos"));
				funcionario.setSexo((rs.getString("sexo").charAt(0)));
				funcionario.setFechaNacimiento(LocalDate.parse(rs.getString("fecha_nacimiento")));
			}
			pst.close();
			rs.close();
			conexion.getCon().close();
		} 
		catch (SQLException e) 
		{
			Mensajes.mendajeErro("Error de BBDD",e.getMessage() );
		}
		
		
		return funcionario;
	}

	@Override
	public int save(Funcionario funcionario) {
		int resultado=0;

		try 
		{			
			String sql=" INSERT INTO funcionarios(numero_identificacion,"
					+ "nombres,"
					+ "apellidos,"
					+ "sexo,"
					+ "direccion,"
					+ "telefono,"
					+ "fecha_nacimiento,"
					+ "tipos_identificacion_id,"
					+ "estados_civil_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			conexion = new Conexion();
			
			pst = conexion.getCon().prepareStatement(sql);
			pst.setString(1,funcionario.getNumeroIdentificacion());
			pst.setString(2,funcionario.getNombre());
			pst.setString(3,funcionario.getApellido());
			pst.setString(4,String.valueOf(funcionario.getSexo()));
			pst.setString(5,funcionario.getDireccion());
			pst.setString(6,funcionario.getTelefono());
			pst.setString(7,funcionario.getFechaNacimiento().toString());
			pst.setInt(8,funcionario.getTipoIdentificacion().getId());
			pst.setInt(9,funcionario.getEstadoCivil().getId());

			resultado = pst.executeUpdate();
			
		
			pst.close();
			conexion.getCon().close();
		} 
		catch (SQLException e) 
		{
			Mensajes.mendajeErro("Error de BBDD",e.getMessage() );
		}
		
		
		return resultado;
	}

	@Override
	public int update(Funcionario funcionario) {
		//UPDATE funcionarios SET nombre = ?, apellidos = ?, tele.....
		// TODO: IMPLEMENTAR PARECIDO AL SAVE
		int resultado=0;

		try 
		{			
			String sql="UPDATE funcionarios SET numero_identificacion = ?, "
					+ "nombres = ?, apellidos = ?, sexo = ?, direccion = ?, "
					+ "telefono = ?, fecha_nacimiento = ?, "
					+ "tipos_identificacion_id = ?, estados_civil_id = ? "
					+ "WHERE numero_identificacion = ?";
			conexion = new Conexion();
			
			pst = conexion.getCon().prepareStatement(sql);
			
			pst.setString(1,funcionario.getNumeroIdentificacion());
			pst.setString(2,funcionario.getNombre());
			pst.setString(3,funcionario.getApellido());
			pst.setString(4,String.valueOf(funcionario.getSexo()));
			pst.setString(5,funcionario.getDireccion());
			pst.setString(6,funcionario.getTelefono());
			pst.setString(7,funcionario.getFechaNacimiento().toString());
			pst.setInt(8,funcionario.getTipoIdentificacion().getId());
			pst.setInt(9,funcionario.getEstadoCivil().getId());
			pst.setString(10,funcionario.getNumeroIdentificacion());
			resultado = pst.executeUpdate();
			
		
			pst.close();
			conexion.getCon().close();
		} 
		catch (SQLException e) 
		{
			Mensajes.mendajeErro("Error de BBDD",e.getMessage() );
		}
		
		
		return resultado;
	}

	@Override
	public void delete(String documento) 
	{

		int resultado=0;

		try 
		{			
			String sql="DELETE FROM funcionarios WHERE  numero_identificacion = ?";
			conexion = new Conexion();
			
			pst = conexion.getCon().prepareStatement(sql);
			pst.setString(1,documento);

			resultado = pst.executeUpdate();
			
		
			pst.close();
			conexion.getCon().close();
		} 
		catch (SQLException e) 
		{
			Mensajes.mendajeErro("Error de BBDD",e.getMessage() );
		}
	}



}
