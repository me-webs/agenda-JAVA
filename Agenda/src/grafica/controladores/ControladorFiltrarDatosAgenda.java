package grafica.controladores;

import java.util.List;

import logicapersistencia.accesoBD.AccesoBD;
import logicapersistencia.valueObjects.VOAgenda;


public class ControladorFiltrarDatosAgenda {
	
	public List<VOAgenda> filtrarListarNombreAgenda() {
		AccesoBD a = new AccesoBD();
		return a.filtrarListarNombreAgenda();
	}

}
