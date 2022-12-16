package com.beyondthecode.cade.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.beyondthecode.cade.R
import com.beyondthecode.cade.databinding.FragmentCargaBinding
import com.beyondthecode.cade.databinding.FragmentLllenadoCargaBinding


class FragmentLllenadoCarga : Fragment() {




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentLllenadoCargaBinding.inflate(layoutInflater)
        binding?.button!!.setOnClickListener{
            activity?.onBackPressed()
        }
        return binding?.root
    }


}