package com.example.proyectoubicacion.Activities

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectoubicacion.R
import com.synnapps.carouselview.CarouselView


class DetalleUbicacionActivity : AppCompatActivity() {


    var aula: Array<String> = arrayOf(

        "imagen1",
        "imagen2",
        "imagen3"

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_ubicacion)


        val intent = intent
        val titulo: String? = intent.getStringExtra("titulo");
        val descripcion: String? = intent.getStringExtra("descripcion");
        val imagen: Int? = intent.getIntExtra("imagen", 0);
        val imagen2: Int? = intent.getIntExtra("imagen2", 0);
        val imagen3: Int? = intent.getIntExtra("imagen3", 0);
        System.out.println(imagen2);

        cargarInformacion(titulo!!, descripcion!!, imagen!!, imagen2!!, imagen3!!)

    }

    fun cargarInformacion(titulo: String, descripcion: String, imagen:Int, imagen2:Int, imagen3: Int){

        var imagenes : IntArray = intArrayOf(

            imagen, imagen2, imagen3

        )

        val carouselView = findViewById(R.id.carouselView) as CarouselView;
        carouselView.setImageListener{position, imageView ->
            imageView.setImageResource(imagenes[position])
        }

        carouselView.pageCount = aula.size

        val texview : TextView = findViewById(R.id.txtDescripcion)

        texview.setText(descripcion)



    }

    fun cargarImaganes(imagen: Int, imagen2: Int, imagen3: Int){

        val drbl = resources.getDrawable(imagen)
        val drb2 = resources.getDrawable(imagen2)
        val drb3 = resources.getDrawable(imagen3)



    }
}