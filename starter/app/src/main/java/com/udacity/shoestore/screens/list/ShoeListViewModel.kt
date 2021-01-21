package com.udacity.shoestore.screens.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<Shoe>()
    val shoeList: LiveData<Shoe>
        get() = _shoeList
}