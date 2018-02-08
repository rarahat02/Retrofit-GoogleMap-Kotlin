package com.example.bs206.retrofittest.kotlin

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bs206.retrofittest.R
import com.example.bs206.retrofittest.R.id.*
import com.example.bs206.retrofittest.java.a.model.Data
import kotlinx.android.synthetic.main.fragment_category.*


/**
 * Created by deepshikha on 12/9/17.
 */
class CategoryFragment : Fragment()
{
    var dataList = ArrayList<KotlinData>()

    var position = 0


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

         var view = inflater.inflate(R.layout.fragment_category, container, false)
        //fn_arraylist()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init()
    {
        position = arguments?.getInt("position")!!
        sl.setText(dataList.get(position).slNum.toString())
        address.setText(dataList.get(position).address)
        latitude.setText(dataList.get(position).latitude.toString())
        longitude.setText(dataList.get(position).longitude.toString())
        district.setText(dataList.get(position).district)
        name_of_atm.setText(dataList.get(position).nameOfAtm)
        town_city.setText(dataList.get(position).townCity)

    }

    fun fn_arraylist()
    {
        dataList.add(KotlinData("BURJ KHALIFA", "#f9b994", 212.343, 23.43, "sdsd", 323, "Dhaka"))
        dataList.add(KotlinData("Taj Mahal", "#bdf3f7", 21.32, 323.3, "dsds", 123, "Dhaka"))
    }
}