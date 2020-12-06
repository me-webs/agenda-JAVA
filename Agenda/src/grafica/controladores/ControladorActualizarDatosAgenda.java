package grafica.controladores;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import logicapersistencia.fachada.Fachada;
import logicapersistencia.valueObjects.VOAgenda;

public class ControladorActualizarDatosAgenda {
	
	public void actualizarlistarDatosPersonas(String nombre, String cedula, String tel, String nom_Img, InputStream img) throws SQLException{
		Fachada f= new Fachada();
		f.nuevosDatos(nombre, cedula, tel, nom_Img, img);
	}
		

}
