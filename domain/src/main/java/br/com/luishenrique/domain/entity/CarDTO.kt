package br.com.luishenrique.domain.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class CarDTO(
    @SerializedName("ID") val id: Int,
    @SerializedName("Make") val make: String,
    @SerializedName("Model") val model: String,
    @SerializedName("Version") val version: String,
    @SerializedName("Image") var image: String,
    @SerializedName("KM") val kM: Int,
    @SerializedName("Price") val price: String,
    @SerializedName("YearModel") val yearModel: Int,
    @SerializedName("YearFab") val yearFab: Int,
    @SerializedName("Color") val color: String,
    val isFavorite: Boolean = false
) : Serializable {
    constructor() : this(
        0,
        "",
        "",
        "",
        "",
        0,
        "",
        0,
        0,
        ""
    )
}