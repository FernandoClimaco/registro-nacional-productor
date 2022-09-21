package com.registronacional.core.facade;


import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.registronacional.core.mapper.RegistroMapper;
import com.registronacional.request.firmaestandar.Registro;
import com.registronacional.response.Response;

@Component
public class RegistroFacadeImpl implements RegistroFacade {

	@Autowired
	private RegistroMapper registroMapper;
	
	@Override
	public Response altaDeRegistroNacional(Registro registro) {
		Response response = null;
		try {

			if (Objects.nonNull(registro)) {

				if (registro.getId() == null || registro.getId().isEmpty() || registro.getId().equalsIgnoreCase(" ")) {
					// excepcion personalizada
				}
				if (registro.getNombres() == null || registro.getNombres().isEmpty()
						|| registro.getNombres().equals(" ")) {
					// Excepcion personalizada
				}

				response = registroMapper.altaRegistroMapper(registro);

			}
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

		} catch (Exception e) {
			response.setIdTransaccion(UUID.randomUUID().toString());
			response.setEstado("A ocurrido un error");
			response.setMensaje(e.getMessage());
		}
		return response;
	}

	

	 

}
