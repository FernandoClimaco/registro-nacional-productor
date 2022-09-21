package com.registronacional.core.service;

import java.util.UUID; 
import org.springframework.amqp.rabbit.core.RabbitTemplate; 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException; 
import com.registronacional.request.legado.Legacy;
import com.registronacional.response.Response;


@Service
public class RegistroServiceImpl implements RegistroService {
	
	private RabbitTemplate rabbitTemplate;
	   
	public RegistroServiceImpl(RabbitTemplate rabbitTemplate) { 
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@Value("${spring.rabbitmq.queue}")
    private String queue;
    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;
    @Value("${spring.rabbitmq.username}")
    private String username;
    @Value("${spring.rabbitmq.password}")
    private String password;
    @Value("${spring.rabbitmq.host}")
    private String host;
    @Value("${spring.rabbitmq.port}")
    private int port;
    
    
    
    public void send(Legacy legacy){
        rabbitTemplate.convertAndSend(exchange,routingKey, legacy);
    }






	@Override
	public Response alta(Legacy legacy) {
		Response response = new Response();
		
		try {
			
			rabbitTemplate.convertAndSend(exchange,routingKey, legacy);
			
			//amqpTemplate.convertAndSend("registroExchange", "registroQueue",legacy);
			
			response.setIdTransaccion(UUID.randomUUID().toString());
			response.setEstado("Los datos han sido enviados");
			response.setMensaje("");
			
			
		}catch (HttpClientErrorException e) {

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
