package com.example.jokenpo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var txtResultado : TextView
    private lateinit var imgComputador : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imgComputador = findViewById<ImageView>(R.id.imagemPadrao)
        txtResultado = findViewById<TextView>(R.id.textResultado)

        val imgPedra = findViewById<ImageView>(R.id.imagemPedra)
        imgPedra.setOnClickListener {
            jogar("pedra")
        }
        val imgTesoura = findViewById<ImageView>(R.id.imagemTesoura)
        imgTesoura.setOnClickListener {
            jogar("tesoura")
        }
        val imgPapel = findViewById<ImageView>(R.id.imagemPapel)
        imgPapel.setOnClickListener {
            jogar("papel")
        }
    }

    private fun jogar(jogador : String) {
       val opcoes = arrayOf("pedra", "tesoura", "papel")
        val computador = opcoes[Random.nextInt(opcoes.size)]
        when(computador){
            "pedra" -> imgComputador.setImageResource(R.drawable.pedra)
            "tesoura" -> imgComputador.setImageResource(R.drawable.tesoura)
            "papel" -> imgComputador.setImageResource(R.drawable.papel)
        }
        when{
            (jogador == computador) -> {
                txtResultado.text = "Empate!"
            }
            (jogador == "pedra" && computador == "tesoura") -> {
                txtResultado.text = "Você venceu!"
            }
            (jogador == "papel" && computador == "pedra") -> {
                txtResultado.text = "Você venceu!"
            }
            (jogador == "tesoura" && computador == "papel") -> {
                txtResultado.text = "Você venceu!"
            }else -> {
                txtResultado.text = "Você Perdeu!"
            }
        }
    }
}