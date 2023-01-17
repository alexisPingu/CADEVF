package com.beyondthecode.cade.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.beyondthecode.cade.api.modelos.AlumnoOBJ
import com.beyondthecode.cade.api.modelos.CargaSemestreStatusItem
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
        var customAdapterAl: CargaSemestreStatusAdapter? = null
        val service = ApiClientt.getRetrofitInstance()?.create(CargaAcademicaRepository::class.java)
        service?.getExistCarga(AlumnoOBJ.alumno!!.id)?.enqueue(object : Callback<Boolean?> {
            override fun onResponse(
                call: Call<Boolean?>,
                response: Response<Boolean?>
            ) {
                if (response.code() == 200) {
                    if (response.body() == true) {
                        binding!!.textos.setText("notificaciones")
                        service?.getCargasSemestresStatus(AlumnoOBJ.alumno!!.id)
                            ?.enqueue(object : Callback<List<CargaSemestreStatusItem>?> {
                                override fun onResponse(
                                    call: Call<List<CargaSemestreStatusItem>?>,
                                    response: Response<List<CargaSemestreStatusItem>?>
                                ) {
                                    if (response.code() == 200) {
                                        customAdapterAl = CargaSemestreStatusAdapter(
                                            binding?.root!!.context,
                                            response.body()
                                        )
                                        binding?.recyclernomateria!!.adapter = customAdapterAl
                                        binding?.recyclernomateria!!.layoutManager =
                                            LinearLayoutManager(binding?.root!!.context)
                                    }
                                }

                                override fun onFailure(
                                    call: Call<List<CargaSemestreStatusItem>?>,
                                    t: Throwable
                                ) {
                                    Toast.makeText(
                                        binding!!.root.context,
                                        "no se puede master " + t.message,
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            })
                    } else {
                        binding!!.textos.setText("No tienes notificaciones :3")
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