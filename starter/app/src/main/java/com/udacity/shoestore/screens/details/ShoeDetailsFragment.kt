package com.udacity.shoestore.screens.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.MainViewModel
import com.udacity.shoestore.R
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
                if (saveShoe()) findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragmentSave())
            }
            root
        }
    }

    private fun saveShoe(): Boolean {
        return binding.run {
            if (nameText.text.isEmpty() || companyText.text.isEmpty() ||
            sizeText.text.isEmpty() || descriptionText.text.isEmpty()) {
                Toast.makeText(requireContext(), getString(R.string.fill_in_all_fields), Toast.LENGTH_SHORT).show()
                false
            } else {
                viewModel.addShoe(
                    nameText.text.toString(),
                    companyText.text.toString(),
                    sizeText.text.toString().toDouble(),
                    descriptionText.text.toString()
                )
                val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(root.windowToken, 0)
                true
            }
        }
    }
}