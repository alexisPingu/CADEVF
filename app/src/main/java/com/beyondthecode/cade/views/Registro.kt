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
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Registro : AppCompatActivity() {
    private var listC: List<CarrerasDto> = listOf()
    private var day: Int = 0
    private var month: Int = 0
    private var year: Int = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        MyToolBar().showATool(this, "Registrate", true)
        val regresarIniciar = findViewById<TextView>(R.id.btnRegresarAIniciarSession)
        regresarIniciar.setOnClickListener {
            regresarlogin()

        }
        val cancelarRegistro = findViewById<Button>(R.id.btnCancelar)
        cancelarRegistro.setOnClickListener {
            cancelar()
        }
        val elegirFecha = findViewById<TextInputEditText>(R.id.registroFechaDeNacimiento)
        elegirFecha.setOnClickListener {
            showDatePickerDialog()
        }
        val aceptar = findViewById<Button>(R.id.btnAceptar)
        aceptar.setOnClickListener {
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
        var comboGenero = findViewById<Spinner>(R.id.registroGenero)
        var adaptadorGenero =
            ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, itemsGenero);
        comboGenero.adapter = adaptadorGenero


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
        val nombre = findViewById<TextInputEditText>(R.id.registroNombre)
        nombre.setText("")
        val ape1 = findViewById<TextInputEditText>(R.id.registroApe1)
        ape1.setText("")
        val ape2 = findViewById<TextInputEditText>(R.id.registroApe2)
        ape2.setText("")
        val email = findViewById<TextInputEditText>(R.id.registroEmail)
        email.setText("")
        val contraseña = findViewById<TextInputEditText>(R.id.registroContraseña)
        contraseña.setText("")
        val telefono = findViewById<TextInputEditText>(R.id.registroTelefono)
        telefono.setText("")
        val direccion = findViewById<TextInputEditText>(R.id.registroDireccion)
        direccion.setText("")
        val fecha = findViewById<TextInputEditText>(R.id.registroFechaDeNacimiento)
        fecha.setText("")
        val carrera = findViewById<Spinner>(R.id.registroCarrera)
        carrera.setSelection(0)
        val genero = findViewById<Spinner>(R.id.registroGenero)
        genero.setSelection(0)


    }

    fun onDateSelected(day: Int, month: Int, year: Int) {
        this.year = year
        this.month = month
        this.day = day
        val elegirFecha = findViewById<TextInputEditText>(R.id.registroFechaDeNacimiento)
        elegirFecha.setText("$year-$month-$day")
    }


}