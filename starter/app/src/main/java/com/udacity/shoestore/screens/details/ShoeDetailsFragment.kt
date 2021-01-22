package com.udacity.shoestore.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentShoeDetailsBinding.inflate(inflater).run {
            cancelButton.setOnClickListener {
                navigateToShoeList()
            }
            saveButton.setOnClickListener {
                saveShoe()
                navigateToShoeList()
            }
            root
        }
    }

    private fun navigateToShoeList() {
        findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
    }

    private fun saveShoe() {

    }
}