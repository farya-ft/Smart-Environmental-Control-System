package com.example.esp32datareceiver

import android.os.Bundle
import android.os.StrictMode
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var dataTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        dataTextView = findViewById(R.id.dataTextView)

        
        CoroutineScope(Dispatchers.Main).launch {
            while (true) {
                fetchDataFromServer()
                delay(1000) 
            }
        }
    }

    private suspend fun fetchDataFromServer() {
        withContext(Dispatchers.IO) {
            val url = "http://192.168.0.27:5000/get-data"
            val data = NetworkUtils.fetchData(url)

            withContext(Dispatchers.Main) {
                val formattedData = data ?: "Failed to receive data"
                dataTextView.text = formatData(formattedData)
            }
        }
    }

    private fun formatData(data: String): String {
        
        return data
    }
}

