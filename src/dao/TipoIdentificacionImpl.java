package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;
import model.TipoIdentificacion;
import util.Mensajes;

public class TipoIdentificacionImpl implements TipoIdentificacionDao
{
	private Conexion conexion;
	private Statement st;
	private ResultSet rs;

	@Override
	public List<TipoIdentificacion> findAll() 
	{
		List<TipoIdentificacion> tiposIds = new ArrayList<>();
		
		
		try 
		{
			String sql = "SELECT * FROM tipos_identificacion";
			conexion = new Conexion();

			st = conexion.getCon().createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				TipoIdentificacion tipoIdentificaion = new TipoIdentificacion();
				tipoIdentificaion.setId(rs.getInt("id"));
				tipoIdentificaion.setNombre(rs.getString("nombre"));
				tipoIdentificaion.setDescripcion(rs.getString("descripcion"));
				tiposIds.add(tipoIdentificaion);
			}
			st.close();
			rs.close();
			conexion.getCon().close();
		} 
		catch (SQLException ex) 
		{
			Mensajes.mendajeErro("Error de BBDD",ex.getMessage() );
		}
		
		
		return tiposIds;
	}

}
