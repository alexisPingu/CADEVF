package com.beyondthecode.cade.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.beyondthecode.cade.Login
import com.beyondthecode.cade.clases.MyToolBar
import com.beyondthecode.cade.databinding.ActivityMatriculaBinding

class Matricula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMatriculaBinding.inflate(layoutInflater)
        val extras = intent.extras
        if (extras != null) {
            binding.mmat.setText("matricula: " + extras.getString("matricula"))
            binding.mcontra.setText("contraseña: " + extras.getString("contrasenia"))
        }
        binding.matSalir.setOnClickListener {
            startActivity(Intent(applicationContext, Login::class.java))
            finish()
        }
        MyToolBar().showATool(this, "", true)
        setContentView(binding.root)
    }
}