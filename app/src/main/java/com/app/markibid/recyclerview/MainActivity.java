package com.app.markibid.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.markibid.recyclerview.models.Planet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String nama_planets[] = {
            "Merkurius",
            "Venus",
            "Bumi",
            "Mars",
            "Yupiter",
            "Saturnus",
            "Uranus",
            "Neptunus",
            "Pluto"
    };

    private final String url_planets[] = {
            "https://sulchana.files.wordpress.com/2013/04/merkurius.jpg?w=584",
            "http://res.cloudinary.com/dk-find-out/image/upload/q_80,w_1440/AW_Venus_nli6oy.jpg",
            "https://hanifweb.files.wordpress.com/2013/04/bumi.jpg",
            "http://res.cloudinary.com/dk-find-out/image/upload/q_80,w_1440/Mars_ICE_CAP_BACK0000_ozkwko.jpg",
            "http://4.bp.blogspot.com/-5yrpfhL1O1k/UlkuVbEZNnI/AAAAAAAABws/Hi2USkvyDus/s1600/yupiter.png",
            "http://2.bp.blogspot.com/-kFVjaebe9QA/VVmxCGg3uEI/AAAAAAAAAJk/M7R6hU0zPkY/s1600/saturn.png",
            "https://s2.graphiq.com/sites/default/files/600/media/images/t2/Uranus_4394249.png",
            "https://talithaqiute.files.wordpress.com/2014/05/neptunus.jpg?w=665",
            "https://openclipart.org/image/2400px/svg_to_png/223415/pluto.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tampilplanet();
    }

    private void tampilplanet() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Planet> planet = prepareData();
        DataAdapter adapter = new DataAdapter(getApplicationContext(),planet);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Planet> prepareData() {
        ArrayList<Planet> planets = new ArrayList<>();
        for(int i=0;i<nama_planets.length;i++){
            Planet planet = new Planet();
            planet.setNama_planet(nama_planets[i]);
            planet.setUrl_planet(url_planets[i]);
            planets.add(planet);
        }
        return planets;
    }
}
