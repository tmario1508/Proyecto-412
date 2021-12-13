package com.mariotorrese.proyecto_412.ui.alumnos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mariotorrese.proyecto_412.R
import com.mariotorrese.proyecto_412.core.Resource
import com.mariotorrese.proyecto_412.data.remote.AlumnoDataSource
import com.mariotorrese.proyecto_412.data.remote.ApiClient
import com.mariotorrese.proyecto_412.databinding.FragmentAlumnosBinding
import com.mariotorrese.proyecto_412.presentation.AlumnoViewModel
import com.mariotorrese.proyecto_412.presentation.AlumnoViewModelFactory
import com.mariotorrese.proyecto_412.repository.AlumnoRepository
import com.mariotorrese.proyecto_412.repository.AlumnoRepositoryImp
import com.mariotorrese.proyecto_412.ui.alumnos.adapters.AlumnoAdapter


class AlumnosFragment : Fragment(R.layout.fragment_alumnos) {

    private lateinit var binding:FragmentAlumnosBinding
    private lateinit var adapter:AlumnoAdapter

    private val viewModel by viewModels<AlumnoViewModel> {
        AlumnoViewModelFactory(AlumnoRepositoryImp(AlumnoDataSource((ApiClient.service))))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlumnosBinding.bind(view)

        binding.recyclerAlumno.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.fetchAlumnos().observe(viewLifecycleOwner, Observer { result ->
            when(result) {
                is Resource.Loading -> {
                    binding.progressbar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.progressbar.visibility = View.GONE
                    adapter = AlumnoAdapter(result.data.data) { alumno ->
                        Toast.makeText(this.context, alumno.img, Toast.LENGTH_SHORT).show()
                    }

                    binding.recyclerAlumno.adapter = adapter
                    Log.d("LiveData", "${result.data.toString()}")
                }
                is Resource.Failure -> {
                    binding.progressbar.visibility = View.GONE
                    Log.d("LiveData", "${result.exception.toString()}")
                }
            }
        })
    }
}