package logicapersistencia.accesoBD;

public class Consultas {
	
	public String nuevosDatos(){
		String consulta = "INSERT INTO agenda (nom, ci, tel, nom_Img, img) VALUES (?,?,?,?,?);";
		return consulta;
	}

	public String listarDatosPersonas() {
				String consulta = "SELECT nom, ci, tel, nom_Img, img FROM agenda ORDER BY nom, ci, tel, nom_Img, img ";
		return consulta;
	}
	
	public String actualizarlistarDatosPersonas(){ // Ingresa los datos modificados
		String consulta = "UPDATE agenda set nom = ?, ci=?, tel=?, nom_Img=?, img=?";
		return consulta;
	}

	public String borrarDatosPersonas() {
			String consulta = "delete from agenda where ci = ?;";
			return consulta;
	}

	public String listarAgendaFiltro() {
		String consulta = "select nom, ci, tel from agenda";
		return consulta;
	}

}
