package com.dbvertex.quizappnew.Presentation.LevelDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dbvertex.quizappnew.databinding.FragLevelBinding

class LevelDetail:Fragment() {
    lateinit var lvlbinding:FragLevelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lvlbinding= FragLevelBinding.inflate(inflater,container,false)
        return lvlbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}