package com.beyondthecode.cade
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.beyondthecode.cade.views.Registro

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_login)

        val boton=findViewById<Button>(R.id.botoniniciar)
        boton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        val olvido = findViewById<TextView>(R.id.olvidoContraseña)
        olvido.setOnClickListener {
            errorContrasenia()
        }

       val registrarse = findViewById<TextView>(R.id.btnregistro)
        registrarse.setOnClickListener {
            registrar()
        }

    }
    fun errorContrasenia() {
        val view = View.inflate(this@Login, R.layout.dialog_view, null)
        val builder = AlertDialog.Builder(this@Login)
        builder.setView(view)

        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
    }

    fun registrar() {
        val lanzar = Intent(this, Registro::class.java)
        startActivity(lanzar)
    }
}