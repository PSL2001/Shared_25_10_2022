package com.example.shared25_10_22.preferences

import android.content.Context

/*
 * MANERA B: Esto es lo mismo que la A pero hay que añadir en el manifest
 * android:name=".Aplicacion"
 * Además de crear una clase con ese nombre que extiende de Aplication
 */
class Prefs1(c: Context) {
    val storage = c.getSharedPreferences("EJ_PREFES", 0)

    fun guardarNombre(nombre : String) {
        //El edit solo se pone para añadir campos, no es necesario para leer
        storage.edit().putString("NOMBRE", nombre).apply()
    }

    fun guardarEsVip(vip: Boolean) {
        storage.edit().putBoolean("ES_VIP", vip).apply()
    }

    fun leerNombre(): String {
        return storage.getString("NOMBRE", "").toString()
    }

    fun leerEsVip(): Boolean {
        return storage.getBoolean("ES_VIP", false)
    }
    /*
     * Metodo para borrar todas las preferencias
     */
    fun borrarTodo() {
        storage.edit().clear().apply()
    }
}