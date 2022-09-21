package com.registronacional.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.registronacional.core.facade.RegistroFacade;
import com.registronacional.request.firmaestandar.Registro;
import com.registronacional.response.Response;

@RestController
@RequestMapping("/api/v1")
public class RegistroControlador {
	
	@Autowired
	private RegistroFacade registroFacade;
	
	
	
	@PostMapping("/registroNacional")
	private ResponseEntity<Response> altaRegistroNacional(@RequestBody Registro registro){
		ResponseEntity<Response> response = null;
		try {
			response = new ResponseEntity<>( registroFacade.altaDeRegistroNacional(registro), HttpStatus.OK); 
		}catch(HttpStatusCodeException e) {
			
			if(e.getRawStatusCode() == 400) {
				response = new ResponseEntity<>( registroFacade.altaDeRegistroNacional(registro), HttpStatus.BAD_REQUEST); 
			}
			if(e.getRawStatusCode() == 404) {
				response = new ResponseEntity<>( registroFacade.altaDeRegistroNacional(registro), HttpStatus.NOT_FOUND); 
			}
			if(e.getRawStatusCode() == 500) {
				response = new ResponseEntity<>( registroFacade.altaDeRegistroNacional(registro), HttpStatus.INTERNAL_SERVER_ERROR); 
			} 
		}
		return response;
	}
	
	

}
