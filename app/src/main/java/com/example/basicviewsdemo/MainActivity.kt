package com.example.basicviewsdemo

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        val checkBox = findViewById<CheckBox>(R.id.checkBox)
        val toggleButton = findViewById<ToggleButton>(R.id.toggleButton)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val resultText = findViewById<TextView>(R.id.resultText)

        // Button
        submitButton.setOnClickListener {

            val name = nameEditText.text.toString()

            val genderId = radioGroup.checkedRadioButtonId

            var gender = "Not selected"

            if (genderId != -1) {
                val radioButton =
                    findViewById<RadioButton>(genderId)
                gender = radioButton.text.toString()
            }

            val agreement =
                if (checkBox.isChecked) "Agreed" else "Not Agreed"

            val status =
                if (toggleButton.isChecked) "ON" else "OFF"

            resultText.text =
                "Name: $name\n" +
                        "Gender: $gender\n" +
                        "Terms: $agreement\n" +
                        "Toggle: $status"
        }

        // ImageButton
        imageButton.setOnClickListener {
            Toast.makeText(
                this,
                "ImageButton clicked",
                Toast.LENGTH_SHORT
            ).show()
        }

        // ToggleButton
        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            val message =
                if (isChecked) "Toggle is ON"
                else "Toggle is OFF"

            Toast.makeText(
                this,
                message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}