package com.beyondthecode.cade.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.beyondthecode.cade.R
import com.beyondthecode.cade.databinding.FragmentInformacionBinding

class FragmentInformacion : Fragment() {
    var binding: FragmentInformacionBinding? = null
    lateinit var drawerLayout: DrawerLayout
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentInformacionBinding.inflate(layoutInflater)

        binding?.btnActualizar!!.setOnClickListener {
            /*remplaceFragment(ActualizarFragment())*/
        }
        return binding!!.root
    }
   /* private fun remplaceFragment(fragment: Fragment){
        val fragmentTransaction=fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.frameLayout,fragment)
        fragmentTransaction?.commit()
        drawerLayout.closeDrawers()
    }*/

}