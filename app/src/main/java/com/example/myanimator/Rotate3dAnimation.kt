package com.example.myanimator

import android.graphics.Camera
import android.graphics.Matrix
import android.view.animation.Animation
import android.view.animation.Transformation

class Rotate3dAnimation : Animation {

    private
    var mFromDegrees: Float = 0f

    private
    var mToDegrees: Float = 0f

    private
    var mCenterX: Float = 0f

    private
    var mCenterY: Float = 0f

    private
    var mDepthZ: Float = 0f

    private
    var mReverse: Boolean = false

    private
    var mCamera: Camera? = null

    constructor()

    constructor(
        fromDegrees: Float, toDegrees: Float,
        centerX: Float, centerY: Float, depthZ: Float, reverse: Boolean
    ) : this() {
        this.mFromDegrees = fromDegrees
        this.mToDegrees = toDegrees
        this.mCenterX = centerX
        this.mCenterY = centerY
        this.mDepthZ = depthZ
        this.mReverse = reverse
    }


    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        mCamera = Camera()
    }


    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        super.applyTransformation(interpolatedTime, t)
        val fromDegrees = mFromDegrees
        val degrees: Float =
            fromDegrees + ((mToDegrees - fromDegrees) * interpolatedTime)
        val centerX = mCenterX
        val centerY = mCenterY
        val camera = mCamera!!
        val matrix: Matrix = t!!.matrix
        camera.save()
        if (mReverse) {
            camera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime)
        } else {
            camera.translate(0.0f, 0.0f, mDepthZ * (1.0f - interpolatedTime))
        }
        camera.rotateY(degrees)
        camera.getMatrix(matrix)
        camera.restore()
        matrix.preTranslate(-centerX, -centerY)
        matrix.postTranslate(centerX, centerY)
    }

}