package com.example.proyectoubicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        //declaracion de la animaciones
        val deslizarabajo = AnimationUtils.loadAnimation(this, R.anim.deslizarabajo)
        val apararicion = AnimationUtils.loadAnimation(this, R.anim.apararicion)
        val deslizararriba = AnimationUtils.loadAnimation(this, R.anim.deslizararriba)

        //traer los id a las variables donde se lesinsertara la animacion
        val texto = findViewById(R.id.texto) as TextView
        val boton = findViewById(R.id.boton) as ImageView
        val texto2 = findViewById(R.id.texto2) as TextView

        //insertando las animacionnes
        texto.startAnimation(deslizarabajo)
        boton.startAnimation(apararicion)
        texto2.startAnimation(deslizararriba)

        val splash = object :  Thread() {
            override fun run() {
                try {
                    Thread.sleep(3000)
                    val intent = Intent(baseContext,MainActivity::class.java)
                    finish()
                    startActivity(intent)
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }

        }
        splash.start()


    }
}