package com.example.testtt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter()
        recyclerView.adapter = adapter

        // Create an instance of the API service
        val apiService = ApiClient.apiService

        // Make the API call
        val call = apiService.getUsers()
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    val userList = response.body()
                    if (userList != null) {
                        // Update the adapter with the fetched data
                        adapter.setData(userList)
                    }
                } else {
                    // Handle the error case appropriately
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                // Handle the failure case appropriately
            }
        })
    }
}
