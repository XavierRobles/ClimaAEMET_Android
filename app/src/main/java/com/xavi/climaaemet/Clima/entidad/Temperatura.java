package com.xavi.climaaemet.Clima.entidad;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class Temperatura {
	@Element
	private int maxima;
	@Element
	private int minima;

	public int getMaxima() {
		return maxima;
	}

	public void setMaxima(int maxima) {
		this.maxima = maxima;
	}

	public int getMinima() {
		return minima;
	}

	public void setMinima(int minima) {
		this.minima = minima;
	}

	@Override
	public String toString() {
		return "Temperatura Maxima: " + maxima + ", Minima: " + minima;
	}

}
