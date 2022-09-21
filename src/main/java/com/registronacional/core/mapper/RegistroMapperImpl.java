package com.registronacional.core.mapper;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.registronacional.core.service.RegistroService; 
import com.registronacional.request.firmaestandar.Educacion;
import com.registronacional.request.firmaestandar.Registro;
import com.registronacional.request.legado.EstudiosSuperiores;
import com.registronacional.request.legado.Legacy;
import com.registronacional.response.Response;

@Component
public class RegistroMapperImpl implements RegistroMapper {

	@Autowired
	private RegistroService registroService;
	
	@Override
	public Response altaRegistroMapper(Registro registro) {
		 Response response = null;
		 
		 try {
			 
			 //mapeo firma estandar hacia legado: 
			 Legacy legacy = new Legacy();
			 legacy.setId(registro.getId() != null ? registro.getId() : null);
			 legacy.setNombres(registro.getNombres() != null ? registro.getNombres() : null);
			 legacy.setApellidos(registro.getApellidos() != null ? registro.getApellidos() : null);
			 legacy.setDireccion(registro.getDireccion() != null ? registro.getDireccion() : null);
			 legacy.setDui(registro.getContactos().get(0).getDui() != null ? registro.getContactos().get(0).getDui() : null);
			 legacy.setNit(registro.getContactos().get(0).getNit() != null ? registro.getContactos().get(0).getNit() : null);
			 legacy.setTelefonos(registro.getContactos().get(0).getTelefonos() != null ? registro.getContactos().get(0).getTelefonos() : null);
			 
			 //Validacion si/no , mapear con una clase ENUM
			 String estudios = registro.getContactos().get(0).getEstudiosSuperiores();
			 if(estudios== null || estudios.isEmpty() ) {
				 legacy.setEstudiosSuperiores(EstudiosSuperiores.NO);
			 }
			 if(estudios.equalsIgnoreCase("si")) {
				 legacy.setEstudiosSuperiores(EstudiosSuperiores.SI);
			 }
			 if(estudios.equalsIgnoreCase("no")) {
				 legacy.setEstudiosSuperiores(EstudiosSuperiores.NO); 
			 }
			 
			 
			 
			 // recorriendo clave valor de un MAPA en java de la clase: Educacion. 
			 if( Objects.nonNull(  registro.getEducacion()  )  ) {
				 
				 List<Educacion> educacion =  registro.getEducacion();
				 List<Educacion> univ =  educacion.stream()
						                 .filter(universidad -> "universidad".equals(universidad.getKey()  ))
						                 .collect(Collectors.toList()); 
				 legacy.setUniversidad( univ.get(0).getValue()  );
				 
				 
				 
				 
				 List<Educacion> bachillerato = educacion.stream()
	                        .filter(bach -> "bachillerato".equals(bach.getKey()) )
	                        .collect(Collectors.toList());
                 legacy.setBachillerato(bachillerato.get(0).getValue());  
			 }
			  
			 
			 legacy.setLugarDeTrabajo(registro.getLugarDeTrabajo() != null ? registro.getLugarDeTrabajo() : null); 
			 
			 //System.out.println(legacy);
			 response = registroService.alta(legacy);
			 
			    response.setIdTransaccion(UUID.randomUUID().toString());
				response.setEstado("Los datos han sido enviados");
				response.setMensaje("");
			 
			} catch (HttpClientErrorException e) {

				if (e.getRawStatusCode() == 400) {
					response.setIdTransaccion(UUID.randomUUID().toString());
					response.setEstado("A ocurrido un error, revisar request");
					response.setMensaje("bad request");
				}
				if (e.getRawStatusCode() == 500) {
					response.setIdTransaccion(UUID.randomUUID().toString());
					response.setEstado("A ocurrido un error, revisar la logica del negocio");
					response.setMensaje(" 500 error internal");
				}

			} catch(Exception e) {
			    response.setIdTransaccion(UUID.randomUUID().toString());
				response.setEstado("A ocurrido un error");
				response.setMensaje(e.getMessage());
		 } 
		return response;
	}

}
