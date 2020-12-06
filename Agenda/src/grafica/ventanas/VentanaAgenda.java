package grafica.ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import grafica.controladores.ControladorActualizarDatosAgenda;
import grafica.controladores.ControladorAltaDatosAgenda;
import grafica.controladores.ControladorBorrarDatosAgenda;
import grafica.controladores.ControladorTablaAgenda;
import logicapersistencia.valueObjects.VOAgenda;


import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.TextArea;

public class VentanaAgenda extends JFrame {

	private Fondo contentPane;
	private JPanel contentPane2;
	private JTextField textFieldCedula;
	private JTextField textFieldNombre;
	private JTextField textFieldTelefono;
	private JTable tablaAgenda;
	private DefaultTableModel modelo;
	private JTextField textFieldSeleccion;
	Date fecha = new Date();
	
	JScrollPane scrollPane = new JScrollPane();
	ControladorTablaAgenda controlador = new ControladorTablaAgenda();
	ControladorActualizarDatosAgenda controladorActualizar = new ControladorActualizarDatosAgenda();
	ControladorAltaDatosAgenda controladorAlta = new ControladorAltaDatosAgenda();
	ControladorBorrarDatosAgenda controladorBorrar = new ControladorBorrarDatosAgenda();
	private JTextField textFieldBuscarRutaPdf;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgenda frame = new VentanaAgenda();
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
	public VentanaAgenda() {
		Icon imgUy = new ImageIcon(getClass().getResource("uy2.png"));
		setTitle("Agenda Base Datos");
		setBackground(new Color(255, 153, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 371);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTablas = new JMenu("Tablas");
		menuBar.add(mnTablas);
		
		JMenuItem mntmCargosPersonal = new JMenuItem("Cargos Personal");
		mntmCargosPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaDesignacionCargo ventana = new VentanaDesignacionCargo();
				ventana.setVisible(true);
				
			}
		});
		mnTablas.add(mntmCargosPersonal);
		
		JMenu mnEdicin = new JMenu("Archivos");
		menuBar.add(mnEdicin);
		
		JMenuItem mntmCerrarPrograma = new JMenuItem("Cerrar Programa");
		mntmCerrarPrograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mnEdicin.add(mntmCerrarPrograma);
		contentPane = new Fondo("segundoFondo.2.jpg");
		contentPane.setBackground(new Color(255, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(389, 277, 158, 23);
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VentanaAgenda.this.dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnCerrar);
		
		JPanel panel = new JPanel();
		panel.setBounds(21, 47, 526, 109);
		panel.setBackground(new Color(255, 204, 255));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCedula.setBounds(10, 24, 66, 14);
		panel.add(lblCedula);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 49, 66, 14);
		panel.add(lblNombre);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTel.setBounds(10, 74, 66, 14);
		panel.add(lblTel);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(86, 71, 169, 20);
		panel.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(86, 46, 169, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldCedula = new JTextField();
		textFieldCedula.setBounds(86, 21, 169, 20);
		panel.add(textFieldCedula);
		textFieldCedula.setColumns(10);
		
		JButton btnIngresarDatos = new JButton("Ingresar Datos");
		btnIngresarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//-------------- acá INGRESO DATOS a la base de datos ----------------- //
				
				
				String nombre = textFieldNombre.getText();
				String telefono = textFieldTelefono.getText();
				String cedula = textFieldCedula.getText();
				String img = textFieldSeleccion.getText();
				String nom_Img = textFieldSeleccion.getText();
				
				InputStream img2 = null; 
				
				try {
					img2 = new ByteArrayInputStream(img.getBytes("UTF-8"));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					controladorAlta.nuevosDatos(nombre, telefono, cedula, nom_Img, img2);
					
					textFieldCedula.setText(null);
					textFieldNombre.setText(null);
					textFieldTelefono.setText(null);
					textFieldSeleccion.setText(null);
					
					controlador.listarDatosPersonas();// no funciona.
					
					JOptionPane.showMessageDialog(null, "Has ingresado correctamente los datos", "Estudiantes Ametrano 2016", JOptionPane.ERROR_MESSAGE, imgUy);
				} catch (SQLException error) {
					// TODO Auto-generated catch block
					error.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error :\n"+error, "Estudiantes Ametrano 2016", JOptionPane.ERROR_MESSAGE, imgUy);
				}			

				

			}});
		
				
			
		btnIngresarDatos.setBounds(312, 45, 169, 23);
		panel.add(btnIngresarDatos);
		
		JButton btnResetear = new JButton("Resetear");
		btnResetear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldCedula.setText(null);
				textFieldNombre.setText(null);
				textFieldTelefono.setText(null);
				textFieldSeleccion.setText(null);
				
				
			}
		});
		btnResetear.setBounds(312, 70, 169, 23);
		panel.add(btnResetear);
		
		JButton btnBorrar = new JButton("Borrar Dato");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
								
					if(tablaAgenda.getSelectedRow() !=-1){
					int fila = tablaAgenda.getSelectedRow();
					String borrarCedula = tablaAgenda.getValueAt(fila,1).toString();
					try {
						controladorBorrar.borrarDatosPersonas(borrarCedula);
						JOptionPane.showMessageDialog(null, "Se ha eliminado", "Estudiantes Ametrano 2016", JOptionPane.ERROR_MESSAGE, imgUy);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
														  
					}}});
		btnBorrar.setBounds(312, 15, 169, 23);
		panel.add(btnBorrar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(21, 169, 526, 97);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		//-------------- acá SE MUESTRAN LOS DATOS de la base de datos ----------------- //
		
		
		
		
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 526, 97);
		panel_1.add(scrollPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(557, 25, 224, 242);
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(new Color(255, 204, 255));
		contentPane.add(panel_2);
		
		JLabel lblFoto = new JLabel("");
		lblFoto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		
//		-------------------------------- OTRA FORMA -------------------------------------------------//
		//ImageIcon imagen4 = new ImageIcon(VentanaAgenda.class.getResource("/img/incognita.jpg"));
//		Image imag4 = imagen4.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH);
//		lblFoto.setIcon(new ImageIcon(imag4));
//		contentPane2.add(lblFoto);
		
		
		lblFoto.setBounds(24, 21, 179, 138);
		panel_2.add(lblFoto);
		
		JButton btnBuscarFoto = new JButton("Buscar Foto");
		btnBuscarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// ************************** BUSCA RUTA PARA BUSCAR JPG***************//
				
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Formatos de archivo JPG(*.jpg; *.png)","jpg","png");
				
				JFileChooser dlg= new JFileChooser();
				dlg.addChoosableFileFilter(filtro);
				dlg.setDialogTitle("Abrir archivo");
				File ruta = new File("C:/Users/Mariu/Desktop/img");
				dlg.setCurrentDirectory(ruta);
				
				int option = dlg.showSaveDialog(btnBuscarFoto);
				
				if (option == JFileChooser.APPROVE_OPTION) {
					
					File f=dlg.getSelectedFile();
					textFieldSeleccion.setText(f.toString());
					String fotoRuta = textFieldSeleccion.getText();
					
					Image foto = getToolkit().getImage(textFieldSeleccion.getText());
					foto = foto.getScaledInstance(180, 150, Image.SCALE_DEFAULT);
					lblFoto.setIcon(new ImageIcon (foto));
				
				}
				
			}
		});
		btnBuscarFoto.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBuscarFoto.setBounds(24, 170, 179, 23);
		panel_2.add(btnBuscarFoto);
		
		textFieldSeleccion = new JTextField();
		textFieldSeleccion.setColumns(10);
		textFieldSeleccion.setBounds(24, 211, 176, 20);
		panel_2.add(textFieldSeleccion);
		
		JLabel label_1 = new JLabel("Seleccion:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(0, 194, 94, 14);
		panel_2.add(label_1);
		
		tablaAgenda = new JTable();
			
		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Telefono");
		modelo.addColumn("Cedula");
		modelo.addColumn("Imagen");
	
		
		List<VOAgenda> lstAgenda = controlador.listarDatosPersonas();
			if (lstAgenda.size() > 0){	
				Iterator<VOAgenda> iterAgenda = lstAgenda.iterator();
				while (iterAgenda.hasNext()){
					VOAgenda dataAgenda= iterAgenda.next();
									
					Object[] fila = new Object[5];
					fila[0] = dataAgenda.getNombre();
					fila[1] = dataAgenda.getCedula();
					fila[2] = dataAgenda.getTel();
					fila[3] = dataAgenda.getImg();
					
					
			
			modelo.addRow(fila);
			
			tablaAgenda = new JTable(modelo);		
			scrollPane.setViewportView(tablaAgenda);
				
		}

	}
		
			//----------------- toma los valores de la tabla -------------------------------//
			
			tablaAgenda.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

				@Override
				public void valueChanged(ListSelectionEvent e){
				if(tablaAgenda.getSelectedRow() !=-1){
					
				int fila = tablaAgenda.getSelectedRow();
				
				textFieldNombre.setText(tablaAgenda.getValueAt(fila,0).toString());
				textFieldCedula.setText(tablaAgenda.getValueAt(fila,1).toString());
				textFieldTelefono.setText(tablaAgenda.getValueAt(fila,2).toString());
				textFieldSeleccion.setText(tablaAgenda.getValueAt(fila,3).toString());
				
													  }
															  }
			});
			
			//---------------------------------------------------------------------------------
			
			  GhostText ghostText = new GhostText(textFieldNombre, "Ej. Juan ...");
		       textFieldNombre.setPreferredSize(new Dimension(300, 24));
		       
		       GhostText ghostText2 = new GhostText(textFieldCedula, "Ej. 123456789...");
		       textFieldCedula.setPreferredSize(new Dimension(300, 24));
		       
		       GhostText ghostText3 = new GhostText(textFieldTelefono, "095001002...");
		       textFieldTelefono.setPreferredSize(new Dimension(300, 24));
		       
		       GhostText ghostText4 = new GhostText(textFieldSeleccion, "C://Img ...");
		       textFieldSeleccion.setPreferredSize(new Dimension(300, 24));
		       
		       JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		       tabbedPane.setBounds(811, 25, 269, 242);
		       contentPane.add(tabbedPane);
		       
		       JPanel panel_3 = new JPanel();
		       panel_3.setLayout(null);
		       panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		       panel_3.setBackground(new Color(255, 192, 203));
		       tabbedPane.addTab("Resumen PDF", null, panel_3, null);
		       
		       TextArea textArea = new TextArea();
		       textArea.setBounds(10, 53, 244, 100);
		       panel_3.add(textArea);
		       
		       textFieldBuscarRutaPdf = new JTextField();
		       textFieldBuscarRutaPdf.setColumns(10);
		       textFieldBuscarRutaPdf.setBounds(10, 27, 135, 20);
		       panel_3.add(textFieldBuscarRutaPdf);
		       
		       JButton btnBuscarRutaPdf = new JButton("Buscar");
		       btnBuscarRutaPdf.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent e) {
		       		
		       		// ************************** BUSCA RUTA PARA GUARDAR Y GENERAR PDF ***************//
					
					JFileChooser dlg= new JFileChooser();
					int option = dlg.showSaveDialog(btnBuscarRutaPdf);
					if (option == JFileChooser.APPROVE_OPTION) {
					File f=dlg.getSelectedFile();
					textFieldBuscarRutaPdf.setText(f.toString());
					}
		       		
		       		
		       	}
		       });
		       btnBuscarRutaPdf.setBounds(165, 26, 89, 23);
		       panel_3.add(btnBuscarRutaPdf);
		       
		       JButton btnGenerarArchivoPdf = new JButton("Generar");
		       btnGenerarArchivoPdf.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent e) {
		       		
		       	// ------------------------GENERO EL PDF ----------------------//
					
					String ruta = textFieldBuscarRutaPdf.getText();
					String contenido = textArea.getText();
			

					try{
						
						if(ruta!=("")||ruta!=null){
						FileOutputStream archivo = new FileOutputStream(ruta+".pdf");
						Document doc = new Document(); 
						
						PdfWriter.getInstance(doc, archivo);
						doc.open();
						doc.add(new Paragraph (contenido));
						
						doc.close();
						
						JOptionPane.showMessageDialog(null, "PDF Creado Correctamente", "Estudiantes Ametrano 2016", JOptionPane.ERROR_MESSAGE, imgUy);
						
						}else{
							JOptionPane.showMessageDialog(null, "Debes seleccionar una ruta y escribir el nombre del archivo\n Recuerda escribir el nombre del archivo sin la extensión dado que ya la tiene", "Estudiantes Ametrano 2016", JOptionPane.ERROR_MESSAGE, imgUy);
						}

					} catch (Exception error){
						JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Estudiantes Ametrano 2016", JOptionPane.ERROR_MESSAGE, imgUy);
					}
		       		
		       		
		       		
		       	}
		       });
		       btnGenerarArchivoPdf.setBounds(165, 169, 89, 23);
		       panel_3.add(btnGenerarArchivoPdf);
		       
		       JPanel panel_4 = new JPanel();
		       panel_4.setBackground(new Color(255, 192, 203));
		       tabbedPane.addTab("Resumen Imprimir", null, panel_4, null);
		       panel_4.setLayout(null);
		       
		       JButton btnGenerarReporte = new JButton("Generar Reporte");
		       btnGenerarReporte.addActionListener(new ActionListener() {
		       	public void actionPerformed(ActionEvent e) {
		       		
		       		
		       		textArea.setText("\tDATOS PERSONALES :\t -Relevamiento:"+fecha+"\n\n"
							+ "\t"+"- Nombre: "+textFieldNombre.getText()+"\n"
							+ "\t"+"- Telefono: "+textFieldCedula.getText()+"\n"
							+ "\t"+"- Cedula: "+textFieldTelefono.getText()+"\n");
							
		       		
		       		
		       		
		       	}
		       });
		       btnGenerarReporte.setBounds(200, 277, 169, 23);
		       contentPane.add(btnGenerarReporte);
		       
		       JFrame frame = new JFrame("Prueba de texto gris");
		       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       
			
			
			

	}
}
