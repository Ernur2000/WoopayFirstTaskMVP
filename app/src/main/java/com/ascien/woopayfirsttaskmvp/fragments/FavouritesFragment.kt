package com.ascien.woopayfirsttaskmvp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ascien.woopayfirsttaskmvp.R
import com.ascien.woopayfirsttaskmvp.databinding.FragmentFavouritesBinding
import com.ascien.woopayfirsttaskmvp.interfaces.FactInterface
import com.ascien.woopayfirsttaskmvp.presenter.FactPresenter

class FavouritesFragment : Fragment(),FactInterface.FactView{
    lateinit var binding: FragmentFavouritesBinding
    private var presenter:FactPresenter?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavouritesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = FactPresenter(this)

        binding.btnFact.setOnClickListener {
            presenter?.networkCall()
        }
    }

    override fun updateViewData() {
        binding.tvRecent.text = presenter?.showFact()
    }
}