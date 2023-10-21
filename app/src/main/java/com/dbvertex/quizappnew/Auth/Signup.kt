package com.dbvertex.quiz_app.Auth

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.dbvertex.quiz_app.Dashboard.SharedPrefrenceHelper
import com.dbvertex.quiz_app.Utill.hideKeyboard
import com.dbvertex.quiz_app.Utill.temp_show_toast
import com.dbvertex.quizappnew.R
import com.dbvertex.quizappnew.Room.User
import com.dbvertex.quizappnew.Room.UserDatabase
import com.dbvertex.quizappnew.databinding.FragmentSignUpBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.File
import java.util.*


class Signup : Fragment() {
    lateinit var signupBinding: FragmentSignUpBinding
    var userlist = ArrayList<User>()
    var dob_value = ""
    var date_picker_visibility = MutableLiveData<Boolean>(false)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        val userfound = MutableLiveData<Boolean>(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        signupBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        return signupBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        signupBinding.header.setOnClickListener {
            clearApplicationData()
        }

        signupBinding.signupBTN.setOnClickListener {
            //  findNavController().navigate(R.id.action_signup_to_dashboard)
            validate()
        }
        signupBinding.conlay.setOnClickListener {
            hideKeyboard(requireContext(), it)
        }
        signupBinding.root.setOnClickListener {
            hideKeyboard(requireContext(), it)
        }
        signupBinding.dob.setCursorVisible(false);

        signupBinding.dob.setOnClickListener {

            if (date_picker_visibility.value == true) {
                date_picker_visibility.value = false
            } else if (date_picker_visibility.value == false) {
                date_picker_visibility.value = true
            }

        }
        date_picker_visibility.observe(viewLifecycleOwner) {
            if (it == true) {
                signupBinding.dob.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.closeimgblack, 0);
                signupBinding.datapick.visibility = View.VISIBLE

            } else {
                signupBinding.dob.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.openimgblack, 0);

                signupBinding.datapick.visibility = View.GONE

            }
        }


        val today = Calendar.getInstance()
        signupBinding.datapick.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1
            val msg = "$day/$month/$year"
            dob_value = msg
            signupBinding.dob.setText(msg)
        }

    }


    fun validate() {
        if (signupBinding.name.text.toString().isEmpty()) {
            signupBinding.name.setError("Name is required")
            hideKeyboard(requireContext(), signupBinding.name.rootView)
        } else if (signupBinding.email.text.toString()
                .isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(signupBinding.email.text)
                .matches()
        ) {
            signupBinding.email.setError("valid email is required")
        } else if (dob_value.toString().isEmpty()) {
            temp_show_toast(requireContext(), "required dob", Toast.LENGTH_SHORT)

        }else if (signupBinding.mobile.text.toString().isEmpty()) {
            signupBinding.mobile.setError("Mobile no. is required")
        }

        else if (signupBinding.password.text.toString().isEmpty()) {
            signupBinding.password.setError("Password is required")
        }

        else {

            val _name = signupBinding.name.text.toString()
            val _email = signupBinding.email.text.toString()
            val _dob = dob_value.toString()
            val _password = signupBinding.password.text.toString()
            val _mobile=signupBinding.mobile.text.toString()


            val userdao2 = UserDatabase.getUserDatabase(requireContext()).userdao()

            GlobalScope.launch {
                val email = userdao2.getUserBymail(_email)
                if (email != null) {
                    Log.d("alluser", " :by email: " + email.toString())
                    try {
                        if (email.size != 0) {
                            if (email[0].email.equals(_email)) {
                                Log.d("alluser", "same user found")
                                SharedPrefrenceHelper.email = _email
                                try {
                                    findNavController().navigate(R.id.action_signup_to_playtolearn2)
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                }
                            }
                        } else {
                            Log.d("alluser", "no user found")

                            val userdao = UserDatabase.getUserDatabase(requireContext()).userdao()
                            GlobalScope.launch {
                                userdao.insertUser(User(null, _name, _email, _dob, _password,_mobile))
                            }

                            SharedPrefrenceHelper.email = _email
                            SharedPrefrenceHelper.dob = _dob
                            SharedPrefrenceHelper.name = _name
                            SharedPrefrenceHelper.mobile = _mobile
                            try {
                                findNavController().navigate(R.id.action_signup_to_playtolearn2)
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        }

                    } catch (e: Exception) {
                        e.printStackTrace()
                    }

                } else {
                    Log.d("alluser", " :by email: " + "nouser")
                }
            }


        }
    }

    fun clearApplicationData() {
        try {
            // Clear application cache
            val cacheDirectory: File = requireActivity().getCacheDir()
            val applicationDirectory = File(cacheDirectory.getParent())
            if (applicationDirectory.exists()) {
                val fileNames: Array<String> = applicationDirectory.list()
                for (fileName in fileNames) {
                    if (fileName != "lib") {
                        deleteFile(File(applicationDirectory, fileName))
                    }
                }
            }

            // Clear shared preferences
            val sharedPreferences: SharedPreferences =
                requireActivity().getSharedPreferences(requireContext().getPackageName() + "_preferences", MODE_PRIVATE)
            sharedPreferences.edit().clear().apply()

            // Clear databases
            val databasesDirectory: File = ApplicationProvider.getApplicationContext<Context>()
                .getDatabasePath("your_database_name").getParentFile()
            if (databasesDirectory.exists()) {
                val databaseNames: Array<String> = databasesDirectory.list()
                for (databaseName in databaseNames) {
                    deleteFile(File(databasesDirectory, databaseName))
                }
            }

            // Clear other application data if needed
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun deleteFile(file: File?): Boolean {
        var deletedAll = true
        if (file != null) {
            if (file.isDirectory()) {
                val children: Array<String> = file.list()
                for (aChildren in children) {
                    deletedAll = deleteFile(File(file, aChildren)) && deletedAll
                }
            } else {
                deletedAll = file.delete()
            }
        }
        return deletedAll
    }

}