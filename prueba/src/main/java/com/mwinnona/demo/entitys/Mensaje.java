package com.mwinnona.demo.entitys;

import java.io.Serializable;

import javax.persistence.Id;

public class Mensaje implements Serializable{
	private String mensajeRespuesta;
	@Id
	private int codigoRespuesta;
	
	
	
	public Mensaje() {
		// TODO Auto-generated constructor stub
	}
	public Mensaje(String mensajeRespuesta, int codigoRespuesta) {
		super();
		this.mensajeRespuesta = mensajeRespuesta;
		this.codigoRespuesta = codigoRespuesta;
	}
	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}
	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}
	public int getCodigoRespuesta() {
		return codigoRespuesta;
	}
	public void setCodigoRespuesta(int codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}
	
	private static final long serialVersionUID = 1L;
	
	
}
