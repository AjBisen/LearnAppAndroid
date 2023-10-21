package com.dbvertex.quizappnew.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query(value = "SELECT * FROM usertable")
    suspend fun getAllUser():List<User>


    @Query("SELECT * FROM usertable WHERE email LIKE :email")
    suspend fun getUserBymail(email: String):List<User>
}