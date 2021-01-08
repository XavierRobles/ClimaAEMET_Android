package com.xavi.climaaemet.Clima.recursos;

import com.xavi.climaaemet.Clima.entidad.ClimaAEMET;
import com.xavi.climaaemet.Clima.entidad.Dia;

import java.util.List;

import com.xavi.climaaemet.Clima.entidad.ClimaAEMET;
import com.xavi.climaaemet.Clima.entidad.Dia;

public class PintarTablaHTML {

	public static String crearTabla(ClimaAEMET clima) {
		List<Dia> lista = clima.getPrediccion();
		String html="<table><tr><th>Fecha</th><th>Minima</th><th>Maxima</th></tr>";
		for (Dia d : lista) {
			html +="<tr><td>"+d.getFecha()+"</td><td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"+d.getTemperatura().getMinima()+"</td>"+
					"<td>&nbsp&nbsp&nbsp&nbsp&nbsp"+d.getTemperatura().getMaxima()+"</td></tr>";
			
		}
		html +="</table>";
		html="<html><head></head><body>" + html + "</body></html>";
		return html;
	}

}
