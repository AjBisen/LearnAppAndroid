package com.dbvertex.quiz_app.Intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

import com.dbvertex.quiz_app.Utill.hidemenu
import com.dbvertex.quizappnew.R
import com.dbvertex.quizappnew.databinding.FragmnetIntroOneBinding


class Introone:Fragment() {
    lateinit var introOneBinding: FragmnetIntroOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        introOneBinding=FragmnetIntroOneBinding.inflate(inflater,container,false)
        return introOneBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hidemenu()

        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Handle the back button event
                requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this.viewLifecycleOwner,
            onBackPressedCallback
        )

        introOneBinding.next.setOnClickListener {
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.splash, true).build()
            findNavController().navigate(
                R.id.action_introone_to_signup, null, navOptions
            )
        }
    }
}