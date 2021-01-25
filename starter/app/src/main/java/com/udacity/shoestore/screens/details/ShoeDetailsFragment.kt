package com.udacity.shoestore.screens.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment: Fragment() {

    private val viewModel by activityViewModels<MainViewModel>()
    private lateinit var binding: FragmentShoeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentShoeDetailsBinding.inflate(inflater).run {
            binding = this
            cancelButton.setOnClickListener {
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragmentCancel())
            }
            saveButton.setOnClickListener {
                saveShoe()
                findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragmentSave())
            }
            root
        }
    }

    private fun saveShoe() {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        binding.run {
            viewModel.addShoe(
                nameText.text.toString(),
                companyText.text.toString(),
                sizeText.text.toString().toDouble(),
                descriptionText.text.toString()
            )
            imm.hideSoftInputFromWindow(root.windowToken, 0)
        }
    }
}