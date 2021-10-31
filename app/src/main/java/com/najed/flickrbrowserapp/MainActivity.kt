package com.najed.flickrbrowserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getPhotos()
    }

    private fun getPhotos(){
        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        val call: Call<Photos?>? = apiInterface!!.getPhotos("cat")
        call?.enqueue(object: Callback<Photos?> {
            override fun onResponse(call: Call<Photos?>, response: Response<Photos?>) {
                var photos = response.body()!!
                Log.d("response", "$photos")
            }
            override fun onFailure(call: Call<Photos?>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
                call.cancel()
            }
        })
    }
}