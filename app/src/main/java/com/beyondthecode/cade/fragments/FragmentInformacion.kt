package com.beyondthecode.cade.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.beyondthecode.cade.R
import com.beyondthecode.cade.api.modelos.AlumnoDto
import com.beyondthecode.cade.api.modelos.AlumnoOBJ
import com.beyondthecode.cade.databinding.FragmentInformacionBinding

class FragmentInformacion : Fragment() {
    var binding: FragmentInformacionBinding? = null
    lateinit var drawerLayout: DrawerLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentInformacionBinding.inflate(layoutInflater)
        var alumnn: AlumnoDto? = AlumnoOBJ.alumno
        binding?.actNombre!!.text = alumnn!!.nombreAlumno
        binding?.actApe1!!.text = alumnn.ape1Alumno
        binding?.actApe2!!.text = alumnn.ape2Alumno
        binding?.actEmail!!.text = alumnn.correoAlumno
        binding?.actTelefono!!.text = alumnn.telefonoAlumno
        binding?.actDireccion!!.text = alumnn.direccionAlumno
        binding?.actFechaDeNacimiento!!.text = alumnn.fechaNacimientoAlumno
        //especialidad
        binding?.actCarrera!!.text = alumnn.claveCarreraFk
        //periodo
        //semestre
        binding?.btnActualizar!!.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentInformacion_to_actualizarFragment)
        }
        return binding!!.root
    }

}