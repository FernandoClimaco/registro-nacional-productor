package com.registronacional.request.legado;

public class Legacy {
	
	private String id;
	private String nombres;
	private String apellidos;
	private String direccion;
	private String dui;
	private String nit;
	private String telefonos;
	private EstudiosSuperiores estudiosSuperiores; 
	private String universidad;
	private String bachillerato;
	private String lugarDeTrabajo;
	
	public Legacy(String id, String nombres, String apellidos, String direccion, String dui, String nit,
			String telefonos, EstudiosSuperiores estudiosSuperiores, String universidad, String bachillerato,
			String lugarDeTrabajo) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.dui = dui;
		this.nit = nit;
		this.telefonos = telefonos;
		this.estudiosSuperiores = estudiosSuperiores;
		this.universidad = universidad;
		this.bachillerato = bachillerato;
		this.lugarDeTrabajo = lugarDeTrabajo;
	}

	public Legacy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public EstudiosSuperiores getEstudiosSuperiores() {
		return estudiosSuperiores;
	}

	public void setEstudiosSuperiores(EstudiosSuperiores estudiosSuperiores) {
		this.estudiosSuperiores = estudiosSuperiores;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public String getBachillerato() {
		return bachillerato;
	}

	public void setBachillerato(String bachillerato) {
		this.bachillerato = bachillerato;
	}

	public String getLugarDeTrabajo() {
		return lugarDeTrabajo;
	}

	public void setLugarDeTrabajo(String lugarDeTrabajo) {
		this.lugarDeTrabajo = lugarDeTrabajo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Legacy [id=");
		builder.append(id);
		builder.append(", nombres=");
		builder.append(nombres);
		builder.append(", apellidos=");
		builder.append(apellidos);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", dui=");
		builder.append(dui);
		builder.append(", nit=");
		builder.append(nit);
		builder.append(", telefonos=");
		builder.append(telefonos);
		builder.append(", estudiosSuperiores=");
		builder.append(estudiosSuperiores);
		builder.append(", universidad=");
		builder.append(universidad);
		builder.append(", bachillerato=");
		builder.append(bachillerato);
		builder.append(", lugarDeTrabajo=");
		builder.append(lugarDeTrabajo);
		builder.append("]");
		return builder.toString();
	}
	
	

}
