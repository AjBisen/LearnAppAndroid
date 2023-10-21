package com.dbvertex.quiz_app.Dashboard

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dbvertex.quiz_app.Utill.temp_show_toast
import com.dbvertex.quiz_app.Utill.viewmenu
import com.dbvertex.quizappnew.R
import com.dbvertex.quizappnew.Room.UserDatabase
import com.dbvertex.quizappnew.databinding.FragmentDashboardBinding
import com.dbvertex.quizappnew.databinding.FragmentLogoutBinding

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class Dashboard : Fragment() {
    lateinit var DashBinding: FragmentDashboardBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        DashBinding = FragmentDashboardBinding.inflate(inflater, container, false)
        return DashBinding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmenu()
        DashBinding.allGoals.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_allGoalsFragment)

        }


        val onBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Handle the back button event
                requireActivity().finish()
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this.viewLifecycleOwner, onBackPressedCallback
        )

        DashBinding.userName.text = "Hi ${SharedPrefrenceHelper.name.toString()}!!"

        DashBinding.textView.setOnClickListener {

            dailog()
        }
        DashBinding.mygoals.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_myGoalsFragment)
        }

        DashBinding.usericon.setOnClickListener {
            //SharedPrefrenceHelper.email="0"
            temp_show_toast(
                requireContext(), "${SharedPrefrenceHelper.email.toString()}", Toast.LENGTH_SHORT
            )
            findNavController().navigate(R.id.action_dashboard_to_profile)


        }

        val list =
            listOf<String>("item1", "item2", "item3", "item4", "item1", "item2", "item3", "item4")
//        adapter=myAdapter(list)
//        DashBinding.rvMainItems.adapter=adapter
//        adapter.notifyDataSetChanged()


        val list_courses = listOf<courses_data>(
            courses_data("img1", "Dominate Gate Exams", "Jackon Kalth", "56.00", "4.9"),
            courses_data("img1", "Dominate Gate Exams", "Jackon Kalth", "56.00", "4.9"),
            courses_data("img1", "Dominate Gate Exams", "Jackon Kalth", "56.00", "4.9"),
            courses_data("img1", "Dominate Gate Exams", "Jackon Kalth", "56.00", "4.9"),
            courses_data("img1", "Dominate Gate Exams", "Jackon Kalth", "56.00", "4.9"),
            courses_data("img1", "Dominate Gate Exams", "Jackon Kalth", "56.00", "4.9")
        )
        val course_adapter = Courses_adapter(list_courses)
        DashBinding.coursesRV.adapter = course_adapter
        course_adapter.notifyDataSetChanged()

        val course_adapter1 = Courses_adapter(list_courses)

        DashBinding.coursesRV1.adapter = course_adapter1
        course_adapter.notifyDataSetChanged()

    }

    fun dailog() {

        val logoutbind = FragmentLogoutBinding.inflate(LayoutInflater.from(requireContext()))
        val dialog = Dialog(requireContext())
        dialog.setContentView(logoutbind.root)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.window!!.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT
        )
        logoutbind.ok.setOnClickListener {
            try {

                val userdao2 = UserDatabase.getUserDatabase(requireContext()).userdao()
                GlobalScope.launch {
                    val email = userdao2.getUserBymail(SharedPrefrenceHelper.email.toString())
                    if (email != null) {
                        Log.d("alluser", " :by email: " + email.toString())
                        try {
                            if (email.size != 0) {
                                if (email[0].email.equals(SharedPrefrenceHelper.email.toString())) {
                                    Log.d("alluser", "same user found")

                                    val userdao3 =
                                        UserDatabase.getUserDatabase(requireContext()).userdao()
                                    SharedPrefrenceHelper.email = "0";

                                    GlobalScope.launch {
                                        userdao3.deleteUser(email[0])
                                    }

                                    try {
                                        findNavController().navigate(R.id.splash)
                                    } catch (e: Exception) {
                                        e.printStackTrace()
                                    }
                                    dialog!!.dismiss()

                                }
                            } else {
                                Log.d("alluser", "no user found")
                                Toast.makeText(requireContext(), "Try again", Toast.LENGTH_SHORT)
                                    .show()
                            }

                        } catch (e: Exception) {
                            e.printStackTrace()
                        }

                    } else {
                        Log.d("alluser", " :by email: " + "nouser")
                        Toast.makeText(requireContext(), "NO email found!!", Toast.LENGTH_SHORT)
                            .show()

                    }
                }








                dialog!!.dismiss()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        logoutbind.cancel.setOnClickListener {
            try {
                dialog!!.dismiss()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        dialog.show()
    }
}