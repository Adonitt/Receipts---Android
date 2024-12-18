package com.example.project1.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.project1.R
import com.example.project1.models.ReceiptModel

class ReceiptAdapter(private val context: Context, private var data: List<ReceiptModel>) :
    BaseAdapter() {

    private val favoriteItems = mutableListOf<ReceiptModel>()
    override fun getCount(): Int = data.size

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = data[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.receipt_list_item, parent, false)

        val item = data[position]

        view.findViewById<TextView>(R.id.id).text = "${item.id}"
        view.findViewById<ImageView>(R.id.item_image).setImageResource(item.image)
        view.findViewById<TextView>(R.id.item_name).text = item.emri
        view.findViewById<TextView>(R.id.perberesit_item).text = item.perberesit
        view.findViewById<TextView>(R.id.kalorite_item).text = "${item.kaloriPerPorcion} Kcal"

        val addToFavoritesBtn = view.findViewById<AppCompatButton>(R.id.add_to_favorites_button)


        addToFavoritesBtn.setOnClickListener {
            if (!favoriteItems.contains(item)) {
                favoriteItems.add(item)
                Toast.makeText(context, "${item.emri} added to favorites!", Toast.LENGTH_LONG)
                    .show()
            } else {
                Toast.makeText(context, "${item.emri} is already in favorites", Toast.LENGTH_LONG)
                    .show()
            }
        }
        return view
    }

    fun showFavorites() {
        if (favoriteItems.isEmpty()) {
            Toast.makeText(context, "No favorites selected", Toast.LENGTH_SHORT).show()
            return
        }
        data = favoriteItems
        notifyDataSetChanged()
    }
}
