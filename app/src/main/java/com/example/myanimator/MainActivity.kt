package com.example.myanimator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
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

        //View动画
        val animation = AnimationUtils.loadAnimation(
            this, R.anim.anim2
        )

        //View动画 - 透明度动画
        val alphaAnimation = AlphaAnimation(1f, 0f)
            .apply {
                duration = 3000
                fillAfter = true
            }


        //3D动画
        val myAnimation = Rotate3dAnimation(
            100f, 20f, 10f,
            10f, 20f, true
        ).apply {
            duration = 3000
        }

        Handler(Looper.myLooper()!!).post{
            println("Height1:${button.height}")
        }

        button.post {
            println("Height2:${button.height}")
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


    override fun onResume() {
        super.onResume()


    }
}