package com.example.myanimator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView


/**
 *
 * 动画：
 *  1. View动画 ： 对场景里的对象不断做图像变换(变换，缩放，旋转，透明度)
 *  2. 帧动画
 *  3. 属性动画
 *
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val animation = AnimationUtils.loadAnimation(
            this, R.anim.anim2
        )

        val alphaAnimation = AlphaAnimation(1f, 0f)
            .apply {
                duration = 3000
                fillAfter = true
            }


        val myAnimation = Rotate3dAnimation(
            100f, 20f, 10f,
            10f, 20f, true
        ).apply {
            duration = 3000
        }

        button.setOnClickListener {
            button.startAnimation(myAnimation)
        }

        alphaAnimation.setAnimationListener(
            object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {

                }

                override fun onAnimationEnd(animation: Animation?) {
                }

                override fun onAnimationRepeat(animation: Animation?) {
                }

            }
        )


    }
}