package com.dbvertex.quiz_app.Auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.dbvertex.quizappnew.R
import com.dbvertex.quizappnew.databinding.FragmnetLoginBinding


class Login:Fragment() {
    lateinit var loginBinding: FragmnetLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding= FragmnetLoginBinding.inflate(inflater,container,false)
        return loginBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginBinding.next.setOnClickListener {
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.splash, true).build()
//            findNavController().navigate(
//                R.id.action_login_to_playtolearn2, null, navOptions
//            )
        }


    }
}