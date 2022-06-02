package com.example.wsrfilms.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.wsrfilms.Dto.Login
import com.example.wsrfilms.MainViewModel
import com.example.wsrfilms.R
import com.example.wsrfilms.connection.Connection
import com.example.wsrfilms.ui.theme.PrimaryColor
import com.example.wsrfilms.ui.theme.butColor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first

@Composable
fun SignInScreen(vm: MainViewModel) {
    
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    
    val res = remember {
        vm.res
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .background(PrimaryColor),
    verticalArrangement = Arrangement.SpaceBetween,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Column(modifier = Modifier.weight(0.8f), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = null)
        }
        Column(modifier = Modifier.weight(0.8f), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(value = email.value, onValueChange = {email.value = it})
            Spacer(modifier = Modifier.padding(5.dp))
            OutlinedTextField(value = password.value, onValueChange = {password.value = it})
        }
        Column(modifier = Modifier.weight(0.5f), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            if (res.value) Text(text = res.value.toString())
            Button(onClick = { vm.log(email.value, password.value)}, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp), colors = ButtonDefaults.buttonColors(butColor)) {
                Text(text = "Войти", color = Color.White)
            }
            OutlinedButton(onClick = { /*TODO*/ }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 5.dp), colors = ButtonDefaults.buttonColors(Color(0x00000000))) {
                Text(text = "Регистрация", color = butColor)
            }
        }
    }
}