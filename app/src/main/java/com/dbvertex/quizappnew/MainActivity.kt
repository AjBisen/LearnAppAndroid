package com.dbvertex.quizappnew

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.dbvertex.quiz_app.Utill.temp_show_toast
import com.dbvertex.quizappnew.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    private lateinit var mNavController: NavController
    private lateinit var navHostFragment:NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mainBinding.root)

        navHostFragment = supportFragmentManager.findFragmentById(com.dbvertex.quizappnew.R.id.nav_host_fragment) as NavHostFragment
        mNavController = navHostFragment.navController

        mainBinding.wallShare.setOnClickListener {
            mNavController.popBackStack()
            mNavController.navigate(com.dbvertex.quizappnew.R.id.dashboard)
        }
        mainBinding.fab.setOnClickListener {
            mNavController.navigate(com.dbvertex.quizappnew.R.id.playfragment)

        }


        mNavController.addOnDestinationChangedListener { _, destination, _ ->

            if (destination.id == com.dbvertex.quizappnew.R.id.allGoalsFragment) {

            }
        }
    }

}