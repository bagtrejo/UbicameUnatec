package com.example.proyectoubicacion.Activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectoubicacion.R
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class DetalleUbicacionActivity : AppCompatActivity() {

    var simpleimagen : IntArray = intArrayOf(
        R.drawable.aula_101_01,
        R.drawable.aula_101_02,
        R.drawable.coronavirus,
        R.drawable.degradado2
    )
    var aula: Array<String> = arrayOf(
        "aula_101_01",
        "aula_101_02",
        "coronavirus",
        "degradado2"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_ubicacion)



        val carouselView = findViewById(R.id.carouselView) as CarouselView;
        carouselView.setImageListener{position, imageView ->
            imageView.setImageResource(simpleimagen[position])
        }

        carouselView.pageCount = aula.size

        carouselView.setImageClickListener{position ->
            Toast.makeText(applicationContext, aula[position], Toast.LENGTH_LONG).show()
        }


        val intent = intent
        val posicion: Int = intent.getIntExtra("posicion", 0);
        val titulo: String? = intent.getStringExtra("titulo");
        val descripcion: String? = intent.getStringExtra("descripcion");
        System.out.println(titulo);

    }
}