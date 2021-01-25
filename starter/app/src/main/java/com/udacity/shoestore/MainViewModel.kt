package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class MainViewModel: ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    fun addShoe(name: String, company: String, size: Double, description: String) {
        val shoe = Shoe(name, size, company, description)
        if (_shoeList.value != null)
            _shoeList.value?.add(shoe)
        else
            _shoeList.value = mutableListOf(shoe)
    }
}