package com.example.shared25_10_22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.shared25_10_22.databinding.ActivityMainBinding
import com.example.shared25_10_22.preferences.Prefs

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var nombre = ""
    lateinit var prefs: Prefs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prefs = Prefs(this)
        checkPreferences()
        setListeners()
    }

    private fun checkPreferences() {
        if (!prefs.leerNombre().isEmpty()) {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }

    private fun setListeners() {
        binding.btnLogin.setOnClickListener {
            comprobarDatos()
        }
    }

    private fun comprobarDatos() {
        nombre = binding.etNombre.text.toString().trim()
        println("======================================>$nombre")
        if (nombre.isEmpty()) {
            mostrarError("El nombre no puede estar vacio")
            return
        }
        //Guardamos el nombre y si es vip o no
        prefs.guardarNombre(nombre)
        prefs.guardarEsVip(binding.cbVip.isChecked)
        startActivity(Intent(this, MainActivity2::class.java))
    }

    private fun mostrarError(mensaje: String) {
        AlertDialog.Builder(this)
            .setTitle("Advertencia!")
            .setMessage(mensaje)
            .setPositiveButton("Aceptar", null)
            .show()
    }
}