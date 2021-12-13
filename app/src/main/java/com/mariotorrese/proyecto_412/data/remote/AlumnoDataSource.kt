package com.mariotorrese.proyecto_412.data.remote

import com.mariotorrese.proyecto_412.data.model.AlumnosList

class AlumnoDataSource (private  val apiService: apiservice){

    suspend fun getAlumnos(): AlumnosList = apiService.getAlumnos()

}