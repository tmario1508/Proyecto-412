package com.mariotorrese.proyecto_412.data.remote

import com.mariotorrese.proyecto_412.data.model.AlumnosList
import retrofit2.http.GET

interface apiservice {
    //https://testapi.io/api/mte616045/resource/alums

    @GET("alums")
    suspend fun getAlumnos(): AlumnosList
}