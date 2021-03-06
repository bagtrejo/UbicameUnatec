package com.example.proyectoubicacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.SymbolTable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toolbar;

import com.example.proyectoubicacion.Activities.Acerca_de;
import com.example.proyectoubicacion.Activities.Desarrolladores;
import com.example.proyectoubicacion.Activities.ListElement;
import com.example.proyectoubicacion.Adaptadores.ListAdapter;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

import static com.example.proyectoubicacion.R.id.action_search;

public class PrincipalActivity extends AppCompatActivity{

    List<ListElement> elements;
    ListAdapter listAdapter;
    FloatingActionsMenu btn_grupoDeBotones;
    FloatingActionButton btn_desarrolladores, btn_salir, btn_acerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        btn_desarrolladores = (FloatingActionButton) findViewById(R.id.desarrolladores);
        btn_acerca = (FloatingActionButton) findViewById(R.id.acerca_de);
        btn_salir = (FloatingActionButton) findViewById(R.id.salirr);
        btn_grupoDeBotones = (FloatingActionsMenu) findViewById(R.id.boton);

        initValues();

        btn_desarrolladores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, Desarrolladores.class);
                startActivity(intent);
            }
        });
        btn_acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this, Acerca_de.class);
                startActivity(intent);
            }
        });

        btn_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });



    }

    private void initValues() {
        RecyclerView recyclerView = findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //cargo la lista con los elemtos que va a contener
        elements = getItems();

        listAdapter = new ListAdapter(elements, this);
        recyclerView.setAdapter(listAdapter);
    }

    private List<ListElement> getItems() {

        List<ListElement> itemLists = new ArrayList<>();
        itemLists.add(new ListElement ("Aula 101",
                "Edificio 1, planta baja, lado derecho, posicionandose en la entrada, aula del ultimo pasillo, contiguo a el aula 102.",
                R.drawable.aula_101_01, R.drawable.aula_101_02, R.drawable.sat_aula_101));

        itemLists.add(new ListElement ("Aula 102",
                "Edificio 1, planta baja, lado derecho posicionandose en la entrada, entre el aula 101 y 103.",
                R.drawable.aula_102_01, R.drawable.aula_102_02, R.drawable.sat_aula_102));

        itemLists.add(new ListElement ("Aula 103",
                "Edificio 1, planta baja, lado derecho posicionandose en la entrada, contiguo a el aula 102.",
                R.drawable.aula_103_01, R.drawable.aula_103_02, R.drawable.sat_aula_103));

        itemLists.add(new ListElement ("Aula 104",
                "Edificio 1, planta baja, lado izquierdo posicionandose en la entrada, contiguo al Laboratorio de Catación.",
                R.drawable.aula_104_01, R.drawable.aula_104_02, R.drawable.sat_aula_104));

        itemLists.add(new ListElement ("Aula 105",
                "Edificio 1, planta baja, lado izquierdo posicionandose en la entrada, entre el Laboratorio de Catación y el Laboratorio de Informática.",
                R.drawable.aula_105_01, R.drawable.aula_105_02, R.drawable.sat_aula_105));

        itemLists.add(new ListElement ("Aula 201",
                "Edificio 1, segunda planta, subiendo las escaleras de la entrada principal, primer aula del pasillo derecho.",
                R.drawable.aula_201_01, R.drawable.aula_201_02, R.drawable.sat_aula_201));

        itemLists.add(new ListElement ("Aula 202",
                "Edificio 1, segunda planta, subiendo las escaleras de la entrada principal, pasillo derecho, contiguo al aula 201.",
                R.drawable.aula_202_01, R.drawable.aula_202_02, R.drawable.sat_aula_202));

        itemLists.add(new ListElement ("Aula 203",
                "Edificio 1, segunda planta, subiendo las escaleras de la entrada principal, pasillo derecho, entre el aula 204 y 202.",
                R.drawable.aula_203_01, R.drawable.aula_203_02, R.drawable.sat_aula_203));

        itemLists.add(new ListElement ("Aula 204",
                "Edificio 1, segunda planta, subiendo las escaleras de la entrada principal, pasillo derecho, entre el aula 205y 203.",
                R.drawable.aula_204_01, R.drawable.aula_204_02, R.drawable.sat_aula_204));

        itemLists.add(new ListElement ("Aula 205",
                "Edificio 1, segunda planta, subiendo las escaleras de la entrada principal, pasillo derecho, contiguo al aula 204.",
                R.drawable.aula_205_01, R.drawable.aula_205_02, R.drawable.sat_aula_205));

        itemLists.add(new ListElement ("Aula 206",
                "Edificio 1, segunda planta, subiendo las escaleras de la entrada principal, pasillo izquierdo, contiguo al Área de Humanidades.",
                R.drawable.aula_206_01, R.drawable.aula_206_02, R.drawable.sat_aula_206));

        itemLists.add(new ListElement ("Aula 207",
                "Edificio 1, segunda planta, subiendo las escaleras de la entrada principal, pasillo izquierdo, contiguo al aula 206.",
                R.drawable.aula_207_01, R.drawable.aula_207_02, R.drawable.sat_aula_207));

        itemLists.add(new ListElement ("Aula 208",
                "Edificio 1, segunda planta, subiendo las escaleras de la entrada principal, pasillo izquierdo, contiguo a las Oficinas Administrativas.",
                R.drawable.aula_208_01, R.drawable.aula_208_02, R.drawable.sat_aula_208));

        itemLists.add(new ListElement ("Baños planta baja",
                "Se encuentra ubicada en la primera planta del edificio 1, en la entrada a la izquierda a la par del aula 104.",
                R.drawable.banios_planta_baja_01, R.drawable.banios_planta_baja_02, R.drawable.sat_banios_abajo));

        itemLists.add(new ListElement ("Baños planta arriba",
                "Se encuentra ubicada en la segunda planta del edificio 1, subiendo las gradas de la entrada a mano izquierda.",
                R.drawable.banios_planta_arriba_01, R.drawable.banios_planta_arriba_02, R.drawable.sat_banios_arriba));

        itemLists.add(new ListElement ("Biblioteca",
                "Se encuentra ubicada en la primera planta del edificio 1, al final del pasillo de la entrada a mano izquierda, a la par de admisiones.",
                R.drawable.bibloteca_01, R.drawable.bibloteca_02, R.drawable.sat_biblioteca));

        itemLists.add(new ListElement ("Área de Economía",
                "Se encuentra ubicada en el edificio 2, en la parte de atrás del aula de deporte, VOAE y el gimnasio",
                R.drawable.area_economia_01, R.drawable.area_economia_02, R.drawable.sat_economia));


        itemLists.add(new ListElement ("Área de Informática",
                "Se encuentra ubicada en la primera planta del edificio 1, al final del pasillo izquierdo, enfrente del aula 101, y a la par de la biblioteca",
                R.drawable.laboratorio_informatica_01, R.drawable.laboratorio_informatica_02, R.drawable.sat_lab_informatica));

        itemLists.add(new ListElement ("Aula de Deportes",
                "Se encuentra ubicada en el edificio 2, atrás de la portería norte de la cancha.",
                R.drawable.aula_deportes_01, R.drawable.aula_deportes_02, R.drawable.sat_deportes));

        itemLists.add(new ListElement ("Aula de Maestria",
                "Se encuentra ubicada en el edificio 2, atrás de la sala de economía en una puerta de cristal.",
                R.drawable.aula_maestria_01, R.drawable.aula_maestria_02, R.drawable.sat_maestria));

        itemLists.add(new ListElement ("Cancha Deportiva",
                "Se encuentra ubicada a unos metros de la entrada a mano derecha frente a las casetas",
                R.drawable.cancha_futbol_01, R.drawable.cancha_futbol_02, R.drawable.sat_cancha));

        itemLists.add(new ListElement ("Casetas",
                "Se encuentran ubicadas a unos metros de la entrada a mano derecha pasando por la fotocopiadora.",
                R.drawable.caseta_01, R.drawable.caseta_02, R.drawable.sat_caseta));

        itemLists.add(new ListElement ("Gimnasio",
                "Se encuentra ubicada en el edificio 2, atrás de la portería norte de la cancha, a la par de VOAE",
                R.drawable.gimnasio_01, R.drawable.gimnasio_02, R.drawable.sat_gimnasio));

        itemLists.add(new ListElement ("Laboratorio Catación",
                "Se encuentra ubicada en la primera planta del edificio 1, en la entrada a la izquierda, queda entre el aula 104 y 105.",
                R.drawable.laboratorio_catacion_01, R.drawable.laboratorio_catacion_02, R.drawable.sat_lab_catacion));

        itemLists.add(new ListElement ("Oficinas Administrativas",
                "Se encuentra ubicada en la primera planta del edificio 1, ,al lado izquierdo, segunda  oficina.",
                R.drawable.oficina_administrativas_01, R.drawable.oficina_administrativas_02, R.drawable.sat_administracion));

        itemLists.add(new ListElement ("Laboratorio de Cómputo",
                "Se encuentra ubicada en la segunda planta del edificio 1, subiendo las gradas de la entrada a mano derecha, a la par del aula de maestros.",
                R.drawable.laboratorio_computo_01, R.drawable.laboratorio_computo_02, R.drawable.sat_lab_computo));

        itemLists.add(new ListElement ("Papeleria",
                "Se encuentra ubicada a unos metros de la entrada a mano derecha.",
                R.drawable.papeleria_01, R.drawable.papeleria_02, R.drawable.sat_papeleria));

        itemLists.add(new ListElement ("Planta Piloto",
                "Se encuentra ubicada en los laboratorios, en la cuarta entrada, en el pasillo número 3. ",
                R.drawable.planta_piloto_01, R.drawable.planta_piloto_02, R.drawable.sat_planta_piloto));

        itemLists.add(new ListElement ("VOAE",
                "Se encuentra ubicada en el edificio 2, atrás de la portería norte de la cancha a la par del aula de deportes.",
                R.drawable.voae_01, R.drawable.voae_02, R.drawable.sat_voae));

        return itemLists;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_app_bar,menu);
        MenuItem buscador = menu.findItem(action_search);
        SearchView searchView = (SearchView) buscador.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                System.out.println(newText);
                listAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

}