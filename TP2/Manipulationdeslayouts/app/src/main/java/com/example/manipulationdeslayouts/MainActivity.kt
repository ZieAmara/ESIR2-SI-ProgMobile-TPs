package com.example.manipulationdeslayouts

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_departements_breton_layout)

        // Création de la liste des départements bretons
        val departementsBretons = arrayListOf("Côtes-d'Armor", "Finistère", "Ille-et-Vilaine", "Morbihan")

        // Création de l'adaptateur pour la ListView
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, departementsBretons)
        // Liaison de l'adaptateur avec la ListView
        val listView: ListView = findViewById(R.id.my_listView)
        listView.adapter = adapter

    }
}
