package com.zestworks.coilroundedgif

import android.graphics.* // ktlint-disable no-wildcard-imports
import android.os.Build.VERSION.SDK_INT
import coil.transform.AnimatedTransformation
import coil.transform.PixelOpacity

object RoundedCornersAnimatedTransformation : AnimatedTransformation {

    override fun transform(canvas: Canvas): PixelOpacity {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG).apply {
            color = Color.TRANSPARENT
            xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC)
        }
        val path = Path().apply {
            fillType = Path.FillType.INVERSE_EVEN_ODD
        }

        val width = canvas.width.toFloat()
        val height = canvas.height.toFloat()
        if (SDK_INT >= 21) {
            path.addRoundRect(0f, 0f, width, height, 20f, 20f, Path.Direction.CW)
        } else {
            path.addRoundRect(RectF(0f, 0f, width, height), 20f, 20f, Path.Direction.CW)
        }
        canvas.drawPath(path, paint)
        return PixelOpacity.TRANSLUCENT
    }
}
