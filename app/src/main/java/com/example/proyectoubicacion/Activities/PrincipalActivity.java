package com.example.proyectoubicacion.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.proyectoubicacion.Activities.ListElement;
import com.example.proyectoubicacion.Adaptadores.ListAdapter;
import com.example.proyectoubicacion.R;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    List<ListElement> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        init();
    }

    public void init(){

        elements = new ArrayList<>();
        elements.add(new ListElement("Aula 101", "Esta aula es color rojo y queda a la parde .....", R.drawable.aula_101_01));
        elements.add(new ListElement("Aula 102", "Esta aula es color rojo y queda a la parde .....", R.drawable.aula_101_02));
        elements.add(new ListElement("Aula 103", "Esta aula es color rojo y queda a la parde .....", R.drawable.aula_101_01));
        elements.add(new ListElement("Aula 104", "Esta aula es color rojo y queda a la parde .....", R.drawable.aula_101_02));
        elements.add(new ListElement("Aula 105", "Esta aula es color rojo y queda a la parde .....", R.drawable.aula_101_01));


        ListAdapter listAdapter = new ListAdapter(elements, this);
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }
}