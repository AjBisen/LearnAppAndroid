package com.dbvertex.quiz_app.Dashboard

import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import androidx.core.content.edit
import com.dbvertex.quizappnew.QuizApplication

import com.google.gson.Gson
import java.util.prefs.Preferences

object SharedPrefrenceHelper {
    private val sharedPreferences: SharedPreferences
    private const val EMAIL = "EMAIL"
    private const val NAME = "NAME"
    private const val DOB = "DOB"
    private const val MOBILE = "MOBILE"
    private const val PASSWORD = "PASSWORD"


    private const val USERDATA = "USERDATA"


    init {
        val context = QuizApplication.instance
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    }


    var email: String?
        get() {
            return sharedPreferences.getString(EMAIL, "0")
        }
        set(value) {
            sharedPreferences.edit {
                putString(EMAIL, value)
            }
        }
    var name: String?
        get() {
            return sharedPreferences.getString(NAME, "0")
        }
        set(value) {
            sharedPreferences.edit {
                putString(NAME, value)
            }
        }

    var dob: String?
        get() {
            return sharedPreferences.getString(DOB, "0")
        }
        set(value) {
            sharedPreferences.edit {
                putString(DOB, value)
            }
        }

    var mobile: String?
        get() {
            return sharedPreferences.getString(MOBILE, "0")
        }
        set(value) {
            sharedPreferences.edit {
                putString(MOBILE, value)
            }
        }

    var password: String?
        get() {
            return sharedPreferences.getString(PASSWORD, "0")
        }
        set(value) {
            sharedPreferences.edit {
                putString(PASSWORD, value)
            }
        }


//    var userdata: User
//        get() {
//            val userString = sharedPreferences.getString(USERDATA, null) ?: "User not found"
//
//            return Gson().fromJson(userString, User::class.java)
//        }
//        set(value) = sharedPreferences.edit {
//            val userJson = Gson().toJson(value)
//            putString(USERDATA, userJson)
//            Log.d("Userdata", userJson.toString())
//        }
}