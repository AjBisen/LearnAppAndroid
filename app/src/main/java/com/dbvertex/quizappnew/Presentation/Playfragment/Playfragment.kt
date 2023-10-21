package com.dbvertex.quizappnew.Presentation.Playfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dbvertex.quizappnew.databinding.FragmentPlayBinding

class Playfragment : Fragment(), PlayInterface {
    lateinit var playBinding: FragmentPlayBinding
    lateinit var playAdapter: PlayAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        playBinding = FragmentPlayBinding.inflate(inflater, container, false)
        return playBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playBinding.backtool.back.setOnClickListener {
            findNavController().navigateUp()
        }
        playAdapter = PlayAdapter(
            listOf(

                PlayDTO(
                    "https://fastly.picsum.photos/id/24/4855/1803.jpg?hmac=ICVhP1pUXDLXaTkgwDJinSUS59UWalMxf4SOIWb9Ui4",
                    "English"
                ),
                PlayDTO(
                    "https://fastly.picsum.photos/id/24/4855/1803.jpg?hmac=ICVhP1pUXDLXaTkgwDJinSUS59UWalMxf4SOIWb9Ui4",
                    "Lesson 3"
                ),
                PlayDTO(
                    "https://fastly.picsum.photos/id/24/4855/1803.jpg?hmac=ICVhP1pUXDLXaTkgwDJinSUS59UWalMxf4SOIWb9Ui4",
                    "Vocabulary"
                ),
                PlayDTO(
                    "https://fastly.picsum.photos/id/24/4855/1803.jpg?hmac=ICVhP1pUXDLXaTkgwDJinSUS59UWalMxf4SOIWb9Ui4",
                    "General Knowledge"
                ),
                PlayDTO(
                    "https://fastly.picsum.photos/id/24/4855/1803.jpg?hmac=ICVhP1pUXDLXaTkgwDJinSUS59UWalMxf4SOIWb9Ui4",
                    "Asia"
                ),
                PlayDTO(
                    "https://fastly.picsum.photos/id/24/4855/1803.jpg?hmac=ICVhP1pUXDLXaTkgwDJinSUS59UWalMxf4SOIWb9Ui4",
                    "Capitals"
                ),
            ),this
        )
//        val layoutManager = GridLayoutManager(requireContext(), 3)
//
//        playBinding.allGoalsRV.layoutManager = layoutManager
        playBinding.allGoalsRV.adapter=playAdapter
        playAdapter.notifyDataSetChanged()

    }

    override fun onPlayItemclick(playDTO: PlayDTO) {
        Toast.makeText(requireContext(), playDTO.title.toString(), Toast.LENGTH_SHORT).show()
    }
}