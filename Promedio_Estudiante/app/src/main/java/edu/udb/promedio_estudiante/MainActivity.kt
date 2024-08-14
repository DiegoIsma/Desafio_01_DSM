
package edu.udb.promedio_estudiante

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNombre: EditText = findViewById(R.id.editTextNombre)
        val editTextNota1: EditText = findViewById(R.id.editTextNota1)
        val editTextNota2: EditText = findViewById(R.id.editTextNota2)
        val editTextNota3: EditText = findViewById(R.id.editTextNota3)
        val editTextNota4: EditText = findViewById(R.id.editTextNota4)
        val editTextNota5: EditText = findViewById(R.id.editTextNota5)
        val buttonCalcular: Button = findViewById(R.id.buttonCalcular)
        val buttonLimpiar: Button = findViewById(R.id.buttonLimpiar)
        val textViewResultado: TextView = findViewById(R.id.textViewResultado)

        buttonCalcular.setOnClickListener {
            try {
                val nombre = editTextNombre.text.toString()
                val nota1 = editTextNota1.text.toString().toDouble()
                val nota2 = editTextNota2.text.toString().toDouble()
                val nota3 = editTextNota3.text.toString().toDouble()
                val nota4 = editTextNota4.text.toString().toDouble()
                val nota5 = editTextNota5.text.toString().toDouble()

                if (nota1 !in 0.0..10.0 || nota2 !in 0.0..10.0 ||
                    nota3 !in 0.0..10.0 || nota4 !in 0.0..10.0 ||
                    nota5 !in 0.0..10.0) {
                    textViewResultado.text = "Las notas deben estar entre 0 y 10."
                    return@setOnClickListener
                }

                val promedio = (nota1 * 0.15) + (nota2 * 0.15) + (nota3 * 0.20) + (nota4 * 0.25) + (nota5 * 0.25)
                val resultado = "$nombre, tu promedio es: $promedio"

                val resultadoFinal = if (promedio >= 6) "$resultado\n¡Aprobado!" else "$resultado\nReprobado."
                textViewResultado.text = resultadoFinal

            } catch (e: NumberFormatException) {
                textViewResultado.text = "Por favor, ingresa todas las notas correctamente."
            }
        }
        buttonLimpiar.setOnClickListener {
            editTextNombre.text.clear()
            editTextNota1.text.clear()
            editTextNota2.text.clear()
            editTextNota3.text.clear()
            editTextNota4.text.clear()
            editTextNota5.text.clear()
            textViewResultado.text = "Resultado aparecerá aquí"
        }
    }
}