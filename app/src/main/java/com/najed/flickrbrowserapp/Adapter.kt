package com.najed.flickrbrowserapp

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.najed.flickrbrowserapp.databinding.PhotoItemBinding

class Adapter (val context: Context, val photos: PhotoCollection): RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    class ItemViewHolder (val binding: PhotoItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(PhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val photo = photos.photos.photo[position]
        holder.binding.apply {
            titleTv.text = photo.title
            Glide.with(context)
                .load(fetchPhoto(photo))
                .into(photoIv)
        }
    }

    override fun getItemCount() = photos.photos.photo.size

    private fun fetchPhoto (photo: Photo): String {
        return "https://live.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}_s.jpg"
    }
}