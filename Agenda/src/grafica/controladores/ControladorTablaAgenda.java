package grafica.controladores;

import java.sql.SQLException;
import java.util.List;

import logicapersistencia.fachada.Fachada;
import logicapersistencia.valueObjects.VOAgenda;

public class ControladorTablaAgenda {
	
	public List<VOAgenda> listarDatosPersonas(){
		Fachada f = new Fachada();
		return f.listarDatosPersonas();
	}

	


}
