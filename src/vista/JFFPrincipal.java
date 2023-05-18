package vista;


import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import controller.EstadoCivilController;
import controller.FuncionarioController;
import controller.TipoIdentificacionController;
import dao.EstadoCivilDao;
import dao.EstadoCivilImpl;
import dao.FuncionarioDao;
import dao.FuncionarioImpl;
import dao.TipoIdentificacionDao;
import dao.TipoIdentificacionImpl;
import model.EstadoCivil;
import model.Funcionario;
import model.TipoIdentificacion;
import util.Mensajes;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFFPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textDocumento;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textTelefono;
	private JTable JTBfuncionarios;
	private JButton JBTEditar; 
	private JButton JBTEliminar;
	private JComboBox JCBtipoDocumento;
	private JComboBox JCBestadoCivil;
	private JComboBox JCBsexo;
	private JDateChooser JDCfecha;
	private JTextArea textAreaDireccion;

	
	private TipoIdentificacionController tipoIdctrl;
	private EstadoCivilController estadoCtrl;
	private FuncionarioController funcionarioCtrl;
	
	FuncionarioController funcionarioDao;
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFFPrincipal frame = new JFFPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFFPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFFPrincipal.class.getResource("/image/diskette-save.png")));
		setTitle("gestionar funcionarios");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1016, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(0, 0, 1010, 527);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GESTI\u00D3N FUNCIONARIOS");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(81, 21, 217, 26);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 24));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("tipo ID");
		lblNewLabel_1.setBounds(39, 68, 59, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(lblNewLabel_1);
		
		JCBtipoDocumento = new JComboBox();
		JCBtipoDocumento.setForeground(Color.BLACK);
		JCBtipoDocumento.setBounds(108, 66, 159, 22);
		JCBtipoDocumento.setModel(new DefaultComboBoxModel(new String[] {"CC", "TI", "PS"}));
		JCBtipoDocumento.setBackground(Color.WHITE);
		JCBtipoDocumento.setToolTipText("");
		panel.add(JCBtipoDocumento);
		
		JLabel lblNewLabel_1_1 = new JLabel("Documento");
		lblNewLabel_1_1.setBounds(314, 68, 79, 14);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(lblNewLabel_1_1);
		
		textDocumento = new JTextField();
		textDocumento.setBounds(408, 65, 129, 21);
		textDocumento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel.add(textDocumento);
		textDocumento.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1_1.setBounds(590, 68, 59, 14);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(lblNewLabel_1_1_1);
		
		textNombre = new JTextField();
		textNombre.setBounds(672, 65, 159, 21);
		textNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNombre.setColumns(10);
		panel.add(textNombre);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Apellido");
		lblNewLabel_1_1_1_1.setBounds(39, 102, 59, 14);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(lblNewLabel_1_1_1_1);
		
		textApellido = new JTextField();
		textApellido.setBounds(108, 99, 159, 21);
		textApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textApellido.setColumns(10);
		panel.add(textApellido);
		
		JLabel lblNewLabel_1_2 = new JLabel("Sexo");
		lblNewLabel_1_2.setBounds(314, 102, 59, 14);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(lblNewLabel_1_2);
		
		JCBsexo = new JComboBox();
		JCBsexo.setBounds(408, 100, 129, 22);
		JCBsexo.setBackground(Color.WHITE);
		JCBsexo.setModel(new DefaultComboBoxModel(new String[] {"O", "M", "F"}));
		JCBsexo.setToolTipText("");
		panel.add(JCBsexo);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Direcci\u00F3n");
		lblNewLabel_1_1_2.setBounds(590, 143, 79, 14);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Tel\u00E9fono");
		lblNewLabel_1_1_1_2.setBounds(39, 143, 59, 14);
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(lblNewLabel_1_1_1_2);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(108, 140, 159, 21);
		textTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTelefono.setColumns(10);
		panel.add(textTelefono);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Fecha Nacimiento");
		lblNewLabel_1_1_1_1_1.setBounds(314, 143, 112, 14);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Estado Civil");
		lblNewLabel_1_2_1.setBounds(590, 102, 79, 14);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.ITALIC, 15));
		panel.add(lblNewLabel_1_2_1);
		
		JCBestadoCivil = new JComboBox();
		JCBestadoCivil.setBounds(672, 100, 159, 22);
		JCBestadoCivil.setBackground(Color.WHITE);
		JCBestadoCivil.setToolTipText("");
		panel.add(JCBestadoCivil);
		
		textAreaDireccion = new JTextArea();
		textAreaDireccion.setBounds(672, 139, 159, 47);
		textAreaDireccion.setForeground(new Color(0, 0, 0));
		textAreaDireccion.setFont(new Font("Monospaced", Font.PLAIN, 12));
		textAreaDireccion.setBackground(Color.WHITE);
		panel.add(textAreaDireccion);
		
		JButton JBTnuevo = new JButton("Nuevo");
		JBTnuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();				
				textDocumento.setEnabled(true);
				JCBtipoDocumento.setEnabled(true);
				
				
			}
		});
		JBTnuevo.setFont(new Font("Tahoma", Font.BOLD, 13));
		JBTnuevo.setBounds(138, 194, 89, 35);
		JBTnuevo.setBackground(new Color(224, 255, 255));
		panel.add(JBTnuevo);
		
		JButton JBTguardar = new JButton("Guardar");
		JBTguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(guardar())
				{
					llenarTablaFuncioario();
					clear();
				}
			}
		});
		JBTguardar.setFont(new Font("Tahoma", Font.BOLD, 13));
		JBTguardar.setBounds(702, 194, 89, 35);
		JBTguardar.setBackground(new Color(224, 255, 255));
		panel.add(JBTguardar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 262, 1010, 182);
		panel.add(scrollPane);
		
		JTBfuncionarios = new JTable();
		JTBfuncionarios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JTBfuncionarios.getSelectedRow() != -1)
				{
					JBTEliminar.setEnabled(true);
					JBTEditar.setEnabled(true);
					
					textDocumento.setText(JTBfuncionarios.getValueAt(JTBfuncionarios.getSelectedRow(),1).toString());
					textNombre.setText(JTBfuncionarios.getValueAt(JTBfuncionarios.getSelectedRow(),2).toString());
					textApellido.setText(JTBfuncionarios.getValueAt(JTBfuncionarios.getSelectedRow(), 3).toString());
					JCBsexo.setSelectedItem(JTBfuncionarios.getValueAt(JTBfuncionarios.getSelectedRow(), 4));
					JCBestadoCivil.setSelectedItem(JTBfuncionarios.getValueAt(JTBfuncionarios.getSelectedRow(), 9));
					textTelefono.setText(JTBfuncionarios.getValueAt(JTBfuncionarios.getSelectedRow(),6).toString());
					JCBtipoDocumento.setSelectedItem(JTBfuncionarios.getValueAt(JTBfuncionarios.getSelectedRow(), 8));
					JDCfecha.setDateFormatString((String)JTBfuncionarios.getValueAt(JTBfuncionarios.getSelectedRow(), 7));
					textAreaDireccion.setText(JTBfuncionarios.getValueAt(JTBfuncionarios.getSelectedRow(),5).toString());
					
					textDocumento.setEnabled(false);
					JCBtipoDocumento.setEnabled(false);
				}
			}
		});
		scrollPane.setViewportView(JTBfuncionarios);
		JTBfuncionarios.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Tipo identificacion", "nombre", "apellido", "sexo", "Eestado civil", "telefono", "Fecha nacimiento", "Direccion"
			}
		));
		
		JButton JBTrefrescar = new JButton("Refrescar");
		JBTrefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				llenarTablaFuncioario();
			}
		});
		JBTrefrescar.setFont(new Font("Tahoma", Font.BOLD, 11));
		JBTrefrescar.setBackground(new Color(224, 255, 255));
		JBTrefrescar.setBounds(203, 466, 89, 35);
		panel.add(JBTrefrescar);
		
		JBTEditar =  new JButton("Editar");
		JBTEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(actualizar()) 
				{
					llenarTablaFuncioario();
					clear();
					textDocumento.setEnabled(true);
					JCBtipoDocumento.setEnabled(true);
				} 
				
			}
		});
		JBTEditar.setFont(new Font("Tahoma", Font.BOLD, 13));
		JBTEditar.setBackground(new Color(224, 255, 255));
		JBTEditar.setBounds(402, 466, 89, 35);
		panel.add(JBTEditar);
		
		JBTEliminar = new JButton("Eliminar");
		JBTEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Mensajes.mensajeConfirmacion("Eliminar","�Dese Elimiar?"))
				{
					eliminar();
					llenarTablaFuncioario();
					clear();
					textDocumento.setEnabled(true);
					JCBtipoDocumento.setEnabled(true);
				}
			}
		});
		JBTEliminar.setEnabled(false);
		JBTEliminar.setForeground(Color.WHITE);
		JBTEliminar.setFont(new Font("Tahoma", Font.BOLD, 13));
		JBTEliminar.setBackground(new Color(240, 128, 128));
		JBTEliminar.setBounds(601, 466, 89, 35);
		panel.add(JBTEliminar);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(JFFPrincipal.class.getResource("/image/employee-card.png")));
		lblNewLabel_2.setBounds(10, 10, 65, 47);
		panel.add(lblNewLabel_2);
		
		JDCfecha = new JDateChooser();
		JDCfecha.setBounds(436, 141, 101, 20);
		panel.add(JDCfecha);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 30, 46, 14);
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Mensajes.mensajeConfirmacion("Salir del sistema","Seguro desea Salir"))
				{
					dispose();

				}
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		
		btnNewButton.setBackground(new Color(240, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(855, 24, 129, 23);
		panel.add(btnNewButton);
	
		init();
	}
	
	private void init()
	{
		llenarComboTipoDocumento();
		llenarComboEstadoCivil();
		llenarTablaFuncioario();
		JBTEditar.setEnabled(false);
		JBTEliminar.setEnabled(false);
	}

	
	private void llenarComboTipoDocumento()
	{
		TipoIdentificacionDao tipoIdentificacionDao= new TipoIdentificacionImpl();
		
		tipoIdctrl = new TipoIdentificacionController(tipoIdentificacionDao);
		
		JCBtipoDocumento.setModel(tipoIdctrl.llenarCombo());
			
		
	}
	
	private void llenarComboEstadoCivil()
	{
		EstadoCivilDao estadoCivilDao = new EstadoCivilImpl();
		estadoCtrl = new EstadoCivilController(estadoCivilDao);
		JCBestadoCivil.setModel(estadoCtrl.llenarCombo());
	}
	
	private void llenarTablaFuncioario()
	{
		FuncionarioDao funcionarioDao = new FuncionarioImpl(); 
		funcionarioCtrl = new FuncionarioController(funcionarioDao);
		JTBfuncionarios.setModel(funcionarioCtrl.llenarTabla());
	}
	
	private boolean guardar()
	{
		int resultado = 0;
		Funcionario funcionario = new Funcionario();
		TipoIdentificacion tipoIdentificacion = new 
				TipoIdentificacion(JCBtipoDocumento.getSelectedIndex() + 1);
		
		funcionario.setTipoIdentificacion(tipoIdentificacion);
		funcionario.setNumeroIdentificacion(textDocumento.getText().trim());
		funcionario.setNombre(textNombre.getText().trim());
		funcionario.setApellido(textApellido.getText().trim());
		funcionario.setSexo(JCBsexo.getSelectedItem().toString().charAt(0));
		funcionario.setTelefono(textTelefono.getText());
		if(JDCfecha.getDate() != null)
		{
			funcionario.setFechaNacimiento
			(JDCfecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		}
		else
		{
			funcionario.setFechaNacimiento(LocalDate.now(ZoneId.systemDefault()));

		}
		EstadoCivil estadoCivil = new  EstadoCivil(JCBestadoCivil.getSelectedIndex() +1);
		funcionario.setEstadoCivil(estadoCivil);
		
		funcionario.setDireccion(textAreaDireccion.getText().trim());
		
		resultado = funcionarioCtrl.save(funcionario);
		
		if(resultado > 0)
		{
			return true;
		}
		return false;
	}
	
	private boolean actualizar()
	{
		int resultado = 0;
		Funcionario funcionario = new Funcionario();
		TipoIdentificacion tipoIdentificacion = new 
				TipoIdentificacion(JCBtipoDocumento.getSelectedIndex() + 1);
		
		funcionario.setTipoIdentificacion(tipoIdentificacion);
		funcionario.setNumeroIdentificacion(textDocumento.getText().trim());
		funcionario.setNombre(textNombre.getText().trim());
		funcionario.setApellido(textApellido.getText().trim());
		funcionario.setSexo(JCBsexo.getSelectedItem().toString().charAt(0));
		funcionario.setTelefono(textTelefono.getText());
		if(JDCfecha.getDate() != null)
		{
			funcionario.setFechaNacimiento
			(JDCfecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
		}
		else
		{
			funcionario.setFechaNacimiento(LocalDate.now(ZoneId.systemDefault()));

		}
		EstadoCivil estadoCivil = new  EstadoCivil(JCBestadoCivil.getSelectedIndex() +1);
		funcionario.setEstadoCivil(estadoCivil);
		
		funcionario.setDireccion(textAreaDireccion.getText().trim());
		
		resultado = funcionarioCtrl.update(funcionario);
		
		if(resultado > 0)
		{
			return true;
		}
		return false;
	}
	
	public void eliminar()
	{
		String documento = (String) JTBfuncionarios
				.getValueAt(JTBfuncionarios.getSelectedRow(), 1);
		
		funcionarioCtrl.eliminar(documento);
	}
	
	public void clear()
	{
		textNombre.setText(null);
		textApellido.setText(null);
		textDocumento.setText(null);
		textAreaDireccion.setText(null);
		textTelefono.setText(null);
		JCBtipoDocumento.setSelectedItem(null);
		llenarComboEstadoCivil();
		llenarComboTipoDocumento();
		
	}
}
