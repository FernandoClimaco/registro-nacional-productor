package com.registronacional.request.firmaestandar;

public class Contacto{
    public String dui;
    public String nit;
    public String telefonos;
    public String estudiosSuperiores;
	public Contacto(String dui, String nit, String telefonos, String estudiosSuperiores) {
		super();
		this.dui = dui;
		this.nit = nit;
		this.telefonos = telefonos;
		this.estudiosSuperiores = estudiosSuperiores;
	}
	public Contacto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDui() {
		return dui;
	}
	public void setDui(String dui) {
		this.dui = dui;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}
	public String getEstudiosSuperiores() {
		return estudiosSuperiores;
	}
	public void setEstudiosSuperiores(String estudiosSuperiores) {
		this.estudiosSuperiores = estudiosSuperiores;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contacto [dui=");
		builder.append(dui);
		builder.append(", nit=");
		builder.append(nit);
		builder.append(", telefonos=");
		builder.append(telefonos);
		builder.append(", estudiosSuperiores=");
		builder.append(estudiosSuperiores);
		builder.append("]");
		return builder.toString();
	}
    
    
    
    
}
