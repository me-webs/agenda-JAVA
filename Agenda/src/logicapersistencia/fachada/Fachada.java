package logicapersistencia.fachada;


import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import logicapersistencia.accesoBD.AccesoBD;
import logicapersistencia.valueObjects.VOAgenda;



public class Fachada {
	
	public void nuevosDatos(String nombre, String cedula,String tel, String nom_Img, InputStream img ) throws SQLException{
		AccesoBD a = new AccesoBD();
		a.nuevosDatos(nombre, cedula, tel, nom_Img, img);
	}
	
	
	public List<VOAgenda> listarDatosPersonas(){
		AccesoBD a = new AccesoBD();
		return a.listarDatosPersonas();
	}
	
	
	public void actualizarlistarDatosPersonas(String nombre, String cedula,String tel, String nom_Img, String img) throws SQLException{
			AccesoBD a = new AccesoBD();
			a.actualizarlistarDatosPersonas(nombre, cedula, tel, nom_Img, img);
		}
	
	public void borrarDatosPersonas(String cedulaBorrar) throws SQLException{
		AccesoBD a = new AccesoBD();
		a.borrarDatosPersonas(cedulaBorrar);
	}
	
	

}
