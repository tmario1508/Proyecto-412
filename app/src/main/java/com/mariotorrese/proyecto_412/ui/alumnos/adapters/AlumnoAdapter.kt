package com.mariotorrese.proyecto_412.ui.alumnos.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mariotorrese.proyecto_412.R
import com.mariotorrese.proyecto_412.data.model.Alumno
import com.mariotorrese.proyecto_412.databinding.FragmentItemAlumnoBinding
import com.mariotorrese.proyecto_412.ui.alumnos.Item_Alumno
import com.squareup.picasso.Picasso

class AlumnoAdapter (private val alumnos:List<Alumno>, private  val listener:(Alumno) -> Unit) : RecyclerView.Adapter<AlumnoAdapter.ViewHolder>(){

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val binding = FragmentItemAlumnoBinding.bind(v)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v:View = LayoutInflater.from(parent.context).inflate(R.layout.fragment_item__alumno, parent, false)
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alumno = alumnos[position]

        holder.itemView.setOnClickListener {
            listener(alumno)
        }
        Picasso.get().load(alumno.img).into(holder.binding.imgAlumno)
        holder.binding.txtNombre.text = alumno.nombre + " " + alumno.apellidop + " " + alumno.apellidom
        holder.binding.txtMatricula.text = alumno.matricula
    }

    override fun getItemCount(): Int {
        return alumnos.size
    }
}