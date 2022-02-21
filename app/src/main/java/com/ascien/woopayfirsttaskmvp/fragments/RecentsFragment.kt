package com.ascien.woopayfirsttaskmvp.fragments

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.ascien.woopayfirsttaskmvp.R
import com.ascien.woopayfirsttaskmvp.databinding.FragmentFavouritesBinding
import com.ascien.woopayfirsttaskmvp.databinding.FragmentRecentsBinding
import com.ascien.woopayfirsttaskmvp.presenter.FactPresenter
import com.squareup.picasso.Picasso

class RecentsFragment : Fragment() {
    lateinit var binding: FragmentRecentsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecentsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var input = binding.etEnter.text
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            if (input.isEmpty()) {
                Toast.makeText(requireContext(), "Недостаточно символов", Toast.LENGTH_SHORT).show()
            } else {
                Picasso.get().load("https://cataas.com/cat/says/$input").into(binding.ivImage)
            }
        }
    }
}