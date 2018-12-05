package com.skateboard.core.network


import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object NetWorkUtil
{

    private const val BASE_URL = "http://www.baidu.com"

    private const val READ_TIME = 30L

    private const val WRITE_TIME = 30L

    private const val CONNECTION_TIME = 30L

    private var retrofit: Retrofit

    init
    {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(StringConvertFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(generateClient())
                .build()
    }

    private fun generateClient(): OkHttpClient
    {

        return OkHttpClient.Builder()
                .writeTimeout(WRITE_TIME, TimeUnit.SECONDS)
                .readTimeout(READ_TIME, TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIME, TimeUnit.SECONDS)
                .cookieJar(object : CookieJar
                {
                    private val cookiesMap = mutableMapOf<String, MutableList<Cookie>>()

                    override fun saveFromResponse(url: HttpUrl?, cookies: MutableList<Cookie>?)
                    {
                        url?.let {
                            val host = it.host()
                            cookies?.let {
                                if (cookiesMap[host] == null)
                                {
                                    cookiesMap[host] = cookies
                                }
                            }

                        }
                    }

                    override fun loadForRequest(url: HttpUrl?): MutableList<Cookie>
                    {
                        url?.let {
                            val host = it.host()
                            return cookiesMap[host] ?: mutableListOf<Cookie>()
                        }
                        return mutableListOf<Cookie>()
                    }
                })
                .build()
    }

    fun newClient(client: OkHttpClient): Retrofit
    {
        retrofit = retrofit.newBuilder().client(client).build()

        return retrofit
    }

    fun <T> create(cla: Class<T>): T = retrofit.create(cla)

}