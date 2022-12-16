package com.beyondthecode.cade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.beyondthecode.cade.R
import com.beyondthecode.cade.api.modelos.AlumnoDto
import com.beyondthecode.cade.api.modelos.AlumnoOBJ

import com.beyondthecode.cade.databinding.FragmentHorarioBinding
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView

class FragmentHorario : Fragment()  {


    private var alumno: AlumnoDto? =AlumnoOBJ.alumno
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentHorarioBinding.inflate(layoutInflater)
       when(alumno!!.claveCarreraFk){
           "ICIE-CON-2021-01"->{binding.imageView.setImage(ImageSource.resource(R.drawable.horario))}
           "IELE-2010-209"->{binding.imageView.setImage(ImageSource.resource(R.drawable.horario))}
           "IINE-GCP-2017-1"->{binding.imageView.setImage(ImageSource.resource(R.drawable.horario))}
           "ILOG-2009-202"->{binding.imageView.setImage(ImageSource.resource(R.drawable.horario))}
           "IMCT-2010-229"->{binding.imageView.setImage(ImageSource.resource(R.drawable.horario))}
           "IQUI-2010-232"->{binding.imageView.setImage(ImageSource.resource(R.drawable.horario))}
           "ISIE-CLC-2020-01"->{binding.imageView.setImage(ImageSource.resource(R.drawable.horario))}
           "ITIE-TDI-2020-01"->{binding.imageView.setImage(ImageSource.resource(R.drawable.horario))}
           "LADE-DGT-2021-01"->{binding.imageView.setImage(ImageSource.resource(R.drawable.horario))}
       }

            binding.imageView.setImage(ImageSource.resource(R.drawable.horario))

        return binding!!.root
    }

}