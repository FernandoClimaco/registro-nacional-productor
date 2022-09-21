package com.registronacional.request.firmaestandar;
import java.util.ArrayList;

public class Registro{
    public String id;
    public String nombres;
    public String apellidos;
    public String direccion;
    public ArrayList<Contacto> contactos;
    public ArrayList<Educacion> educacion;
    public String lugarDeTrabajo;
    
	public Registro(String id, String nombres, String apellidos, String direccion, ArrayList<Contacto> contactos,
			ArrayList<Educacion> educacion, String lugarDeTrabajo) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.contactos = contactos;
		this.educacion = educacion;
		this.lugarDeTrabajo = lugarDeTrabajo;
	}

	public Registro() {
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

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	public ArrayList<Educacion> getEducacion() {
		return educacion;
	}

	public void setEducacion(ArrayList<Educacion> educacion) {
		this.educacion = educacion;
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
		builder.append("Registro [id=");
		builder.append(id);
		builder.append(", nombres=");
		builder.append(nombres);
		builder.append(", apellidos=");
		builder.append(apellidos);
		builder.append(", direccion=");
		builder.append(direccion);
		builder.append(", contactos=");
		builder.append(contactos);
		builder.append(", educacion=");
		builder.append(educacion);
		builder.append(", lugarDeTrabajo=");
		builder.append(lugarDeTrabajo);
		builder.append("]");
		return builder.toString();
	}
    
    
    
    
}
