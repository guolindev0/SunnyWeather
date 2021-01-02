package com.sunnyweather.android.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweather.android.logic.Repository
import com.sunnyweather.android.model.Place
import retrofit2.http.Query
import java.util.ArrayList

class PlaceViewModel:ViewModel() {
    private val searchLiveData=MutableLiveData<String>()

    val placeList=ArrayList<Place>()

    val placeLiveData=Transformations.switchMap(searchLiveData){query->
        Repository.searchPlaces(query)

    }
    fun searchPlaces(query: String){
        searchLiveData.value=query
    }
}