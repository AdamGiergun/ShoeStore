package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentInstructionsBinding.inflate(inflater).run{
            instructionsText1.movementMethod = ScrollingMovementMethod()
            instructionsText2.movementMethod = ScrollingMovementMethod()
            root
        }
    }
}