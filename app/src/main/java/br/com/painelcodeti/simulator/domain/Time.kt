package br.com.painelcodeti.simulator.domain

import com.google.gson.annotations.SerializedName

data class Time (
    @SerializedName("nome")
    val nome: String,
    @SerializedName("forca")
    val star: Int,
    @SerializedName("imagem")
    val image: String
)