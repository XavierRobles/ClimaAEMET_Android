package com.xavi.climaaemet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.xavi.climaaemet.Clima.entidad.ClimaAEMET;
import com.xavi.climaaemet.Clima.entidad.Municipiero;
import com.xavi.climaaemet.Clima.entidad.Municipio;
import com.xavi.climaaemet.Clima.entidad.Provincia;
import com.xavi.climaaemet.Clima.recursos.PeticionXML;
import com.xavi.climaaemet.Clima.recursos.PintarTablaHTML;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements PeticionXML.ActualizacionDatos {
    Spinner spn_provincias, spn_municipios;
    WebView web;
    Button solicitar;
    PeticionXML.ActualizacionDatos a = this;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.wv_html);
        solicitar = findViewById(R.id.bnt_solicitar);

        spn_provincias = findViewById(R.id.spn_provicias);
        spn_municipios = findViewById(R.id.spn_municipios);

        PeticionXML.pedirProvincias(this);
        spn_provincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Provincia p = (Provincia) spn_provincias.getSelectedItem();
                PeticionXML.pedirMunicipios(a, p.getNp());


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void mostrarProvincias(Map<String, String> lista_provincias) {
        ArrayList<Provincia> list_provincias = new ArrayList<>();
        for (String clave : lista_provincias.keySet()) {
            Provincia p = new Provincia();
            p.setCpine(clave);
            p.setNp(lista_provincias.get(clave));
            list_provincias.add(p);
        }
        ArrayAdapter<Provincia> ad = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, list_provincias);
        spn_provincias.setAdapter(ad);
    }

    @Override
    public void mostrarMunicipios(Municipiero m) {
        List<Municipio> lista = m.getLista_municipios();
        ArrayAdapter<Municipio> ad = new ArrayAdapter<Municipio>(this, R.layout.support_simple_spinner_dropdown_item, lista);
        spn_municipios.setAdapter(ad);

        solicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigoLocalidad = CodigoLocalidad(((Provincia) spn_provincias.getSelectedItem()).getCpine(),
                        ((Municipio) spn_municipios.getSelectedItem()).getLoine().getCodigo());
                PeticionXML.pedirMunicipios(a, codigoLocalidad);



                Log.d("Respueta", codigoLocalidad);
                Log.d("Respueta", a.toString());
                PeticionXML.pedirClima(codigoLocalidad, a);


            }
        });

    }

    @Override
    public void mostrarClima(ClimaAEMET clima) {
        String html = PintarTablaHTML.crearTabla(clima);
        web.loadData(html, "text/html", "UTF-8");
        Log.d("Respueta", html);
        Log.d("Respueta", "html");


    }
    public static String CodigoLocalidad(String provincia, String codLocalidad) {
        String localidad = provincia;
        int opcion = codLocalidad.length();
        switch (opcion) {
            case 1:
                localidad += "00" + codLocalidad;
                break;
            case 2:
                localidad += "0" + codLocalidad;
                break;
            case 3:
                localidad += codLocalidad;
                break;
            default:
                break;
        }

        return localidad;
    }


}