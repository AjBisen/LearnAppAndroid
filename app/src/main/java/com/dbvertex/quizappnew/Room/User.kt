package com.dbvertex.quizappnew.Room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usertable")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val name: String,
    val email:String,
    val DOB: String,
    val password:String,
    val mobile:String

)
