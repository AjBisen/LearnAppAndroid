package com.dbvertex.quizappnew.Presentation.Allgoals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dbvertex.quizappnew.R
import com.dbvertex.quizappnew.databinding.FragmentAllGoalsBinding

class AllGoalsFragment : Fragment(), AllGoalsInteface {
    lateinit var mbinding: FragmentAllGoalsBinding
    lateinit var allGoalsAdapter: AllGoalsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mbinding = FragmentAllGoalsBinding.inflate(inflater, container, false)
        return mbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mbinding.backtool.back.setOnClickListener {
            findNavController().navigateUp()
        }

        val allGoalsDTO1 = AllGoalsDTO(
            "Pre-Primary",
            "Kinder Garden",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO2 = AllGoalsDTO(
            "Primary",
            "Grade 1",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO3 = AllGoalsDTO(
            "Competitive Exams",
            "IAS",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO4 = AllGoalsDTO(
            "Pre-Primary",
            "Kinder Garden",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO5 = AllGoalsDTO(
            "Pre-Primary",
            "Kinder Garden",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO6 = AllGoalsDTO(
            "Pre-Primary",
            "Kinder Garden",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        allGoalsAdapter =
            AllGoalsAdapter(listOf(allGoalsDTO1, allGoalsDTO2, allGoalsDTO3, allGoalsDTO4,allGoalsDTO5,allGoalsDTO6), this)
        mbinding.allGoalsRV.adapter = allGoalsAdapter
        allGoalsAdapter.notifyDataSetChanged()


    }

    override fun onClickSingleAllGoal(allGoalsDTO: AllGoalsDTO) {
        Toast.makeText(requireContext(), allGoalsDTO.title.toString(), Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_allGoalsFragment_to_allGoalsSubcategoryFragment)
    }
}