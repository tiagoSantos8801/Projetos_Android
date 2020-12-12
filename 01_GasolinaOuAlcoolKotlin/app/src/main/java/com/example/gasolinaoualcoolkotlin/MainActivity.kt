package com.example.gasolinaoualcoolkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculaPreco(view :View){

        //val precoAlcool = findViewById<EditText>(R.id.editTextAlcool) - Importando o pligin do Kotlin
        val precoAlcool = editTextAlcool.text.toString()
        val precoGasolina = editTextGosolina.text.toString()

        var validaCampos = validandoCampos(precoAlcool, precoGasolina)

        when {
            validaCampos -> {
                calcularMelhorOpcao(precoAlcool, precoGasolina)
            }
            else -> {
                textResp.text = "Preencha os campos obrigatorios!!"
            }
        }
    }

    fun validandoCampos(precoAlcool:String, precoGasolina:String): Boolean{
        var camposValidados:Boolean = true

        when {
            precoAlcool == null || precoAlcool.equals("") -> {
                camposValidados = false
            }
            precoGasolina == null || precoGasolina.equals("") -> {
                camposValidados = false
            }
        }
        return camposValidados
    }

    fun calcularMelhorOpcao(precoAlcool:String, precoGasolina:String){

        var valorAlcool = precoAlcool.toDouble()
        var valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina

        when {
            resultadoPreco >= 0.7 -> {
                textResp.text = "Melhor usar gasolina!!"
            }
            else -> {
                textResp.text = "Melhor usar alcool"
            }
        }
    }
}