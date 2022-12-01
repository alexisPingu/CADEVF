package com.beyondthecode.cade

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Animaciones del splash
        val splashanimation= AnimationUtils.loadAnimation(this,R.anim.assets_fade_in)
        val imagen=findViewById<ImageView>(R.id.logoCade)
        val titulo=findViewById<TextView>(R.id.tituloCade)
        imagen.startAnimation(splashanimation)
        titulo.startAnimation(splashanimation)

        @Suppress("DEPRECATION")
        Handler().postDelayed({
            startActivity(
                Intent(this@Splash,Login::class.java)
            )
            finish()

        },3500)
    }
}