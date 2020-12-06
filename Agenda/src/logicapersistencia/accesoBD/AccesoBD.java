package logicapersistencia.accesoBD;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
	import java.sql.Date;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.text.DateFormat;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Properties;

import javax.swing.JOptionPane;

import java.sql.Blob;

import logicapersistencia.valueObjects.VOAgenda;





	public class AccesoBD {
		private String driver;
		private String username;
		private String pass;
		private String url;
		private String base;
		
		public Connection conectarBD() {
			// Cargo los datos desde el archivo de configuracion y conecto al servidor de BD
			Connection con = null;
			try
			{
				Properties p = new Properties();		
				try {
					p.load(new FileInputStream("config/parametros.txt"));
				} catch (FileNotFoundException e) {			
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}		
				driver = p.getProperty("driver");
				username = p.getProperty("usuario");
				pass = p.getProperty("password");
				url = p.getProperty("url");
				base = p.getProperty("bdatos");
				Class.forName(driver);
		
				con = DriverManager.getConnection(url + base, username, pass);
		
			}catch (ClassNotFoundException e){
				e.printStackTrace();
			}
			catch (SQLException e){
				e.printStackTrace();
			}	
		return con;
		}
		
		public void desconectarBD(Connection con){
			try {
				con.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}
		}
		
		
		
		public void nuevosDatos(String nombre, String cedula,String tel, String nom_Img, InputStream img ) throws SQLException{
			// Ingresa una nueva actividad al sistema
				FileInputStream archivoFoto;
			
				Connection con = this.conectarBD();	
				Consultas consultas = new Consultas();
				String insert = consultas.nuevosDatos();	
				PreparedStatement pstmt;
				pstmt = con.prepareStatement(insert);
				pstmt.setString(1, nombre);
				pstmt.setString(2, cedula);
				pstmt.setString(3, tel);
				pstmt.setString(4, nom_Img);
				
				try {
					

					pstmt.setBlob(5, img);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ha ocurrido el siguiente erro:\n"+e);
				}
				
				
				pstmt.executeUpdate ();			
				pstmt.close();	
				
				this.desconectarBD(con);
				
				
				
			}

		public List<VOAgenda> listarDatosPersonas() {
			
				//devuelve un listado de todos los nombres 	
				Connection con = null;
				con = this.conectarBD();
				VOAgenda datos2 = null;
				List<VOAgenda> lstDato = null;
				/* creo un Statement para listar todas los datos de las personas */
				Statement stmt;
				try {
					stmt = con.createStatement();
					Consultas consultas = new Consultas();
					String strDato = consultas.listarDatosPersonas();
					ResultSet rs = stmt.executeQuery(strDato);
					lstDato = new ArrayList<VOAgenda>();
					while (rs.next()) {
						datos2 = new VOAgenda(rs.getString("nom"), rs.getString("ci"), rs.getString("tel"), rs.getString("nom_Img"), rs.getBinaryStream("img"));
						lstDato.add(datos2);
					}
					rs.close();
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.desconectarBD(con);
			
			return lstDato;
		}


		
		
		public void actualizarlistarDatosPersonas(String nombre, String cedula,String tel, String img, String nom_Img) throws SQLException{
			// Ingresa una nueva actividad al sistema
//				Connection con = this.conectarBD();	
//				Consultas consultas = new Consultas();
//				String insert = consultas.actualizarlistarDatosPersonas();	
//				PreparedStatement pstmt;
//				pstmt = con.prepareStatement(insert);
//				pstmt.setString(1, nombre);
//				pstmt.setString(2, cedula);
//				pstmt.setString(3, tel);		
//				pstmt.executeUpdate ();			
//				pstmt.close();	
//				this.desconectarBD(con);
				
				
			}

		public void borrarDatosPersonas(String cedulaBorrar) throws SQLException{
			// Borra del sistema
			Connection con = this.conectarBD();	
			Consultas consultas = new Consultas();
			String borrar = consultas.borrarDatosPersonas();	
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(borrar);
			pstmt.setString(1, cedulaBorrar);
			pstmt.executeUpdate ();			
			pstmt.close();					
			this.desconectarBD(con);
		
			
		}

		public List<VOAgenda> filtrarListarNombreAgenda() {
			//devuelve un listado de todos los nombres de los pacientes		
			Connection con = null;
			con = this.conectarBD();
			VOAgenda paciente = null;
			List<VOAgenda> personas = null;
			/* creo un Statement para listar todas  */
			Statement stmt;
			try {
				stmt = con.createStatement();
				Consultas consultas = new Consultas();
				String strSocios = consultas.listarAgendaFiltro();
				ResultSet rs = stmt.executeQuery(strSocios);
				personas = new ArrayList<VOAgenda>();
				while (rs.next()) {
					paciente = new VOAgenda(rs.getString("nom"), rs.getString("ci"), rs.getString("tel"), rs.getString("nom_Img"), rs.getBinaryStream("img"));
					personas.add(paciente);
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.desconectarBD(con);
			return personas;
			
		}

		
	

}
