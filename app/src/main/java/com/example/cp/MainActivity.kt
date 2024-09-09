package com.example.cp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val listaRemedios = ArrayList<Remedio>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomeRemedioEditText = findViewById<EditText>(R.id.editNomeRemedio)
        val dosagemRemedioEditText = findViewById<EditText>(R.id.editDosagemRemedio)
        val horarioRemedioEditText = findViewById<EditText>(R.id.editHorarioRemedio)
        val quantidadeRemedioEditText = findViewById<EditText>(R.id.editQuantidadeRemedio)
        val relatorioTextView = findViewById<TextView>(R.id.textRelatorio)

        val botaoAdicionar = findViewById<Button>(R.id.botaoAdicionar)
        botaoAdicionar.setOnClickListener {
            val nome = nomeRemedioEditText.text.toString()
            val dosagem = dosagemRemedioEditText.text.toString()
            val horario = horarioRemedioEditText.text.toString()
            val quantidade = quantidadeRemedioEditText.text.toString().toIntOrNull() ?: 0

            val remedio = Remedio(nome, dosagem, horario, quantidade)
            listaRemedios.add(remedio)

            atualizarRelatorio(relatorioTextView)
        }
    }

    private fun atualizarRelatorio(textView: TextView) {
        val relatorio = StringBuilder()
        for (remedio in listaRemedios) {
            relatorio.append("Nome: ${remedio.nome}, Dosagem: ${remedio.dosagem}, Horário: ${remedio.horario}, Quantidade: ${remedio.quantidade}\n")
        }
        textView.text = relatorio.toString()
    }

    data class Remedio(
        val nome: String,
        val dosagem: String,
        val horario: String,
        val quantidade: Int
    )
}