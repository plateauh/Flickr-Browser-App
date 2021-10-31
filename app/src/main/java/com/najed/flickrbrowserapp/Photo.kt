package com.najed.flickrbrowserapp

import com.google.gson.annotations.SerializedName

data class PhotoCollection (
        @SerializedName("photos")
        val photos: Photos,

        @SerializedName("stat")
        val stat: String
        )

data class Photos (
        @SerializedName("photo")
        val photo: List<Photo>,

        @SerializedName("total")
        val total: Int
        )

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
