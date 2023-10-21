package com.dbvertex.quizappnew.Presentation.NestedSubcategories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dbvertex.quizappnew.databinding.FargNestedSubcategoriesBinding
import com.dbvertex.quizappnew.databinding.FragAllgoalsSubcategoriesBinding

class NestedSubcategoryFragment : Fragment(), NestedSubcategoryInteface {
    lateinit var mbinding:FargNestedSubcategoriesBinding
    lateinit var allGoalsAdapter: NestedSubcategoryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mbinding = FargNestedSubcategoriesBinding.inflate(inflater, container, false)
        return mbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mbinding.backtool.back.setOnClickListener {
            findNavController().navigateUp()
        }

        val allGoalsDTO1 = NestedCategoryDTO(
            "Pre-Primary",
            "Capital Letters",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO2 = NestedCategoryDTO(
            "Primary",
            "Small Letters",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO3 = NestedCategoryDTO(
            "Competitive Exams",
            "Pictures",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO4 = NestedCategoryDTO(
            "Pre-Primary",
            "Capital Letters",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO5 = NestedCategoryDTO(
            "Pre-Primary",
            "Small Letters",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        val allGoalsDTO6 = NestedCategoryDTO(
            "Pre-Primary",
            "Pictures",
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I"
        )
        allGoalsAdapter =
            NestedSubcategoryAdapter(listOf(allGoalsDTO1, allGoalsDTO2, allGoalsDTO3, allGoalsDTO4,allGoalsDTO5,allGoalsDTO6), this)
        mbinding.allGoalsRV.adapter = allGoalsAdapter
        allGoalsAdapter.notifyDataSetChanged()


    }

    override fun onClickSingleAllGoal(allGoalsDTO: NestedCategoryDTO) {
        Toast.makeText(requireContext(), allGoalsDTO.title.toString(), Toast.LENGTH_SHORT).show()
    }
}