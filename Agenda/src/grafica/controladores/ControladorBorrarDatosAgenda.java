package grafica.controladores;

import java.sql.SQLException;

import logicapersistencia.fachada.Fachada;

public class ControladorBorrarDatosAgenda {
	
	public void borrarDatosPersonas(String cedulaBorrar) throws SQLException{
		Fachada f = new Fachada();
		f.borrarDatosPersonas(cedulaBorrar);
	}

}
