package com.example.project1.models

import java.io.Serializable

data class ReceiptModel(
    var id: Int,
    var image: Int,
    var emri: String,
    var perberesit: String,
    var kaloriPerPorcion: Double
)
