package com.example.shared25_10_22

import android.app.Application
import com.example.shared25_10_22.preferences.Prefs1

/*
 * Parte de la manera B: Esta clase se debe hacer en orden de que se inicialize las preferencias
 */
class Aplicacion: Application() {
    companion object {
        lateinit var prefs1: Prefs1
    }

    override fun onCreate() {
        super.onCreate()
        prefs1 = Prefs1(applicationContext)
    }
}