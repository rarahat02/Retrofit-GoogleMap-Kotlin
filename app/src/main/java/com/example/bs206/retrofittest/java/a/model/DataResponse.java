package com.example.bs206.retrofittest.java.a.model;

import com.example.bs206.retrofittest.java.a.model.Data;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DataResponse
{
    @SerializedName("results")
    private List<Data> results;



    public DataResponse(List<Data> results)
    {
        this.results = results;
    }

    public List<Data> getResults() {
        return results;
    }

    public void setResults(List<Data> results) {
        this.results = results;
    }
}
