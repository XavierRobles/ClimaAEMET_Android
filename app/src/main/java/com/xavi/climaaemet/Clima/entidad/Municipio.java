package com.xavi.climaaemet.Clima.entidad;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(strict = false)
public class Municipio {
	@Element(name="nm")
	private String nombre;
	@Element
	private Loine loine;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Loine getLoine() {
		return loine;
	}

	public void setLoine(Loine loine) {
		this.loine = loine;
	}

	@Override
	public String toString() {
		return "Municipio: " + nombre;
	}
	
}
