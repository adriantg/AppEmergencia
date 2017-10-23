package com.example.adrian.appe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Web extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager lManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        //RecyclerView
        List items=new ArrayList();
        items.add(new ComunicadoWeb("Ejemplo1","01:47 23/10/2017","Esto es un ejemplo","www.ejemplo.com"));

        recycler=(RecyclerView)findViewById(R.id.recycler_Web_Institucion1);
        recycler.setHasFixedSize(true);

        lManager= new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter=new ComunicadoWebAdapter(items);
        recycler.setAdapter(adapter);
        //Fin recyclerView

    }
}
