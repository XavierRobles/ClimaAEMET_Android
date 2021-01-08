package com.xavi.climaaemet.Clima.entidad;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(strict = false)
public class Loine {
	@Element(name="cm")
	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Loine [codigo=" + codigo + "]";
	}
	
	
	
}
