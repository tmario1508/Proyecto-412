package com.mariotorrese.proyecto_412.repository

import com.mariotorrese.proyecto_412.data.model.Alumno
import com.mariotorrese.proyecto_412.data.model.AlumnosList

interface AlumnoRepository {

    suspend fun getAlumnos(): AlumnosList

    suspend fun saveAlumno(alumno: Alumno?) : Alumno?

}