package com.example.wsrfilms.connection

import com.example.wsrfilms.Dto.Login
import com.example.wsrfilms.Dto.Token
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.serializer

enum class Route(val route: String){
    LOGIN("https://top1bot.ru/wsr-food/auth/login")
}

var token = ""

class Connection {

    private val client: HttpClient = HttpClient(Android) {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
    }

    fun login(userParams: Login): Flow<Boolean> = flow {
        var res = false
        val response: HttpResponse = client.post(urlString = Route.LOGIN.route) {
            contentType(ContentType.Application.Json)
            body = userParams
        }
        val gson = Gson()

        if (response.content.readUTF8Line().toString()[0] == '{') {
            var a = gson.fromJson(response.receive<JsonObject>().asJsonObject, Token::class.java)

            token = a.token
            res = true
        }
        emit(res)
    }

}