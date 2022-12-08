package com.beyondthecode.cade

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.beyondthecode.cade.views.Registro
import com.google.android.material.textfield.TextInputEditText

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var ids = findViewById<TextInputEditText>(R.id.txtID)
        var contra = findViewById<TextInputEditText>(R.id.contra)

        val boton = findViewById<Button>(R.id.botoniniciar)
        boton.setOnClickListener {

            Toast.makeText(applicationContext, "iniciando sesion", Toast.LENGTH_SHORT).show()
            /*var service = ApiClientt.getRetrofitInstance()?.create(AlumnoRepository::class.java)
            service?.getAlumnAuth(ids.text.toString(), contra.text.toString())?.enqueue(object : Callback<AlumnoDto?> {
                override fun onResponse(
                    call: Call<AlumnoDto?>,
                    response: Response<AlumnoDto?>
                ) {
                    try {
                        AlumnoOBJ.alumno=response.body()!!
                        var alumnoDto= response.body()!!
                        Toast.makeText(applicationContext, "ALUMNO: "+alumnoDto.nombreAlumno, Toast.LENGTH_SHORT).show()

                        var intent=Intent(applicationContext,MainActivity::class.java)
                        intent.putExtra("serial", alumnoDto)

                        startActivity(intent)
                    }catch (e :java.lang.Exception){
                        Toast.makeText(applicationContext, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    }

                }

                override fun onFailure(call: Call<AlumnoDto?>, t: Throwable) {
                    Toast.makeText(
                        applicationContext,
                        "no se pudo iniciar sesión" + t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })*/
            startActivity(Intent(this, MainActivity::class.java))
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