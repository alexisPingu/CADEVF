package com.beyondthecode.cade.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.beyondthecode.cade.R
import com.beyondthecode.cade.databinding.FragmentCargaBinding


class FragmentCarga : Fragment() {
    var binding: FragmentCargaBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCargaBinding.inflate(layoutInflater)
        binding?.btnCarga!!.setOnClickListener{
            it.findNavController().navigate(R.id.action_item_carga_to_fragmentLllenadoCarga)
        }
        return binding?.root
    }
}