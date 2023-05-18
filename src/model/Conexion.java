package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import util.Mensajes;

public class Conexion 
{
	private static final String URL="jdbc:mysql://localhost:3308/recursos_humanos_iud";
	private static final String USUARIO="root";
	private static final String PASSWORD="aguacatote1";
	
	private Connection con;
	
	public Conexion()
	{
		try 
		{
			con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
			con.createStatement();
		} 
		catch (SQLException ex) 
		{
			Mensajes.mendajeErro("Error de Conexion", ex.getMessage());
		}
	}

	public Connection getCon() 
	{
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	

}
