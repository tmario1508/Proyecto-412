package com.mariotorrese.proyecto_412.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mariotorrese.proyecto_412.R
import com.mariotorrese.proyecto_412.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        binding.onEstudiantes.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToAlumnosFragment()
            findNavController().navigate(action)
        }

        binding.onAsistencia.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToAsistenciaFragment()
            findNavController().navigate(action)
        }

        binding.onSalir.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToFirebaseLoginFragment()
            findNavController().navigate(action)
        }
    }

}