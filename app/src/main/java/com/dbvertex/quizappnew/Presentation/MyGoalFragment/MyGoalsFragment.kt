package com.dbvertex.quizappnew.Presentation.MyGoalFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dbvertex.quizappnew.R
import com.dbvertex.quizappnew.databinding.FragMygoalBinding
import com.dbvertex.quizappnew.databinding.FragmentAllGoalsBinding

class MyGoalsFragment : Fragment(), MyGoalsInteface, MygoalSliderInterface {
    lateinit var mbinding: FragMygoalBinding
    lateinit var allGoalsAdapter: MyGoalsAdapter
    lateinit var mygoalSliderAdapter: MygoalSliderAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mbinding = FragMygoalBinding.inflate(inflater, container, false)
        return mbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mbinding.backtool.back.setOnClickListener {
            findNavController().navigateUp()
        }

        val sliderlist = listOf<MyGoalSliderDto>(
            MyGoalSliderDto(
                "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
                "All"
            ),

            MyGoalSliderDto(
                "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
                "English"
            ),

            MyGoalSliderDto(
                "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
                "Hindi"
            ),
            MyGoalSliderDto(
                "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
                "Maths"
            ),
            MyGoalSliderDto(
                "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
                "Colors"
            ),
            MyGoalSliderDto(
                "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
                "Animals"
            ),
            MyGoalSliderDto(
                "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
                "Maths"
            ),
            MyGoalSliderDto(
                "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
                "Colors"
            ),
            MyGoalSliderDto(
                "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
                "Animals"
            )

        )

        mygoalSliderAdapter = MygoalSliderAdapter(sliderlist, this)
        mbinding.slider.adapter = mygoalSliderAdapter
        mygoalSliderAdapter.notifyDataSetChanged()

        val allGoalsDTO1 = MyGoalsDTO(
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            true,
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            "Capital Latter"
        )
        val allGoalsDTO2 = MyGoalsDTO(
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            true,
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            "Capital Latter"
        )
        val allGoalsDTO3 = MyGoalsDTO(
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            true,
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            "Capital Latter"
        )
        val allGoalsDTO4 = MyGoalsDTO(
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            true,
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            "Capital Latter"

        )
        val allGoalsDTO5 = MyGoalsDTO(
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            true,
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            "Capital Latter"
        )
        val allGoalsDTO6 = MyGoalsDTO(
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            true,
            "https://fastly.picsum.photos/id/6/5000/3333.jpg?hmac=pq9FRpg2xkAQ7J9JTrBtyFcp9-qvlu8ycAi7bUHlL7I",
            "Capital Latter"
        )

        mbinding.allGoalsRV.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        allGoalsAdapter =
            MyGoalsAdapter(
                listOf(
                    allGoalsDTO1,
                    allGoalsDTO2,
                    allGoalsDTO3,
                    allGoalsDTO4,
                    allGoalsDTO5,
                    allGoalsDTO6
                ), this
            )
        mbinding.allGoalsRV.adapter = allGoalsAdapter
        allGoalsAdapter.notifyDataSetChanged()


    }

    override fun onClickSingleAllGoal(allGoalsDTO: MyGoalsDTO) {
        Toast.makeText(requireContext(), allGoalsDTO.title.toString(), Toast.LENGTH_SHORT).show()
        //findNavController().navigate(R.id.action_allGoalsFragment_to_allGoalsSubcategoryFragment)
    }

    override fun onClickSingleMyGoalSlider(myGoalSliderDto: MyGoalSliderDto) {
        Toast.makeText(requireContext(), myGoalSliderDto.title.toString(), Toast.LENGTH_SHORT)
            .show()

    }
}