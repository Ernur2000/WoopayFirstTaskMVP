package com.ascien.woopayfirsttaskmvp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.ascien.woopayfirsttaskmvp.R
import com.ascien.woopayfirsttaskmvp.databinding.ActivityMainBinding
import com.ascien.woopayfirsttaskmvp.fragments.FavouritesFragment
import com.ascien.woopayfirsttaskmvp.fragments.NearbyFragment
import com.ascien.woopayfirsttaskmvp.fragments.RecentsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val recentsFragment = RecentsFragment()
    private val favouritesFragment = FavouritesFragment()
    private val nearbyFragment = NearbyFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        replaceFragment(recentsFragment)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.ic_recent -> replaceFragment(recentsFragment)
                R.id.ic_favourites -> replaceFragment(favouritesFragment)
                R.id.ic_nearby -> replaceFragment(nearbyFragment)

            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }
}