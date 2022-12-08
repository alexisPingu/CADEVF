package com.beyondthecode.cade.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
        return inflater.inflate(R.layout.fragment_carga, container, false)
    }
}