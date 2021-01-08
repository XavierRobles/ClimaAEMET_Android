package com.xavi.climaaemet.Clima.entidad;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Dia {

	@Attribute
	private String fecha;
	@Element
	private Temperatura temperatura;

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Temperatura getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "Dia: "+ fecha + ", "+ temperatura;
	}

}
