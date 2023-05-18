package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;
import model.EstadoCivil;
import util.Mensajes;

public class EstadoCivilImpl implements EstadoCivilDao
{
	private Conexion conexion;
	private Statement st;
	private ResultSet rs;
	
	@Override
	public List<EstadoCivil> findAll() 
	{
		List<EstadoCivil> EstadosCiv = new ArrayList<>();

		try 
		{			
			String sql="SELECT * FROM estados_civil";
			conexion = new Conexion();
			
			st = conexion.getCon().createStatement();
			
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				EstadoCivil estadoCivil = new EstadoCivil();
				estadoCivil.setId(rs.getInt("id"));
				estadoCivil.setNombre(rs.getString("nombre"));
				estadoCivil.setDescripcion(rs.getString("descripcion"));
				EstadosCiv.add(estadoCivil);
			}
			rs.close();
			st.close();
			conexion.getCon().close();
		} 
		catch (SQLException e) 
		{
			Mensajes.mendajeErro("Error de BBDD",e.getMessage() );
		}
		
		return EstadosCiv;
 	}

}
