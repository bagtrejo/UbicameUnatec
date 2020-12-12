package com.example.proyectoubicacion.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectoubicacion.R

class DetalleUbicacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_ubicacion)

        val intent = intent
        val posicion: Int = intent.getIntExtra("posicion", 0);
        val titulo: String? = intent.getStringExtra("titulo");
        val descripcion: String? = intent.getStringExtra("descripcion");
        System.out.println(descripcion);

    }
}