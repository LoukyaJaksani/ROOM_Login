package com.loukya.loginusingroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository
    val userDao = AppDatabase.getDatabase(application)

    init {
        val userDao = AppDatabase.getDatabase(application).userDao() // Ensure this is correct
        repository = UserRepository(userDao)
    }

    fun insertUser(user: User) = viewModelScope.launch {
        repository.insertUser(user)
    }

    fun getUser(email: String, password: String, callback: (User?) -> Unit) {
        viewModelScope.launch {
            val user = repository.getUser(email, password)
            callback(user)
        }
    }
}
