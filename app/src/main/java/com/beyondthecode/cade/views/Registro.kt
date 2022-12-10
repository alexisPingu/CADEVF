package com.beyondthecode.cade.views

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.beyondthecode.cade.Login
import com.beyondthecode.cade.R
import com.beyondthecode.cade.api.modelos.AlumnoDto
import com.beyondthecode.cade.api.modelos.CarrerasDto
import com.beyondthecode.cade.api.repositorios.CarrerasRepository
import com.beyondthecode.cade.api.retrofit.ApiClientt
import com.beyondthecode.cade.clases.DatePickerFragment
import com.beyondthecode.cade.clases.MyToolBar
import com.beyondthecode.cade.databinding.ActivityRegistroBinding
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Registro : AppCompatActivity() {
    lateinit var binding: ActivityRegistroBinding
    private var listC: List<CarrerasDto> = listOf()
    private var day: Int = 0
    private var month: Int = 0
    private var year: Int = 0


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MyToolBar().showATool(this, "Registrate", true)
        //val regresarIniciar = findViewById<TextView>(R.id.btnRegresarAIniciarSession)
        binding.btnRegresarAIniciarSession.setOnClickListener {
            regresarlogin()

        }
        //val cancelarRegistro = findViewById<Button>(R.id.btnCancelar)
        binding.btnCancelar.setOnClickListener {
            cancelar()
        }
        //val elegirFecha = findViewById<TextInputEditText>(R.id.registroFechaDeNacimiento)
        binding.registroFechaDeNacimiento.setOnClickListener {
            showDatePickerDialog()
        }
        //val aceptar = findViewById<Button>(R.id.btnAceptar)
        binding.btnAceptar.setOnClickListener {
            if(isValidForm()){
                /*
            var service = ApiClientt.getRetrofitInstance()?.create(AlumnoRepository::class.java)
            service?.addUser(obtenerDatosAlm())?.enqueue(object : Callback<AlumnoDto?> {
                override fun onResponse(
                    call: Call<AlumnoDto?>,
                    response: Response<AlumnoDto?>
                ) {
                    Toast.makeText(
                        applicationContext,
                        "si se pudo" +
                                "\n ${response.body()?.id} creado correctamente ",
                        Toast.LENGTH_LONG
                    ).show()
                }

                override fun onFailure(call: Call<AlumnoDto?>, t: Throwable) {
                    */
                Toast.makeText(
                    applicationContext,
                    "no se pudo registrar, pero si... ",
                    Toast.LENGTH_LONG
                ).show()
                startActivity(Intent(applicationContext, Matricula::class.java))
                /*
                        }
                    })*/
            }else{
                Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show()
            }

        }

        val itemsCarrera11: ArrayList<String> = arrayListOf<String>()
        var service = ApiClientt.getRetrofitInstance()?.create(CarrerasRepository::class.java)
        service?.getCarreras()?.enqueue(object : Callback<List<CarrerasDto>?> {
            override fun onResponse(
                call: Call<List<CarrerasDto>?>,
                response: Response<List<CarrerasDto>?>
            ) {
                listC = response.body()!!
                response.body()?.forEach {
                    itemsCarrera11.add(it.descripcionCarrera!!)
                }
                var combo = findViewById<Spinner>(R.id.registroCarrera)
                var adaptador = ArrayAdapter<String>(
                    applicationContext,
                    android.R.layout.simple_spinner_dropdown_item,
                    itemsCarrera11
                );
                combo.adapter = adaptador

            }

            override fun onFailure(call: Call<List<CarrerasDto>?>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    "no se pudo traer las carreras " + t.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        })

        val itemsGenero = arrayListOf("--Seleccione Genero--", "Masculino", "Femenino")
        //var comboGenero = findViewById<Spinner>(R.id.registroGenero)
        var adaptadorGenero =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsGenero);
        binding.registroGenero.adapter = adaptadorGenero


    }

    private fun isValidForm():Boolean{

        var nombre =  binding.registroNombre.text.toString()
        var ap1 = binding.registroApe1.text.toString()
        var ap2 = binding.registroApe2.text.toString()
        var telefono = binding.registroTelefono.text.toString()
        var correo = binding.registroEmail.text.toString()
        var contra = binding.registroContraseA.text.toString()
        var direcc = binding.registroDireccion.text.toString()
        var fecha=binding.registroFechaDeNacimiento.text.toString()
        //var gener = binding.registroGenero.selectedItem.toString()
        //var carrera=binding.registroCarrera.selectedItem.toString()

        if(nombre.isNotEmpty() && ap1.isNotEmpty() && ap2.isNotEmpty()
            && telefono.isNotEmpty() && correo.isNotEmpty() && contra.isNotEmpty()
            && direcc.isNotEmpty() && fecha.isNotEmpty() ){
            return true
        }
        return false

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun obtenerDatosAlm(): AlumnoDto {
        var nombre = findViewById<TextInputEditText>(R.id.registroNombre)
        var ap1 = findViewById<TextInputEditText>(R.id.registroApe1)
        var ap2 = findViewById<TextInputEditText>(R.id.registroApe2)
        var telefono = findViewById<TextInputEditText>(R.id.registroTelefono)
        var correo = findViewById<TextInputEditText>(R.id.registroEmail)
        var direcc = findViewById<TextInputEditText>(R.id.registroDireccion)

        var contra = findViewById<TextInputEditText>(R.id.registroContraseña)
        var gener = findViewById<Spinner>(R.id.registroGenero)
        var gen: Char = when (gener.selectedItem.toString()) {
            "Masculino" -> 'H'
            "Femenino" -> 'M'
            else -> {
                'F'
            }
        }
        var carrera = findViewById<Spinner>(R.id.registroCarrera)
        var index: Int = listC.indexOfFirst {
            it.descripcionCarrera.equals(carrera.selectedItem.toString())
        }

        var alumn = AlumnoDto(
            "1",
            nombre.text.toString(),
            ap1.text.toString(),
            ap2.text.toString(),
            telefono.text.toString(),
            correo.text.toString(),
            direcc.text.toString(),
            "$year-${
                if (month >= 10) {
                    month
                } else {
                    "0$month"
                }
            }-$day",
            contra.text.toString(),
            gen,
            listC[index].id.toString()
        )
        Toast.makeText(applicationContext, "" + alumn, Toast.LENGTH_SHORT).show()
        return alumn
    }

    fun regresarlogin() {
        startActivity(Intent(this, Login::class.java))
    }

    private fun showDatePickerDialog() {
        val datePicker = DatePickerFragment { day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "pickerdate")
    }

    fun cancelar() {
        //val nombre = findViewById<TextInputEditText>(R.id.registroNombre)
        binding.registroNombre.setText("")
        //val ape1 = findViewById<TextInputEditText>(R.id.registroApe1)
        binding.registroApe1.setText("")
        //val ape2 = findViewById<TextInputEditText>(R.id.registroApe2)
        binding.registroApe2.setText("")
        //val email = findViewById<TextInputEditText>(R.id.registroEmail)
        binding.registroEmail.setText("")
        //val contraseña = findViewById<TextInputEditText>(R.id.registroContraseña)
        binding.registroContraseA.setText("")
        //val telefono = findViewById<TextInputEditText>(R.id.registroTelefono)
        binding.registroTelefono.setText("")
        //val direccion = findViewById<TextInputEditText>(R.id.registroDireccion)
        binding.registroDireccion.setText("")
        //val fecha = findViewById<TextInputEditText>(R.id.registroFechaDeNacimiento)
        binding.registroFechaDeNacimiento.setText("")
        //val carrera = findViewById<Spinner>(R.id.registroCarrera)
        binding.registroCarrera.setSelection(0)
        //val genero = findViewById<Spinner>(R.id.registroGenero)
        binding.registroGenero.setSelection(0)


    }

    fun onDateSelected(day: Int, month: Int, year: Int) {
        this.year = year
        this.month = month
        this.day = day
        val elegirFecha = findViewById<TextInputEditText>(R.id.registroFechaDeNacimiento)
        elegirFecha.setText("$year-$month-$day")
    }


}