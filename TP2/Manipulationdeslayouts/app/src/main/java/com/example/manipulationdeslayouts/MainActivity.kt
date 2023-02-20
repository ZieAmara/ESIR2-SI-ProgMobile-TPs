package com.example.manipulationdeslayouts

import android.app.AlertDialog
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
        // Création de la map des départements bretons et leur population
        val populationDepartements = mapOf(
            "Côtes-d'Armor" to 598080,
            "Finistère" to 913606,
            "Ille-et-Vilaine" to 1088283,
            "Morbihan" to 758054
        )

        // Création de l'adaptateur pour la ListView
        val departements = ArrayList<String>()
        for (departement in departementsBretons) {
            departements.add("$departement - Bretagne")
        }
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, departements)
        // Liaison de l'adaptateur avec la ListView
        val listView: ListView = findViewById(R.id.my_listView)
        listView.adapter = adapter

        // Gestion des clics sur les éléments de la liste
        listView.setOnItemClickListener { parent, view, position, id ->
            // Récupération du département sélectionné et de sa population
            val departement = departementsBretons[position]
            val population = populationDepartements[departement]
            // Affichage d'une popup avec le nom et la population du département
            val popup = AlertDialog.Builder(this)
                .setTitle(departement)
                .setMessage("$departement\nPopulation : $population")
                .setPositiveButton(android.R.string.ok, null)
                .create()
            popup.show()
        }
    }
}
