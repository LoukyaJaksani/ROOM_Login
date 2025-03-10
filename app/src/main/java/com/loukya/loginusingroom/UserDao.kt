package com.loukya.loginusingroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user:User)

    @Query("SELECT * FROM users WHERE email = :email AND password = :password" )
    suspend fun  getUser(email:String,password:String):User?

//    @Query("SELECT * FROM users")
//    suspend fun  getAllUsers():List<User>

}