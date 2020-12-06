package grafica.controladores;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;

import logicapersistencia.fachada.Fachada;

public class ControladorAltaDatosAgenda {

		public void nuevosDatos(String nombre, String cedula, String tel, String nom_Img, InputStream nom_Img2 ) throws SQLException{
			Fachada f= new Fachada();
			f.nuevosDatos(nombre, cedula, tel, nom_Img, nom_Img2);
		}
}


