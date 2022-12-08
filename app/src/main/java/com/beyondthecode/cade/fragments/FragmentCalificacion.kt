package com.beyondthecode.cade.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.beyondthecode.cade.api.modelos.AlumnoDto
import com.beyondthecode.cade.api.modelos.AlumnoOBJ
import com.beyondthecode.cade.databinding.FragmentCalificacionBinding


class FragmentCalificacion : Fragment() {

    var binding: FragmentCalificacionBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCalificacionBinding.inflate(layoutInflater)
        var alumnn: AlumnoDto? = AlumnoOBJ.alumno
        binding?.calMatricula!!.text = alumnn?.id
        binding?.calNombre!!.text = alumnn?.nombreAlumno
        binding?.calSemestre!!.text = alumnn?.claveCarreraFk
        var customAdapterAl: CalificacionesAdapter? = null
        /*llamada a la API
        var service = ApiClientt.getRetrofitInstance()?.create(CalificacionesRepository::class.java)
        service?.getKardex(alumnn!!.id)?.enqueue(object : Callback<Calificaciones?> {
            override fun onResponse(
                call: Call<Calificaciones?>,
                response: Response<Calificaciones?>
            ) {
                customAdapterAl = CalificacionesAdapter(
                    binding?.root!!.context,
                    response.body()?.calificacionBcodeDtoList
                )
                binding?.recyclerCalificaciones!!.adapter = customAdapterAl
                binding?.recyclerCalificaciones!!.layoutManager =
                    LinearLayoutManager(binding?.root!!.context)
            }

            override fun onFailure(call: Call<Calificaciones?>, t: Throwable) {
                Toast.makeText(
                    binding?.root!!.context,
                    "no se puede master " + t.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        })*/
        return binding!!.root
    }
}