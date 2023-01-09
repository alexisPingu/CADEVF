package com.beyondthecode.cade.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.beyondthecode.cade.api.modelos.AlumnoOBJ
import com.beyondthecode.cade.api.repositorios.CargaAcademicaRepository
import com.beyondthecode.cade.api.retrofit.ApiClientt
import com.beyondthecode.cade.databinding.FragmentNotificacionBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentNotificacion : Fragment() {


    var binding: FragmentNotificacionBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotificacionBinding.inflate(layoutInflater)
        //llamada a la API
        val service = ApiClientt.getRetrofitInstance()?.create(CargaAcademicaRepository::class.java)
        service?.getExistCarga(AlumnoOBJ.alumno!!.id)?.enqueue(object : Callback<Boolean?> {
            override fun onResponse(
                call: Call<Boolean?>,
                response: Response<Boolean?>
            ) {
                if (response.code() == 200) {
                    if (response.body()!!) {
                        binding!!.textos.setText("tu carga academica se valido")
                    } else {
                        binding!!.textos.setText("tu carga academica aun no se ha valido")
                    }
                }
            }

            override fun onFailure(call: Call<Boolean?>, t: Throwable) {
                Toast.makeText(
                    binding!!.root.context,
                    "no se puede master " + t.message,
                    Toast.LENGTH_LONG
                ).show()
            }
        })
        return binding?.root
    }
}