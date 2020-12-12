package com.example.proyectoubicacion.Activities

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.example.proyectoubicacion.R
import kotlin.math.max
import kotlin.math.min

class MainActivity : AppCompatActivity(){




    lateinit var option:Spinner
    lateinit var btn1 :Button
    lateinit var btn2 :Button
    lateinit var btn3 :Button
    lateinit var info :ImageButton
    lateinit var imagen :ImageView
    private lateinit var scaleGestureDetector: ScaleGestureDetector
    private var scaleFactor = 1.0f




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        option = findViewById(R.id.spn_option) as Spinner
        btn1 = findViewById(R.id.btn1) as Button
        btn2 = findViewById(R.id.btn2) as Button
        btn3 = findViewById(R.id.btn3) as Button
        info = findViewById(R.id.info) as ImageButton
        imagen = findViewById(R.id.imagenprincipal) as ImageView
        scaleGestureDetector = ScaleGestureDetector(this, ScaleListener())



        val options = arrayOf("Aula 101","Aula 102","Aula 103","Aula 104","Aula 105")
        option.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,options)

        option.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {


                if (options.get(position).equals("Aula 101")){
                    imagen.setImageResource(R.drawable.aula_101_01)
                    btn1.setBackgroundColor(Color.parseColor("#044180"));
                    btn2.setBackgroundColor(Color.parseColor("#F0CC38"));
                    btn3.setBackgroundColor(Color.parseColor("#F0CC38"));

                    btn1.setOnClickListener {
                        btn1.setBackgroundColor(Color.parseColor("#044180"));
                        btn2.setBackgroundColor(Color.parseColor("#F0CC38"));
                        btn3.setBackgroundColor(Color.parseColor("#F0CC38"));
                        imagen.setImageResource(R.drawable.aula_101_01)
                    }

                    btn2.setOnClickListener {
                        btn1.setBackgroundColor(Color.parseColor("#F0CC38"));
                        btn2.setBackgroundColor(Color.parseColor("#044180"));
                        btn3.setBackgroundColor(Color.parseColor("#F0CC38"));
                        imagen.setImageResource(R.drawable.aula_101_01)
                    }

                    btn3.setOnClickListener {
                        btn1.setBackgroundColor(Color.parseColor("#F0CC38"));
                        btn2.setBackgroundColor(Color.parseColor("#F0CC38"));
                        btn3.setBackgroundColor(Color.parseColor("#044180"));
                        imagen.setImageResource(R.drawable.aula_101_02)
                    }

                    info.setOnClickListener {
                       val builder = AlertDialog.Builder(this@MainActivity)
                        builder.setTitle("Aula 101")
                        builder.setMessage("queda en la planta de arriba")
                        builder.show()
                    }

                }
                if(options.get(position).equals("Aula 102")){
                    imagen.setImageResource(R.drawable.aula_102_01)
                    btn1.setBackgroundColor(Color.parseColor("#044180"));
                    btn2.setBackgroundColor(Color.parseColor("#F0CC38"));
                    btn3.setBackgroundColor(Color.parseColor("#F0CC38"));

                    btn1.setOnClickListener {
                        btn1.setBackgroundColor(Color.parseColor("#044180"));
                        btn2.setBackgroundColor(Color.parseColor("#F0CC38"));
                        btn3.setBackgroundColor(Color.parseColor("#F0CC38"));
                        imagen.setImageResource(R.drawable.aula_102_01)
                    }

                    btn2.setOnClickListener {
                        btn1.setBackgroundColor(Color.parseColor("#F0CC38"));
                        btn2.setBackgroundColor(Color.parseColor("#044180"));
                        btn3.setBackgroundColor(Color.parseColor("#F0CC38"));
                        imagen.setImageResource(R.drawable.aula_102_01)
                    }

                    btn3.setOnClickListener {
                        btn1.setBackgroundColor(Color.parseColor("#F0CC38"));
                        btn2.setBackgroundColor(Color.parseColor("#F0CC38"));
                        btn3.setBackgroundColor(Color.parseColor("#044180"));
                        imagen.setImageResource(R.drawable.aula_102_02)
                    }
                    info.setOnClickListener {
                        val builder = AlertDialog.Builder(this@MainActivity,
                            R.style.EstiloDialogoAlerta
                        )
                        builder.setTitle("Aula 102")
                        builder.setMessage("queda en la planta de abajo")
                        builder.show()
                    }

                }
            }
        }









    }
    override fun onTouchEvent(motionEvent: MotionEvent): Boolean {
        scaleGestureDetector.onTouchEvent(motionEvent)
        return true
    }
    private inner class ScaleListener : ScaleGestureDetector.SimpleOnScaleGestureListener() {
        override fun onScale(scaleGestureDetector: ScaleGestureDetector): Boolean {
            scaleFactor *= scaleGestureDetector.scaleFactor
            scaleFactor = max(1.0f, min(scaleFactor, 10.0f))
            imagen.scaleX = scaleFactor
            imagen.scaleY = scaleFactor
            return true
        }



}
}

