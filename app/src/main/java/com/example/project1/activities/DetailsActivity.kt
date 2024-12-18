package com.example.project1.activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.project1.R

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.receipt_list_details)

        val id = findViewById<TextView>(R.id.id)
        val photo = findViewById<ImageView>(R.id.image)
        val emri = findViewById<TextView>(R.id.emri)
        val perberesit = findViewById<TextView>(R.id.perberesit)
        val kaloritePerPorcion = findViewById<TextView>(R.id.kalorite)

        id.text = intent.getStringExtra("id").toString()
        photo.setImageResource(intent.getIntExtra("image", 0))
        emri.text = intent.getStringExtra("emri")
        perberesit.text = intent.getStringExtra("perberesit")
        kaloritePerPorcion.text = intent.getStringExtra("kalorite")
    }
}
