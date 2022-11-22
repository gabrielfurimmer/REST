package com.webservice.rest.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.webservice.rest.VO.VOAuto;


//Definiendo el servicio rest
@Path("/JavaGabriel")
public class ColorAutos {

	
	//Metodo validar si el color esta permitido para el auto
	@POST
	@Path("/validarColorAuto")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOAuto validaColorAuto(VOAuto vo) {
		vo.setColorPermitido(false);
		ArrayList<String> marcasAutos = new ArrayList<String>();
		marcasAutos.add("BMW");
		marcasAutos.add("Porsche");
		marcasAutos.add("Honda");
		ArrayList<String> coloresAutos = new ArrayList<String>();
		coloresAutos.add("azul");
		coloresAutos.add("rojo");
		coloresAutos.add("verde");
		if(marcasAutos.stream().anyMatch(vo.getAuto()::equalsIgnoreCase) && coloresAutos.stream().anyMatch(vo.getColor()::equalsIgnoreCase)) {
			vo.setColorPermitido(true);			
		}
		return vo;
	}
}