package com.example.project1.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.project1.R

class FavoritesActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.receipt_list_item)

        val itemId = intent.getStringExtra("id")
        val itemImage = intent.getIntExtra("image", 0)
        val itemName = intent.getStringExtra("emri")
        val itemIngredients = intent.getStringExtra("perberesit")
        val itemCalories = intent.getDoubleExtra("kalorite", 0.0)

        val idView = findViewById<TextView>(R.id.id)
        val imageView = findViewById<ImageView>(R.id.item_image)
        val nameTextView = findViewById<TextView>(R.id.item_name)
        val ingredientsTextView = findViewById<TextView>(R.id.perberesit_item)
        val caloriesTextView = findViewById<TextView>(R.id.kalorite_item)

        idView.text = itemId.toString()
        imageView.setImageResource(itemImage)
        nameTextView.text = itemName
        ingredientsTextView.text = itemIngredients
        caloriesTextView.text = "Calories: $itemCalories"
    }
}
