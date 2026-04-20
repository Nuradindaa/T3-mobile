package com.example.formidentitas

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi
        val etName = findViewById<EditText>(R.id.etName)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val cbMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)
        val cbOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnSubmit.setOnClickListener {
            // nama
            val name = etName.text.toString().trim()
            // Validasi nama
            if (name.isEmpty()) {
                etName.error = "Nama tidak boleh kosong"
                etName.requestFocus()
                return@setOnClickListener
            }

            // Validasi gender
            val selectedGenderId = rgGender.checkedRadioButtonId
            if (selectedGenderId == -1) {
                Toast.makeText(this, "Jenis kelamin harus dipilih!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rbSelected = findViewById<RadioButton>(selectedGenderId)
            val gender = rbSelected.text.toString()

            // Hobi
            val hobbies = mutableListOf<String>()
            if (cbMembaca.isChecked) hobbies.add("Membaca")
            if (cbCoding.isChecked) hobbies.add("Coding")
            if (cbOlahraga.isChecked) hobbies.add("Olahraga")

            // validasi hobi
            val hobbyString = if (hobbies.isNotEmpty()) {
                hobbies.joinToString(", ")
            } else {
                "-"
            }

            // hasil
            val resultText = """
                Nama    : $name
                Kelamin : $gender
                Hobi    : $hobbyString
            """.trimIndent()

            tvResult.text = resultText
        }
    }
}