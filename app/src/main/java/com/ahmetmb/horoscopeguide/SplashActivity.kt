package com.ahmetmb.horoscopeguide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.WindowManager
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var logoRotateAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_logo_rotate)
        imageViewSplashLogo.animation = logoRotateAnimation

    }

    override fun onResume() {

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        object : CountDownTimer(5000, 1000){
            override fun onFinish() {
                var intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
            }

            override fun onTick(millisUntilFinished: Long) {

            }

        }.start()

        super.onResume()
    }
}
