package com.example.myretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // API arayüzünü oluştur
        val apiInterface = retrofit.create(ApiInterface::class.java)

        // API isteğini gönder
        apiInterface.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    val posts = response.body()
                    println(posts)
                    // Sonuçları kullanın
                } else {
                    // Hata durumunda
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                // Hata durumunda


            }
        })

    }


}
