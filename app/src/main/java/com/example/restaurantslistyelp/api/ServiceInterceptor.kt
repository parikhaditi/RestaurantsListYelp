package com.example.restaurantslistyelp.api

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

// Client ID
//6AHGV4sBfarb2_clpyvFAA
//
//API Key
//pqlyg4ANzh_RH-4jXb0boawVWPQ8bIlMlO1kYAhOGimswzrBQZTngKESu83Shx6c_q04U45E0GWff-Bh9_UfegkoewSpM9a6g8MS-9eQLYruwOaKILtm8L_01LuBXXYx


class ServiceInterceptor : Interceptor{

    var token : String = ""

    fun Token(token: String ) {
        this.token = token;
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        var token : String = "pqlyg4ANzh_RH-4jXb0boawVWPQ8bIlMlO1kYAhOGimswzrBQZTngKESu83Shx6c_q04U45E0GWff-Bh9_UfegkoewSpM9a6g8MS-9eQLYruwOaKILtm8L_01LuBXXYx"

        Log.i("TAG","in if.."+token)

        var request = chain.request()

        if(request.header("No-Authentication")==null){
            //val token = getTokenFromSharedPreference();
            //or use Token Function
            if(!token.isNullOrEmpty())
            {
                Log.i("TAG","in if.."+token)
                val finalToken =  "Bearer "+token
                request = request.newBuilder()
                    .addHeader("Authorization",finalToken)
                    .build()
            }

        }

        Log.i("TAG","request.."+request)
        return chain.proceed(request)
    }

}