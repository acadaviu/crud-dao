package util;

import javax.swing.JOptionPane;

public interface Mensajes 
{

	public static void mostrarMensaje(String title, String msg, int tipo)
	{
		JOptionPane.showMessageDialog(null, msg, title, tipo);
	}
	
	public static void mendajeErro(String title, String msg)
	{
		mostrarMensaje( title,msg, JOptionPane.ERROR_MESSAGE);
	}
	
	public static boolean mensajeConfirmacion(String title, String msg)
	{
		JOptionPane Jp = new JOptionPane();
		
		return Jp.showConfirmDialog(null,msg,title,JOptionPane.YES_NO_OPTION) == Jp.YES_OPTION;
	}
}
