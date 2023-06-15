package co.tiagoaguiar.ganheinamega

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText: TextView = findViewById(R.id.edit_number)
        val txtResult: TextView = findViewById(R.id.txt_result)
        val btnGenerate: TextView = findViewById(R.id.btn_generate)

        btnGenerate.setOnClickListener {
            val text = editText.text.toString()
            numberGenerator(text, txtResult)
        }
    }

    private fun numberGenerator(text: String, txtResult: TextView) {
        if (text.isEmpty()) {
            Toast.makeText(this, "Informe um valor válido", Toast.LENGTH_SHORT).show()
            return
        }
        val amount = text.toInt()
        if (amount < 6 || amount > 15) {
            Toast.makeText(this, "Valor inválido!", Toast.LENGTH_SHORT).show()
            return
        }
        val numbersList = mutableSetOf<Int>()
        val rand = Random()
        while (true) {
            val numRand = rand.nextInt(60) // 0..59
            numbersList.add(numRand + 1)

            if (numbersList.size == amount) {
                break
            }
        }
        txtResult.text = numbersList.joinToString(" . ")
    }
}
