package com.xavi.climaaemet.Clima.entidad;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "consulta_provinciero", strict = false)
public class Provinciero {
	@ElementList
	private List<Provincia> provinciero;

	public List<Provincia> getProvinciero() {
		return provinciero;
	}

	public void setProvinciero(List<Provincia> provinciero) {
		this.provinciero = provinciero;
	}

	@Override
	public String toString() {
		return "Provinciero [provinciero=" + provinciero + "]";
	}

}
