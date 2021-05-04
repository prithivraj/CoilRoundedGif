package com.zestworks.coilroundedgif

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.request.animatedTransformation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageLoader = ImageLoader.Builder(applicationContext)
            .dispatcher(ConfigProvider.dispatcher)
            .okHttpClient(ConfigProvider.okHttpClient)
            .componentRegistry {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder(applicationContext))
                } else {
                    add(GifDecoder())
                }
            }
            .build()
        val imageRequest = ImageRequest.Builder(applicationContext)
            .target(findViewById<ImageView>(R.id.imageView))
            .data("https://media.giphy.com/media/lPoxtQlcX30doRbHTN/giphy.gif")
            .animatedTransformation(RoundedCornersAnimatedTransformation)
            .build()
        imageLoader.enqueue(imageRequest)
    }
}
