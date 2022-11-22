package com.webservice.rest.service;

import com.webservice.rest.VO.VOAuto;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;


public class ClienteRestGabriel {
	
	public static void main(String[] args) {
		
		//Creacion del usuario que vamos a validar
		String urlService = "http://localhost:8081/REST/services/JavaGabriel/validarColorAuto";
		VOAuto vo = new VOAuto();
		vo.setAuto("BMW");
		vo.setColor("negro");
		vo.setColorPermitido(false);
		
		System.out.println("Invocando el servicio: " + urlService);
		System.out.println("Parametros= Auto: " + vo.getAuto() + " , Color: " + vo.getColor());
		
		//Configuracion del cliente para convertir objeto a JSON
		ClientConfig consumoServicio = new DefaultClientConfig();
		consumoServicio.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		//Cliente
		Client cliente = Client.create(consumoServicio);
		//Ubicacion de nuestro servicio
		WebResource webResource = cliente.resource("http://localhost:8081/REST/services/JavaGabriel/validarColorAuto");
		//Lo que responde nuestro servicio
		ClientResponse respuesta = webResource.type("application/json").post(ClientResponse.class, vo);
		// Recuperamos nuestro VO
		vo = respuesta.getEntity(VOAuto.class);
		
		//Comprobacion de nuestra informacion
		System.out.println("---Respuesta: Usuario = " + vo.getAuto());
		System.out.println("---Respuesta: El Color esta permitido = " + vo.isColorPermitido());
	
	}

}
