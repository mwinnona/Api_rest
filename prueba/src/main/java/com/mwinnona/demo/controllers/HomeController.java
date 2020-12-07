package com.mwinnona.demo.controllers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mwinnona.demo.entitys.Empleado;
import com.mwinnona.demo.entitys.Mensaje;
import ch.qos.logback.core.boolex.Matcher;

@RestController
@RequestMapping("/talentfestapi")
class HomeController {
	
	@RequestMapping(value="empleados", method=RequestMethod.POST)
	public ResponseEntity<Mensaje> getEmpleado(@RequestBody Empleado empleado){
		String codigo= Integer.toString(empleado.getCodigo());
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("^[\\w]+@{1}[\\w]+\\.+[a-z]{2,3}$");
		java.util.regex.Matcher matcher = pattern.matcher(empleado.getCorreo());	
		int validado = 0;
		String error="";
		if(matcher.find() == true) {
			validado= validado+1;
		}else {
			error= " debio a correo inválido";
		}
		
		if(empleado.getCategoria().equalsIgnoreCase("A") ||  empleado.getCategoria().equalsIgnoreCase("B") || empleado.getCategoria().equalsIgnoreCase("c")) {
			validado= validado+1;
		}else {
			error =" debido a categoria inexistente";
		}
		
		Mensaje mensaje = new Mensaje();
		if(validado==2) {
			mensaje.setMensajeRespuesta("Se registró correctamente el empleado ".concat(codigo));
			return ResponseEntity.ok(mensaje);
		}else {
			mensaje.setMensajeRespuesta("No Se registró correctamente el empleado ".concat(codigo).concat(error));
			return ResponseEntity.ok(mensaje);
		}
	}
	

	@RequestMapping(value="empleados", method=RequestMethod.GET)
	public ResponseEntity<Empleado> mostrarEmpleado() {
		Empleado empleado = new Empleado();
		empleado.setCodigo(1001);
		empleado.setNombre("Hector");
		empleado.setApellidoPaterno("Pinedo");
		empleado.setApellidoMaterno("Girón");
		empleado.setFechaNacimiento("1994-09-29");
		empleado.setCorreo("sshector.294@gmail.com");
		empleado.setCategoria("B");
		return ResponseEntity.ok(empleado);
	}
}
