package com.beyondthecode.cade.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.forEach
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.beyondthecode.cade.api.modelos.AlumnoOBJ
import com.beyondthecode.cade.api.modelos.CargaA
import com.beyondthecode.cade.api.modelos.HorarioDTOItem
import com.beyondthecode.cade.api.modelos.cargaRespDTO.CargaDto
import com.beyondthecode.cade.api.repositorios.CargaAcademicaRepository
import com.beyondthecode.cade.api.repositorios.MateriasRepository
import com.beyondthecode.cade.api.retrofit.ApiClientt
import com.beyondthecode.cade.databinding.FragmentLllenadoCargaBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentLllenadoCarga : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLllenadoCargaBinding.inflate(layoutInflater)
        binding.button.setOnClickListener {
            activity?.onBackPressed()
        }
        binding.nombrelCarga.text = AlumnoOBJ.alumno?.nombreAlumno
        binding.matriculalCarga.text = AlumnoOBJ.alumno?.id
        binding.carreralCarga.text = AlumnoOBJ.alumno?.claveCarreraFk
        binding.periodolCarga.text = AlumnoOBJ.alumno?.id?.substring(0, 4)
        binding.FechalCarga.text = "2022"

        var customAdapterAl: CargaAAdapter? = null
        var customAdapterCargaLLena: CargaEAdapter? = null
        var listMat: List<HorarioDTOItem>? = listOf<HorarioDTOItem>()
        //llamada a la API
        val service = ApiClientt.getRetrofitInstance()?.create(MateriasRepository::class.java)
        service?.getMaterias(AlumnoOBJ.alumno!!.claveCarreraFk)
            ?.enqueue(object : Callback<List<HorarioDTOItem>?> {
                override fun onResponse(
                    call: Call<List<HorarioDTOItem>?>,
                    response: Response<List<HorarioDTOItem>?>
                ) {
                    listMat = response.body()
                    listMat = listMat?.sortedBy { it.idGrupoFk.numeroGrupo }
                    customAdapterAl = CargaAAdapter(
                        binding.root.context,
                        listMat
                    )
                    binding.recyclernomateria.adapter = customAdapterAl
                    binding.recyclernomateria.layoutManager =
                        LinearLayoutManager(binding.root.context)

                }

                override fun onFailure(call: Call<List<HorarioDTOItem>?>, t: Throwable) {
                    Toast.makeText(
                        binding.root.context,
                        "no se puede master " + t.message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
        binding.Registrar.setOnClickListener {
            val listMat2 = mutableListOf<HorarioDTOItem>()
            customAdapterAl!!.checkBoxStateArray.forEach { key, value ->
                if (value) listMat2.add(
                    listMat!![key]
                )
            }
            customAdapterCargaLLena = CargaEAdapter(
                binding.root.context,
                listMat2
            )
            //Toast.makeText(binding.root.context, ""+listMat2.toString(), Toast.LENGTH_SHORT).show()
            binding.recyclerCarga.adapter = customAdapterCargaLLena
            binding.recyclerCarga.layoutManager =
                LinearLayoutManager(binding.root.context)
        }
        binding.RegistrarFinal.setOnClickListener {
            val cargaList: MutableList<CargaA> = mutableListOf()

            for (position in 0 until customAdapterCargaLLena!!.itemCount) {
                val viewHolder = binding.recyclerCarga.findViewHolderForAdapterPosition(position)
                val textview = (viewHolder as CargaEAdapter.ViewHolder).binding.textView
                val textview2 = (viewHolder as CargaEAdapter.ViewHolder).binding.textView2
                val textview3 = (viewHolder as CargaEAdapter.ViewHolder).binding.textView3

                val checkBox = (viewHolder as CargaEAdapter.ViewHolder).binding.checkBox
                val checkBox2 = (viewHolder as CargaEAdapter.ViewHolder).binding.checkBox2
                val checkBox3 = (viewHolder as CargaEAdapter.ViewHolder).binding.checkBox3
                var ck: String = ""
                if (!checkBox.isChecked && !checkBox2.isChecked && !checkBox3.isChecked) {
                    Toast.makeText(
                        binding.root.context,
                        "seleccione las casillas",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (checkBox.isChecked) {
                        ck = "1"
                    } else if (checkBox2.isChecked) {
                        ck = "4"
                    } else if (checkBox3.isChecked) {
                        ck = "7"
                    }
                    //
                    val service =
                        ApiClientt.getRetrofitInstance()
                            ?.create(CargaAcademicaRepository::class.java)
                    service?.addCarga(
                        CargaA(
                            AlumnoOBJ.alumno!!.id,
                            textview.text.toString(),
                            ck,
                            "0",
                            textview3.text.substring(1, 2)
                        )
                    )
                        ?.enqueue(object : Callback<CargaDto?> {
                            override fun onResponse(
                                call: Call<CargaDto?>,
                                response: Response<CargaDto?>
                            ) {
                                if (response.code() == 202) {
                                    Toast.makeText(
                                        binding.root.context,
                                        "se agrego correctamente",
                                        Toast.LENGTH_LONG
                                    ).show()
                                }
                            }

                            override fun onFailure(call: Call<CargaDto?>, t: Throwable) {
                                Toast.makeText(
                                    binding.root.context,
                                    "no se puede master " + t.message,
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        })
                }


            }
        }
        return binding.root
    }


}