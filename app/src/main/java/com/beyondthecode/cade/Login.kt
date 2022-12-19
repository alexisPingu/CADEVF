package com.beyondthecode.cade

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.beyondthecode.cade.api.modelos.AlumnoDto
import com.beyondthecode.cade.api.modelos.AlumnoOBJ
import com.beyondthecode.cade.api.repositorios.AlumnoRepository
import com.beyondthecode.cade.api.retrofit.ApiClientt
import com.beyondthecode.cade.databinding.ActivityLoginBinding
import com.beyondthecode.cade.views.Registro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //var ids = findViewById<TextInputEditText>(R.id.txtID)
        //var contra = findViewById<TextInputEditText>(R.id.contra)

        //val boton = findViewById<Button>(R.id.botoniniciar)
        binding.botoniniciar.setOnClickListener {
            
            var usuario =binding.txtID.text.toString()
            var contra=binding.contra.text.toString()
            if(isValidForm(usuario,contra)){
                Toast.makeText(applicationContext, "iniciando sesion", Toast.LENGTH_SHORT).show()

                var service = ApiClientt.getRetrofitInstance()?.create(AlumnoRepository::class.java)
                service?.getAlumnAuth(binding.txtID.text.toString(), binding.contra.text.toString())?.enqueue(object : Callback<AlumnoDto?> {
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
                })

            }else{
                Toast.makeText(this, "Faltan datos por llenar", Toast.LENGTH_SHORT).show()
            }
            
        }

        //val olvido = findViewById<TextView>(R.id.olvidoContraseña)
        binding.olvidoContraseA.setOnClickListener {
            errorContrasenia()
        }

       //val registrarse = findViewById<TextView>(R.id.btnregistro)
        binding.btnregistro.setOnClickListener {
            registrar()
        }

    }
    fun isValidForm(usuario:String,contra:String):Boolean{
        if(usuario.isEmpty() || contra.isEmpty()){
            return false
        }
        return true
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
        finish()
    }
}