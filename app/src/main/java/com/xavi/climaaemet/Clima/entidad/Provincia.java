package com.xavi.climaaemet.Clima.entidad;

import org.simpleframework.xml.Element;

public class Provincia {
	@Element
	private String np;
	@Element
	private String cpine;

	public String getNp() {
		return np;
	}

	public void setNp(String np) {
		this.np = np;
	}

	public String getCpine() {
		return cpine;
	}

	public void setCpine(String cpine) {
		this.cpine = cpine;
	}

	@Override
	public String toString() {
		return "Provincia: "+ np;
	}

}
