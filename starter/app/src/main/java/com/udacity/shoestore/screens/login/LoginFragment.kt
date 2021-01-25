package com.udacity.shoestore.screens.login

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentLoginBinding.inflate(inflater).run {
            binding = this
            loginButton.setOnClickListener {
                if (isLoginValid()) navigateToWelcomeScreen(it)
            }
            registerButton.setOnClickListener {
                if (isLoginValid()) navigateToWelcomeScreen(it)
            }
            root
        }
    }

    private fun isLoginValid(): Boolean {
        return when {
            binding.username.text.isEmpty() -> {
                Toast.makeText(requireContext(), getString(R.string.username_is_empty), Toast.LENGTH_SHORT).show()
                false
            }
            binding.password.text.isEmpty() -> {
                Toast.makeText(requireContext(), getString(R.string.password_is_empty), Toast.LENGTH_SHORT).show()
                false
            }
            else -> {
                binding.username.text = null
                binding.password.text = null
                true
            }
        }
    }

    private fun navigateToWelcomeScreen(view: View) {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }
}