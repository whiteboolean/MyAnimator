package com.example.myanimator

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView


/**
 *
 * 动画：
 *  1. View动画 ： 对场景里的对象不断做图像变换(变换，缩放，旋转，透明度)
 *  2. 帧动画
 *  3. 属性动画
 *  属性动画要求动画作用的对象提供该属性的set方法，属性动画根据你传递的该属性的初始值和最终值，
 *  以动画的效果多次去调用set方法。每次传递给set方法的值都不一样，确切来说是随着时间的推移，对传递的值越来越接近
 *  最终值。
 *  如果动画的时候没有传递初始值，那么还要提供get方法，因为系统要去获取属性的初始值。对于属性动画来说，
 *  其动画过程过程中所作的就是这么多。
 *
 *
 */
class MainActivity : AppCompatActivity() {

    lateinit var button: Button

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById<Button>(R.id.button)

        //View动画
//        val animation = AnimationUtils.loadAnimation(
//            this, R.anim.anim2
//        )
//
//        //View动画 - 透明度动画
//        val alphaAnimation = AlphaAnimation(1f, 0f)
//            .apply {
//                duration = 3000
//                fillAfter = true
//            }
//
//
//        //3D动画
//        val myAnimation = Rotate3dAnimation(
//            100f, 20f, 10f,
//            10f, 20f, true
//        ).apply {
//            duration = 3000
//        }
//
//        Handler(Looper.myLooper()!!).post{
//            println("Height1:${button.height}")
//        }
//
//        button.post {
//            println("Height2:${button.height}")
//        }
//
//        button.setOnClickListener {
//            button.startAnimation(myAnimation)
//        }
//
//        alphaAnimation.setAnimationListener(
//            object : Animation.AnimationListener {
//                override fun onAnimationStart(animation: Animation?) {
//
//                }
//
//                override fun onAnimationEnd(animation: Animation?) {
//                }
//
//                override fun onAnimationRepeat(animation: Animation?) {
//                }
//
//            }
//        )


        //属性动画

        button.setOnClickListener {
//            val anim1 = ObjectAnimator.ofFloat(button, "translationY", -button.height.toFloat())
//            anim1.start()
            Log.d(TAG, "onCreate: onClick")
//            animationSet1()
            performAnimate()
        }

    }


    private fun animationSet1() {
        val set = AnimatorSet()
        set.playTogether(
            ObjectAnimator.ofFloat(button, "rotationX", 0f, 360f),
            ObjectAnimator.ofFloat(button, "rotationY", 0f, 180f),
            ObjectAnimator.ofFloat(button, "rotation", 0f, -90f),
            ObjectAnimator.ofFloat(button, "translationX", 0f, 90f),
            ObjectAnimator.ofFloat(button, "translationY", 0f, 90f),
            ObjectAnimator.ofFloat(button, "scaleX", 1f, 1.5f),
            ObjectAnimator.ofFloat(button, "scaleY", 1f, 0.5f),
            ObjectAnimator.ofFloat(button, "alpha", 1f, 0.25f, 1f)
        )
        set.setDuration(5 * 1000).start()
    }

    private fun performAnimate(){
        ObjectAnimator.ofInt(button,"width",500).setDuration(5000).start()
    }


    override fun onResume() {
        super.onResume()


    }
}


