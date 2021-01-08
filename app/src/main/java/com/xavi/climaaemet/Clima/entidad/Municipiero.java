package com.xavi.climaaemet.Clima.entidad;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "consulta_municipiero", strict = false)
public class Municipiero {
	@ElementList(name="municipiero")
	private List<Municipio> lista_municipios;

	public List<Municipio> getLista_municipios() {
		return lista_municipios;
	}

	public void setLista_municipios(List<Municipio> lista_municipios) {
		this.lista_municipios = lista_municipios;
	}

	@Override
	public String toString() {
		return "Municipiero [lista_municipios=" + lista_municipios + "]";
	}
	
	

}
