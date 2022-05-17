package com.example.restaurantslistyelp

import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantslistyelp.adapter.Restaurants_list_Adapter
import com.example.restaurantslistyelp.api.ApiInterface
import com.example.restaurantslistyelp.data.ResponseBusinesses
import com.example.restaurantslistyelp.utils.MessageUtils
import com.example.restaurantslistyelp.utils.Utility
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var apiInterface: ApiInterface?=null
    private lateinit var adapter: Restaurants_list_Adapter
    lateinit var rv : RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiInterface = ApiInterface.getApiClient().create(ApiInterface::class.java)
        rv = findViewById(R.id.rv_movies);

        callAPI()


    }

    fun callAPI()
    {
        if (Utility.isOnline(baseContext)) {
            get_restaurants_wsCall()
        }
        else {
            MessageUtils.showAlert(this,"Internet Not available","")
        }
    }

    fun get_restaurants_wsCall() {

        apiInterface?.getBusinesses()?.enqueue(object :
            Callback<ResponseBusinesses> {

            override fun onFailure(call: Call<ResponseBusinesses>, t: Throwable) {
                Log.e("ERROR",""+t.message)
            }

            override fun onResponse(
                call: Call<ResponseBusinesses>,
                response: Response<ResponseBusinesses>
            ) {
                val res = response.body()
                //MessageUtils.showAlert(this@MainActivity,"Response",""+res)
                if (response.code() == 200 &&  res!=null ){
                    Log.i("res.businesses",""+res.businesses)
                    adapter = res.businesses?.let { Restaurants_list_Adapter(it) }!!
                    val manager = LinearLayoutManager(this@MainActivity)
                    rv.setLayoutManager(manager)
                    rv.adapter =adapter
                }else{
                    MessageUtils.showAlert(this@MainActivity,"something_went_wrong","")
                }
            }
        })
    }
}