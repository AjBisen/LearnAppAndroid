package com.dbvertex.quizappnew

import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.dbvertex.quiz_app.Dashboard.SharedPrefrenceHelper

import com.dbvertex.quiz_app.Utill.hidemenu
import com.dbvertex.quiz_app.Utill.temp_show_toast
import com.dbvertex.quizappnew.databinding.FragmentSplashBinding


class Splash : Fragment() {
    lateinit var bindingSplash: FragmentSplashBinding
//    lateinit var userDAO: UserDAO
//    lateinit var userRepository: UserRepository
//    lateinit var viewModel: ViewModelProvider


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingSplash = FragmentSplashBinding.inflate(inflater, container, false)
        return bindingSplash.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hidemenu()




        // viewModel.deleteAll()
        Handler(Looper.myLooper()!!).postDelayed(object : Runnable {

            override fun run() {


                val navOptions = NavOptions.Builder().setPopUpTo(R.id.splash, true).build()
                if (!SharedPrefrenceHelper.email.toString().equals("0")) {
                    findNavController().navigate(
                        R.id.action_splash_to_dashboard, null, navOptions

                    )
                }

                if (SharedPrefrenceHelper.email.toString().equals("0")) {
                    findNavController().navigate(
                        R.id.action_splash_to_introone, null, navOptions
                    )
                }


            }
        }, 2000)
    }
}