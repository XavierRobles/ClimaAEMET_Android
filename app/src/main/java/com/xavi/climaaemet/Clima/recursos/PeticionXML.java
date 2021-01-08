package com.xavi.climaaemet.Clima.recursos;

import android.util.Log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xavi.climaaemet.Clima.entidad.ClimaAEMET;
import com.xavi.climaaemet.Clima.entidad.Dia;
import com.xavi.climaaemet.Clima.entidad.Municipiero;
import com.xavi.climaaemet.Clima.entidad.Municipio;
import com.xavi.climaaemet.Clima.entidad.Provincia;
import com.xavi.climaaemet.Clima.entidad.Provinciero;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PeticionXML {
	
	public static void pedirProvincias(ActualizacionDatos llamante) {
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("http://ovc.catastro.meh.es/")
			    .addConverterFactory(SimpleXmlConverterFactory.create())
			    .build();

			ServicioPedirDatos service = retrofit.create(ServicioPedirDatos.class);
			
			
			
			Call<Provinciero> llamada = service.pedirProvincias();
			llamada.enqueue(new Callback<Provinciero>(){

				@Override
				public void onResponse(Call<Provinciero> call, retrofit2.Response<Provinciero> response) {
					HashMap<String, String> mapa_provincias = new HashMap<String, String>();
					
					
					Provinciero p = response.body();
					List<Provincia> lista_provincia =p.getProvinciero();
					for (Provincia provincia : lista_provincia) {
						
						mapa_provincias.put(provincia.getCpine(), provincia.getNp());
					}
					llamante.mostrarProvincias(mapa_provincias);
				}

				@Override
				public void onFailure(Call<Provinciero> call, Throwable t) {
					System.out.println("Error"+ t.getMessage());					
				}
				
			});		
		
	}
	
	public static void pedirMunicipios(ActualizacionDatos m, String nombre_provincia) {
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("http://ovc.catastro.meh.es/")
			    .addConverterFactory(SimpleXmlConverterFactory.create())
			    .build();

			ServicioPedirDatos service = retrofit.create(ServicioPedirDatos.class);
			
			Call<Municipiero> llamada_municipios = service.pedirMunicipios(nombre_provincia, "");
			llamada_municipios.enqueue(new Callback<Municipiero>() {

				@Override
				public void onResponse(Call<Municipiero> call, retrofit2.Response<Municipiero> response) {
					m.mostrarMunicipios(response.body());


					
				}

				@Override
				public void onFailure(Call<Municipiero> call, Throwable t) {

					System.out.println("Error"+ t.getMessage());
				}
			});
		
	}
	
	public static void pedirClima(String codigo_AEMET, ActualizacionDatos llamante_clima) {
		
		Retrofit retrofit = new Retrofit.Builder()
			    .baseUrl("http://www.aemet.es/")
			    .addConverterFactory(SimpleXmlConverterFactory.create())
			    .build();

			ServicioPedirDatos service = retrofit.create(ServicioPedirDatos.class);
			Call<ClimaAEMET> llamada_clima = service.pedirClimaAEMET(codigo_AEMET);
			llamada_clima.enqueue(new Callback<ClimaAEMET>(){

				@Override
				public void onResponse(Call<ClimaAEMET> call, retrofit2.Response<ClimaAEMET> response) {
					//System.out.println(response.body());



					ClimaAEMET l = response.body();
					List<Dia> municipio = l.getPrediccion();
					llamante_clima.mostrarClima(l);



					
				}

				@Override
				public void onFailure(Call<ClimaAEMET> call, Throwable t) {

					System.out.println("Error "+t.getMessage());
				}
				
			});
	}
	public interface ActualizacionDatos{
		
		public void mostrarProvincias(Map<String, String> lista_provincias);
		public void mostrarMunicipios(Municipiero m);
		public void mostrarClima(ClimaAEMET clima);
		
		
		
		
	}

}
