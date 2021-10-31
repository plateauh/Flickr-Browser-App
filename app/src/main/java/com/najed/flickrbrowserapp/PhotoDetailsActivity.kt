package com.najed.flickrbrowserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class PhotoDetailsActivity : AppCompatActivity() {

    lateinit var photoImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_details)
        val photoURL = intent.getStringExtra("photoURL")
        photoImageView = findViewById(R.id.photo_expanded_iv)
        Glide.with(this)
            .load("${photoURL}_b.jpg")
            .into(photoImageView)
    }
}