package logicapersistencia.valueObjects;

import java.io.InputStream;

public class VOAgenda {
	
	private String nombre;
	private String cedula;
	private String tel;
	private String nom_Img;
	private InputStream img;
	public VOAgenda(String nombre, String cedula, String tel, String nom_Img, InputStream img) {
		super();
		this.nombre = nombre;
		this.cedula = cedula;
		this.tel = tel;
		this.nom_Img = nom_Img;
		this.img = img;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNom_Img() {
		return nom_Img;
	}
	public void setNom_Img(String nom_Img) {
		this.nom_Img = nom_Img;
	}
	public InputStream getImg() {
		return img;
	}
	public void setImg(InputStream img) {
		this.img = img;
	}
	
	

}
