package com.dbvertex.quiz_app.Intro



import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.dbvertex.quiz_app.Utill.hidemenu
import com.dbvertex.quizappnew.R
import com.dbvertex.quizappnew.databinding.FragSelGoalBinding


class Playtolearn : Fragment() {
    lateinit var binding: FragSelGoalBinding

    var isvisible = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragSelGoalBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hidemenu()

        binding.option1.setOnClickListener {
            isvisible = !isvisible
            if (isvisible == true) {
                binding.option1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_remove_24, 0)

                Log.d("exam", isvisible.toString())
                binding.examRv.visibility = View.VISIBLE
                val goalitem = goal_item_data("icon1", "SSC JE & State AE Exams")
                val goalitem1 = goal_item_data("icon2", "GATE  & ESE - ME & CH")
                val goalitem2 = goal_item_data("icon1", "GATE,ESE - Civil")
                val goalitem3 = goal_item_data("icon1", "IIT-JAM")
                val goalitem4 = goal_item_data("icon1", "GATE & ESE - JAM,EE,EC")
                val goalitem5 = goal_item_data("icon1", "GATE-CS & IT")
                val goalitem6 = goal_item_data("icon1", "AAI-jr. Executive ATC")
                val my_list = listOf<goal_item_data>(
                    goalitem,
                    goalitem1,
                    goalitem2,
                    goalitem3,
                    goalitem4,
                    goalitem5, goalitem6
                )
                val goal_adapter = goal_adapter(my_list)
                binding.examRv.adapter = goal_adapter
                goal_adapter.notifyDataSetChanged()
            } else {
                binding.option1.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_add_24, 0)

                Log.d("exam", isvisible.toString())
                binding.examRv.visibility = View.GONE
            }


        }
        binding.nextbtn.setOnClickListener {
            findNavController().navigate(R.id.action_playtolearn2_to_dashboard)
        }

    }

}