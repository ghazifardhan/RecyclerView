package com.app.markibid.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.markibid.recyclerview.models.Planet;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ghazi on 26/01/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<Planet> planets;
    private Context context;

    public DataAdapter(Context context, ArrayList<Planet> planets) {
        this.context = context;
        this.planets = planets;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        holder.nama_planet.setText(planets.get(position).getNama_planet());
        Picasso.with(context).load(planets.get(position).getUrl_planet()).resize(240, 240).into(holder.img_planet);
    }

    @Override
    public int getItemCount() {
        return planets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img_planet;
        public TextView nama_planet;

        public ViewHolder(View itemView) {
            super(itemView);

            nama_planet = (TextView)itemView.findViewById(R.id.nm_planet);
            img_planet = (ImageView)itemView.findViewById(R.id.img_planet);
        }
    }
}
