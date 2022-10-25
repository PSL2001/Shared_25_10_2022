package com.example.shared25_10_22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.shared25_10_22.Aplicacion.Companion.prefs1
import com.example.shared25_10_22.databinding.ActivityMain2Binding
import com.example.shared25_10_22.preferences.Prefs

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    //lateinit var prefs: Prefs
    var nombre = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //prefs = Prefs(this)
        leerPreferencias()
        setListeners()
    }

    private fun setListeners() {
        binding.btnCerrar.setOnClickListener {
            prefs1.borrarTodo()
            finish()
        }
    }

    private fun leerPreferencias() {
        nombre = prefs1.leerNombre()
        binding.tvNombre2.text = "El nombre es $nombre"
        if (prefs1.leerEsVip()) {
            binding.clActivity2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_vip))
        } else {
            binding.clActivity2.setBackgroundColor(ContextCompat.getColor(this, R.color.color_novip))
        }
    }
}