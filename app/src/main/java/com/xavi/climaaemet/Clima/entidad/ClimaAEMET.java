package com.xavi.climaaemet.Clima.entidad;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "root", strict = false)
public class ClimaAEMET {
	@ElementList
	private List<Dia> prediccion;
	
	public List<Dia> getPrediccion() {
		return prediccion;
	}

	public void setPrediccion(List<Dia> prediccion) {
		this.prediccion = prediccion;
	}

	@Override
	public String toString() {
		return "ClimaAEMET Prediccion:" + prediccion;
	}

}
