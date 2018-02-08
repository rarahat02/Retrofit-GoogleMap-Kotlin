package com.example.bs206.retrofittest.java.a;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bs206.retrofittest.R;
import com.example.bs206.retrofittest.java.a.adapter.DataAdapter;
import com.example.bs206.retrofittest.java.a.model.Data;
import com.example.bs206.retrofittest.java.a.rest.ApiClient;
import com.example.bs206.retrofittest.java.a.rest.ApiInterface;
import com.example.bs206.retrofittest.kotlin.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerticalListActivity extends AppCompatActivity
{

    ArrayList<Data> movieTemp;

    private Double device_latitude;
    private Double device_longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_list_view);

        device_latitude = getIntent().getExtras().getDouble(Constants.getDEVICE_LATI());
        device_longitude = getIntent().getExtras().getDouble(Constants.getDEVICE_LONGI());

        movieTemp = new ArrayList<>();

        final RecyclerView recyclerView = findViewById(R.id.data_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Data>> call = apiService.getDataLists();


        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading");
        pd.show();

        call.enqueue(new Callback<List<Data>>()
        {
            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response)
            {
                int statusCode = response.code();


                if(response.body() != null)
                {

                    movieTemp = (ArrayList<Data>) response.body();

                    pd.dismiss();

                    Log.v("rahat", movieTemp.get(0) + "dsdsd");
                    recyclerView.setAdapter(new DataAdapter(movieTemp, R.layout.list_item_data, getApplicationContext()));
                    recyclerView.setHasFixedSize(true);
                }
                else
                    Log.v("rahatnull", "null received    response code " + statusCode);

            }

            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
                // Log error here since request failed
                Log.e(Constants.getTAG(), t.toString());
                Toast.makeText(getApplicationContext(), "onFailure failed", Toast.LENGTH_SHORT).show();
                pd.dismiss();
            }
        });

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener()
                        {
                    @Override public void onItemClick(View view, int position)
                    {
                        movieTemp.get(position);

                        Intent intent = new Intent(getBaseContext(), MapsActivity.class);

                        intent.putExtra(Constants.getLATI(), movieTemp.get(position).getLatitude());
                        intent.putExtra(Constants.getLONGI(), movieTemp.get(position).getLongitude());

                        intent.putExtra(Constants.getDEVICE_LATI(), device_latitude);
                        intent.putExtra(Constants.getDEVICE_LONGI(), device_longitude);

                        Log.v(Constants.getTAG(), "latitude " + device_latitude + "longitude " + device_longitude);

                        startActivity(intent);
                    }

                    @Override public void onLongItemClick(View view, int position)
                    {
                        // do whatever
                    }
                })
        );
    }

}
