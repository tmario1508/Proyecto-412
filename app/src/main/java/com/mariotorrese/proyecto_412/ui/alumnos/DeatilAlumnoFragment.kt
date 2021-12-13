package com.mariotorrese.proyecto_412.ui.alumnos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mariotorrese.proyecto_412.R
import com.mariotorrese.proyecto_412.databinding.FragmentDeatilAlumnoBinding
import com.squareup.picasso.Picasso

class DeatilAlumnoFragment : Fragment(R.layout.fragment_deatil_alumno) {
    private lateinit var binding: FragmentDeatilAlumnoBinding
    private val args by navArgs<DeatilAlumnoFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDeatilAlumnoBinding.bind(view)

        binding.textMatricula.text = args.matricula
        binding.textNombre.text = args.nombre + " " + args.apellidop + " " + args.apellidom
        binding.textCarrera.text = args.especialidad
        binding.textGrupo.text = args.grupo

        Picasso.get().load(args.img).into(binding.imgAlum)
    }
}