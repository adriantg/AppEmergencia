package com.example.adrian.appe;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adrian.appe.R;

import java.util.List;

/**
 * Created by Adrian on 23/10/2017.
 */

public class ComunicadoWebAdapter extends RecyclerView.Adapter<ComunicadoWebAdapter.ComunicadoWebViewHolder>{
    private List<ComunicadoWeb> items;

    public static class ComunicadoWebViewHolder extends RecyclerView.ViewHolder{

        public TextView titulo;
        public TextView hora;
        public TextView descripcion;
        public TextView liga;
        public CardView cv;

        public ComunicadoWebViewHolder(View v){
            super(v);
            cv=(CardView)v.findViewById(R.id.cdv_Comunicado_Web);
            titulo=(TextView)v.findViewById(R.id.txt_Titulo_Comunicado_Web);
            hora=(TextView)v.findViewById(R.id.txt_Hora_Comunicado_Web);
            descripcion=(TextView)v.findViewById(R.id.txt_Descripcion_Comunicado_Web);
            liga=(TextView)v.findViewById(R.id.txt_Liga_Comunicado_Web);
        }
    }

    public ComunicadoWebAdapter(List<ComunicadoWeb> items){
        this.items=items;
    }

    @Override
    public int getItemCount(){
        return items.size();
    }

    @Override
    public ComunicadoWebViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_web,viewGroup,false);
        return new ComunicadoWebViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ComunicadoWebViewHolder viewHolder,int i){
        viewHolder.titulo.setText(items.get(i).getTitulo());
        viewHolder.hora.setText(items.get(i).getHora());
        viewHolder.descripcion.setText(items.get(i).getDescripcion());
        viewHolder.liga.setText(items.get(i).getLiga());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
