package com.design.cumplepablo

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.core.view.isInvisible
import com.design.cumplepablo.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var resultText: TextView
    lateinit var textoYear: TextView
    lateinit var fecha: TextView
    lateinit var foto: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //Creando binding

            Log.i("info","OnCreate")
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            //Textos
            resultText = binding.cuadroTextoResultadoCalculo
            textoYear = binding.textYear
            //Fecha
            fecha = binding.editTextFecha

            //Fotos
            foto = binding.carruselFotos
            foto.setBackgroundColor(R.drawable.image_border)
            foto.setVisibility(View.VISIBLE)

            //Botón
            binding.calculoEdad.setOnClickListener { calculoEdad(it) }

            //Fondo de pantalla
            var fondo = binding.imagenCumple
            fondo.setImageResource(R.drawable.cumple)




    }

    override fun onStart() {
        super.onStart()
        Log.i("info","onStart")
    }


    override fun onRestart() {
        super.onRestart()
        Log.i("info","onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("info","OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("info","OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("info","OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("info","OnDestroy")
    }
//Functions

   fun calculoEdad (view: View) {

       val resultFecha = datosFecha()

       val felicidades = "Felicidades Pablo, este año cumples $resultFecha primaveras"
        foto.setVisibility(View.VISIBLE)

       //Esconder teclado
       val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
       inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)

        when (resultFecha) {

            in -8000..-1 -> {
                resultText.text = "No has nacido todavía Pablo ¡¡Disfruta de tu soledad cósmica!!"
                foto.setImageResource(R.drawable.pablononacido)

            }
            0 -> {
                resultText.text = "¡¡Acabas de nacer, Pablo!! ¡¡Bienvenido a este mundo!!"
                foto.setImageResource(R.drawable.happybirthday)
5
            }
            1 -> {
                "Felicidades Pablo, hoy cumples " + resultFecha + " año"
                foto.setImageResource(R.drawable.pablobebe)

            }
            2 -> {
                resultText.text = felicidades
                foto.setImageResource(R.drawable.pablo2015)
            }
            3 -> {
                resultText.text = felicidades
                foto.setImageResource(R.drawable.pablo2016)
            }
            4 -> {
                resultText.text = felicidades
                foto.setImageResource(R.drawable.pablo2017)
            }
            5 -> {
                resultText.text = felicidades
                foto.setImageResource(R.drawable.happybirthday)
            }
            6 -> {
                resultText.text = felicidades
                foto.setImageResource(R.drawable.pablo2019)
            }
            7 -> {
                resultText.text = felicidades
                foto.setImageResource(R.drawable.happybirthday)
            }
            8 -> {
                resultText.text = felicidades
                foto.setImageResource(R.drawable.pablo2021)
            }
            in 9..17 -> {
                resultText.text =
                    "$felicidades. Estás en la etapa adolescente..."
                foto.setImageResource(R.drawable.pabloadolescente)
            }
            in 18..60 -> {
                resultText.text =
                    "$felicidades. Ya vas siendo una persona madurita..."
                foto.setImageResource(R.drawable.pablomaduro)
            }
            in 61..120 -> {
                resultText.text =
                    "$felicidades. ¡¡Ya eres un viejete!!"
                foto.setImageResource(R.drawable.pabloanciano)
            }

            in 121..6000 -> {
                resultText.text =
                    "$felicidades. Pero es imposible con la tecnología actual..."
                foto.setImageResource(R.drawable.pabloanciano)
            }
            else -> {
                resultText.text = "Introduce una fecha para continuar"
                foto.setVisibility(View.INVISIBLE)

            }


        }



    }

    //Toma la fecha del input text
    fun datosFecha(): Int {

        if (fecha.text.isNotEmpty()) {

            val fechaString = fecha.getText().toString();
            val fechaInt = fechaString.toInt()
            textoYear.text = "Año " + fechaInt.toString()
            return fechaInt - 2013

        } else {
            textoYear.text = "Año no definido"
            Toast.makeText(this, "Introduce una fecha para continuar", Toast.LENGTH_SHORT).show()
            return -9999
        }

    }





}