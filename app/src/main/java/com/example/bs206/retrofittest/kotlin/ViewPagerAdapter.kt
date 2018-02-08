package com.example.bs206.retrofittest.kotlin

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.bs206.retrofittest.java.a.model.Data

class ViewPagerAdapter(fm: FragmentManager, var dataList :ArrayList<KotlinData>) : FragmentPagerAdapter(fm)
{
    override fun getCount(): Int =  dataList.size

    override fun getItem(position: Int): CategoryFragment
    {

        var bundle = Bundle()

        bundle.putInt("position", position)

        var categoryfragment = CategoryFragment()

        categoryfragment.arguments = bundle
        categoryfragment.dataList = this.dataList

        return categoryfragment

    }



}