package com.beyondthecode.cade.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.beyondthecode.cade.R
import com.beyondthecode.cade.databinding.FragmentInformacionBinding

class FragmentInformacion : Fragment() {
    var binding: FragmentInformacionBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInformacionBinding.inflate(layoutInflater)

        binding?.btnActualizar!!.setOnClickListener {
            val view = View.inflate(binding!!.root.context, R.layout.alerta_actualizado, null)
            val builder = AlertDialog.Builder(binding!!.root.context)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            Toast.makeText(binding!!.root.context, "hola", Toast.LENGTH_SHORT).show()
        }
        return binding!!.root
    }

}