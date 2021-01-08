package com.xavi.climaaemet.Clima.recursos;



import com.xavi.climaaemet.Clima.entidad.ClimaAEMET;
import com.xavi.climaaemet.Clima.entidad.Municipiero;
import com.xavi.climaaemet.Clima.entidad.Provinciero;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServicioPedirDatos {

	// https://www.aemet.es/xml/municipios/localidad_28079.xml
	@GET("ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaProvincia")
	Call<Provinciero> pedirProvincias();

	@GET("ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaMunicipio")
	Call<Municipiero> pedirMunicipios(@Query("Provincia") String provincia, @Query("Municipio") String municipio);

	@GET("xml/municipios/localidad_{codigo}.xml")
	Call<ClimaAEMET> pedirClimaAEMET(@Path("codigo") String codigo);
	
}
