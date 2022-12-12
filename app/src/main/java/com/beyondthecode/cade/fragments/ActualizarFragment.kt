package com.beyondthecode.cade.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.beyondthecode.cade.R
import com.beyondthecode.cade.api.modelos.AlumnoDto
import com.beyondthecode.cade.api.modelos.AlumnoOBJ
import com.beyondthecode.cade.api.modelos.AlumnoUpdateDto
import com.beyondthecode.cade.api.repositorios.AlumnoRepository
import com.beyondthecode.cade.api.retrofit.ApiClientt
import com.beyondthecode.cade.databinding.FragmentActualizarBinding
import com.beyondthecode.cade.views.Matricula
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ActualizarFragment : Fragment() {


    var binding: FragmentActualizarBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentActualizarBinding.inflate(layoutInflater)
        actualizarDatos()


        binding?.btnActualizar!!.setOnClickListener { view ->
            var alumnoUpdateDto: AlumnoUpdateDto = AlumnoUpdateDto(
                binding?.actEmail!!.text.toString(),
                binding?.actContraseA!!.text.toString(),
                binding?.actTelefono!!.text.toString(),
                binding?.actDireccion!!.text.toString(),
            )
            var service = ApiClientt.getRetrofitInstance()?.create(AlumnoRepository::class.java)
            service?.updateAlumn(alumnoUpdateDto, AlumnoOBJ.alumno!!.id)
                ?.enqueue(object : Callback<AlumnoDto?> {
                    override fun onResponse(
                        call: Call<AlumnoDto?>,
                        response: Response<AlumnoDto?>
                    ) {
                        Toast.makeText(
                            binding?.root!!.context,
                            "actualizado... ",
                            Toast.LENGTH_SHORT
                        ).show()
                        AlumnoOBJ.alumno = response.body()
                        activity?.onBackPressed();

                        val view =
                            View.inflate(binding!!.root.context, R.layout.alerta_actualizado, null)
                        val builder = AlertDialog.Builder(binding!!.root.context)
                        builder.setView(view)

                        val dialog = builder.create()
                        dialog.show()
                        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                        Toast.makeText(
                            binding?.root!!.context,
                            "informacion del " +
                                    "\n ${response.body()?.id} actualizado correctamente ",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onFailure(call: Call<AlumnoDto?>, t: Throwable) {
                        Toast.makeText(
                            binding?.root!!.context,
                            "no se pudo registrar, pero si... ",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(Intent(binding?.root!!.context, Matricula::class.java))
                    }


                })
        }
        return binding!!.root
    }

    private fun actualizarDatos() {
        binding?.actEmail!!.setText(AlumnoOBJ.alumno?.correoAlumno)
        binding?.actContraseA!!.setText(AlumnoOBJ.alumno?.contraseniaAlumno)
        binding?.actTelefono!!.setText(AlumnoOBJ.alumno?.telefonoAlumno)
        binding?.actDireccion!!.setText(AlumnoOBJ.alumno?.direccionAlumno)
    }
}