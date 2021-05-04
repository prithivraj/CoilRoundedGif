package com.zestworks.coilroundedgif

import coil.request.DefaultRequestOptions
import okhttp3.OkHttpClient

object ConfigProvider {
    var dispatcher = DefaultRequestOptions().dispatcher
    var okHttpClient = OkHttpClient()
}
