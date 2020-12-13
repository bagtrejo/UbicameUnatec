package com.example.proyectoubicacion.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.proyectoubicacion.Acerca_de;
import com.example.proyectoubicacion.Activities.ListElement;
import com.example.proyectoubicacion.Adaptadores.ListAdapter;
import com.example.proyectoubicacion.R;

import java.util.ArrayList;
import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    List<ListElement> elements;
    ListAdapter listAdapter;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

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










    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar,menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                listAdapter.getFilter().filter(newText);
            return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        try{
        switch(item.getItemId()){

            case R.id.item1:
                Intent intent = new Intent(PrincipalActivity.this, Acerca_de.class);
                startActivityForResult(intent, 0);
                Toast.makeText(getApplicationContext(),"Toast por defecto", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}