package com.dbvertex.quiz_app.Utill

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dbvertex.quizappnew.R

import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.Duration


fun Fragment.hidemenu(){
    val navBar = activity!!.findViewById<BottomAppBar>(R.id.bottomAppBar)
    val fab = activity!!.findViewById<FloatingActionButton>(R.id.fab)
    navBar.visibility= View.GONE
    fab.visibility= View.GONE
}

fun Fragment.viewmenu(){
    val navBar = activity!!.findViewById<BottomAppBar>(R.id.bottomAppBar)
    val fab = activity!!.findViewById<FloatingActionButton>(R.id.fab)
    navBar.visibility= View.VISIBLE
    fab.visibility= View.VISIBLE
}

fun Fragment.temp_show_toast(context: Context,value:String,duration: Int){
    Toast.makeText(context,value,duration).show()
}
fun Activity.temp_show_toast(context: Context,value:String,duration: Int){
    Toast.makeText(context,value,duration).show()
}

fun Fragment.hideKeyboard(context: Context, view: View) {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view.windowToken, 0)
}

