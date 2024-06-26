package com.o5appstudio.travelappui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.o5appstudio.travelappui.CategoryListAdapter
import com.o5appstudio.travelappui.R
import com.o5appstudio.travelappui.TopTripListAdapter
import com.o5appstudio.travelappui.consts.catList
import com.o5appstudio.travelappui.consts.tripList
import com.o5appstudio.travelappui.model.Category
import com.o5appstudio.travelappui.model.TopTrip

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val categoryRecycler: RecyclerView = view.findViewById(R.id.categoryList)
        val tripRecycler: RecyclerView = view.findViewById(R.id.topTripList)

        categoryRecycler.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        tripRecycler.layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)

        val catAdapter = CategoryListAdapter(view.context, catList)
        val tripAdapter = TopTripListAdapter(view.context, tripList)

        tripRecycler.adapter = tripAdapter
        categoryRecycler.adapter = catAdapter

        return view
    }
}