package com.najed.flickrbrowserapp

import com.google.gson.annotations.SerializedName

class Photos: ArrayList<Photo>()

data class Photo (
        @SerializedName("id")
        val id: String,

        @SerializedName("owner")
        val owner: String,

        @SerializedName("secret")
        val secret: String,

        @SerializedName("server")
        val server: String,

        @SerializedName("title")
        val title: String
)