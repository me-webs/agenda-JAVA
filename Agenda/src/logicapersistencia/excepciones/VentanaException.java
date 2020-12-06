package logicapersistencia.excepciones;

@SuppressWarnings("serial")
public class VentanaException extends Exception {	
	static final public String INGRESO_EXITOSO = "Se ha ingresado los datos con exito. Acá estoy en la ventana de excepciones";
	
	
	public VentanaException(String _msg) {
		super(_msg);
	}

}

