package com.registronacional.response;

public class Response {
	
	private String idTransaccion;
	private String estado;
	private String mensaje;
	
	public Response(String idTransaccion, String estado, String mensaje) {
		super();
		this.idTransaccion = idTransaccion;
		this.estado = estado;
		this.mensaje = mensaje;
	}

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Response [idTransaccion=");
		builder.append(idTransaccion);
		builder.append(", estado=");
		builder.append(estado);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append("]");
		return builder.toString();
	}
	
	 

}
