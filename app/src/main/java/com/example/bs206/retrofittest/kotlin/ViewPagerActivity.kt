package com.example.bs206.retrofittest.kotlin

import android.app.ProgressDialog
import android.nfc.Tag
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.example.bs206.retrofittest.R
import com.example.bs206.retrofittest.java.a.adapter.DataAdapter
import com.example.bs206.retrofittest.java.a.model.Data
import com.example.bs206.retrofittest.java.a.rest.ApiClient
import com.example.bs206.retrofittest.java.a.rest.ApiInterface
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_view_pager.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import java.io.InputStream
import java.net.HttpURLConnection

class ViewPagerActivity : AppCompatActivity() {

   // private lateinit var movieTemp: ArrayList<KotlinData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        doRetrofitTasks()


        //AsyncTaskExample().execute(movieTemp);

    }

    fun doRetrofitTasks()
    {

        val apiService = ApiClient.getClient().create(KotlinApiInterface::class.java)

        val call = apiService.dataLists

        val pd = ProgressDialog(this)
        pd.setMessage("Loading")
        pd.show()

        call.enqueue(object : Callback<ArrayList<KotlinData>>
        {
            override fun onResponse(call: Call<ArrayList<KotlinData>>, response: Response<ArrayList<KotlinData>>) {
                val statusCode = response.code()


                if (response.body() != null) {

                    Log.v("rarahat02", "not null")

                    var movieTemp: ArrayList<KotlinData>

                    movieTemp = response.body() as ArrayList<KotlinData>

                    Log.v("rarahat02", movieTemp.size.toString())

                    pd.dismiss()

                    val adapter = ViewPagerAdapter(supportFragmentManager, movieTemp)
                    //adapter = ViewPagerAdapter(supportFragmentManager, movieTemp)
                    viewpager.adapter = adapter

                } else {
                    Log.v("rarahat02", "hello")
                }

            }

            override fun onFailure(call: Call<ArrayList<KotlinData>>, t: Throwable) {
                // Log error here since request failed
                Log.e(Constants.TAG, t.toString())

                Log.v("rarahat02", "failed")

                Toast.makeText(applicationContext, "onFailure failed", Toast.LENGTH_SHORT).show()
                pd.dismiss()
            }
        })

    }
}



data class KotlinData(@field:SerializedName("address") var address: String,
                 @field:SerializedName("district") var district: String,
                 @field:SerializedName("latitude") var latitude: Double,
                 @field:SerializedName("longitude") var longitude: Double,
                 @field:SerializedName("name_of_atm") var nameOfAtm: String,
                 @field:SerializedName("sl") var slNum: Int,
                 @field:SerializedName("town_city") var townCity: String)


interface KotlinApiInterface
{
    @get:GET("home/atmData/")
    var dataLists: Call<ArrayList<KotlinData>>

    /*    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);*/
}

