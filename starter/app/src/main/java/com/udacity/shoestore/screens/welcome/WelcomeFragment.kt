package com.udacity.shoestore.screens.welcome

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentWelcomeBinding.inflate(inflater).run{
            welcomeText1.movementMethod = ScrollingMovementMethod()
            welcomeText2.movementMethod = ScrollingMovementMethod()
            root
        }
    }
}