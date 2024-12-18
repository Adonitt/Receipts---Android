package com.example.project1.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.activity.ComponentActivity
import com.example.project1.R
import com.example.project1.adapters.ReceiptAdapter
import com.example.project1.models.ReceiptModel

class ListActivity : ComponentActivity() {

    private lateinit var itemsList: ListView
    private lateinit var btnLessCalories: Button
    private lateinit var btnMoreCalories: Button
    private lateinit var btnFavorites: Button
    private lateinit var receiptAdapter: ReceiptAdapter
    private val fullReceiptsList = mutableListOf<ReceiptModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.receipt_list)

        itemsList = findViewById(R.id.items_list)
        btnLessCalories = findViewById(R.id.btn_less_calories)
        btnMoreCalories = findViewById(R.id.btn_more_calories)
        btnFavorites = findViewById(R.id.btn_favorites)

        fullReceiptsList.addAll(
            listOf(
                ReceiptModel(1, R.drawable.fli, "Flia", "Maze, qumesht", 2.5),
                ReceiptModel(2, R.drawable.pite, "Pite", "Maze, qumesht", 2.0),
                ReceiptModel(3, R.drawable.fergese, "Fërgesë", "Speca, djathë", 3.5),
                ReceiptModel(4, R.drawable.sarma, "Sarma", "Lakër, mish", 4.0),
                ReceiptModel(5, R.drawable.tave, "Tavë Elbasani", "Mish, kos", 5.0),
                ReceiptModel(6, R.drawable.qofte, "Qofte", "Mish i grirë, erëza", 3.0),
                ReceiptModel(7, R.drawable.buerk, "Byrek", "Spinaq, djathë", 2.0),
                ReceiptModel(8, R.drawable.bakllava, "Bakllava", "Arrë, petë, sherbet", 3.5),
                ReceiptModel(9, R.drawable.kukurec, "Kukurec", "Zorra, mish", 4.5),
                ReceiptModel(10, R.drawable.petulla, "Petulla", "Mjaltë, sheqer pluhur", 2.0),
                ReceiptModel(11, R.drawable.fli, "Fli", "Petë, vezë, qumësht", 2.5),
                ReceiptModel(12, R.drawable.fasule, "Jani me Fasule", "Fasule, domate", 3.0),
                ReceiptModel(13, R.drawable.tavekosi, "Tavë Kosi", "Oriz, mish, kos", 4.0),
                ReceiptModel(14, R.drawable.speca, "Speca të Mbushura", "Speca, mish, oriz", 3.5),
                ReceiptModel(15, R.drawable.qumeshtor, "Qumështor", "Qumësht, sheqer, vezë", 2.0),
                ReceiptModel(16, R.drawable.shendetli, "Shëndetli", "Mjaltë, arra", 3.0),
                ReceiptModel(17, R.drawable.ballokume, "Ballokume", "Miell misri, sheqer", 2.5),
                ReceiptModel(18, R.drawable.tullumba, "Tullumbace", "Petë, sherbet", 2.0),
                ReceiptModel(19, R.drawable.ajke, "Krap me Mazë", "Peshk, speca", 5.5),
                ReceiptModel(20, R.drawable.pace, "Paçe", "Kokë mishi, speca djegës", 4.0)
            )
        )

        receiptAdapter = ReceiptAdapter(this, fullReceiptsList)
        itemsList.adapter = receiptAdapter

        btnLessCalories.setOnClickListener { sortReceiptsByCalories(ascending = true) }
        btnMoreCalories.setOnClickListener { sortReceiptsByCalories(ascending = false) }

        btnFavorites.setOnClickListener {
            receiptAdapter.showFavorites()
        }

        itemsList.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = receiptAdapter.getItem(position) as ReceiptModel
            val intent = Intent(this, DetailsActivity::class.java)

            intent.putExtra("id", selectedItem.id.toString())
            intent.putExtra("image", selectedItem.image)
            intent.putExtra("emri", selectedItem.emri)
            intent.putExtra("perberesit", selectedItem.perberesit)
            intent.putExtra("kalorite", selectedItem.kaloriPerPorcion)

            startActivity(intent)
        }
    }

    private fun sortReceiptsByCalories(ascending: Boolean) {
        val sortedList = if (ascending) {
            fullReceiptsList.sortedBy { it.kaloriPerPorcion }
        } else {
            fullReceiptsList.sortedByDescending { it.kaloriPerPorcion }
        }
        receiptAdapter = ReceiptAdapter(this, sortedList)
        itemsList.adapter = receiptAdapter
    }
}
