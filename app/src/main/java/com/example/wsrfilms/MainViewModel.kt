package com.example.wsrfilms

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.example.wsrfilms.Dto.Login
import com.example.wsrfilms.connection.Connection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    var res = mutableStateOf(false)

    fun log(email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            res.value = Connection().login(Login(email, password)).first()
        }

    }

}