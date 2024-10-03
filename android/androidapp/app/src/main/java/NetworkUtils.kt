package com.example.esp32datareceiver

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

object NetworkUtils {

    private val client = OkHttpClient()

    fun fetchData(url: String): String? {
        val request = Request.Builder()
            .url(url)
            .build()

        return try {
            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) {
                    "خطا: کد پاسخ ${response.code}"
                } else {
                    response.body?.string()
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            "خطا: ${e.message}"
        }
    }
}
