package com.example.bs206.retrofittest.java.a.rest;

import com.example.bs206.retrofittest.java.a.model.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface
{
    @GET("home/atmData/")
    Call<List<Data>> getDataLists();

/*    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);*/
}
