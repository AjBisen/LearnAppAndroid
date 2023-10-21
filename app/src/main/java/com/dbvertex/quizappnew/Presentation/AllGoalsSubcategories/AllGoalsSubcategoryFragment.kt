package com.dbvertex.quizappnew.Presentation.AllGoalsSubcategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dbvertex.quizappnew.R
import com.dbvertex.quizappnew.databinding.FragAllgoalsSubcategoriesBinding


class AllGoalsSubcategoryFragment : Fragment(), AllGoalsSubcategoryInteface {
    lateinit var mbinding: FragAllgoalsSubcategoriesBinding
    lateinit var allGoalsAdapter: AllGoalsSubcategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mbinding = FragAllgoalsSubcategoriesBinding.inflate(inflater, container, false)
        return mbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mbinding.backtool.back.setOnClickListener {
            findNavController().navigateUp()
        }

        val allGoalsDTO1 = AllGoalsCategoryDTO(
            "Pre-Primary",
            "Alphabets",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO2 = AllGoalsCategoryDTO(
            "Primary",
            "Numbers",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO3 = AllGoalsCategoryDTO(
            "Competitive Exams",
            "Colors",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO4 = AllGoalsCategoryDTO(
            "Pre-Primary",
            "Alphabets",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO5 = AllGoalsCategoryDTO(
            "Pre-Primary",
            "Numbers",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO6 = AllGoalsCategoryDTO(
            "Pre-Primary",
            "Colors",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        allGoalsAdapter =
            AllGoalsSubcategoryAdapter(listOf(allGoalsDTO1, allGoalsDTO2, allGoalsDTO3, allGoalsDTO4,allGoalsDTO5,allGoalsDTO6), this)
        mbinding.allGoalsRV.adapter = allGoalsAdapter
        allGoalsAdapter.notifyDataSetChanged()


    }

    override fun onClickSingleAllGoal(allGoalsDTO: AllGoalsCategoryDTO) {
        Toast.makeText(requireContext(), allGoalsDTO.title.toString(), Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_allGoalsSubcategoryFragment_to_nestedSubcategoryFragment)
    }
}