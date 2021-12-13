package com.mariotorrese.proyecto_412.repository

import com.mariotorrese.proyecto_412.data.model.Alumno
import com.mariotorrese.proyecto_412.data.model.AlumnosList
import com.mariotorrese.proyecto_412.data.remote.AlumnoDataSource

class AlumnoRepositoryImp(private val dataSource: AlumnoDataSource) : AlumnoRepository {

    override suspend fun getAlumnos(): AlumnosList = dataSource.getAlumnos()

    override suspend fun saveAlumno(alumno: Alumno?): Alumno? {
        TODO("Not yet implemented")
    }

}