package com.mariotorrese.proyecto_412.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.mariotorrese.proyecto_412.core.Resource
import com.mariotorrese.proyecto_412.data.model.Alumno
import com.mariotorrese.proyecto_412.repository.AlumnoRepository
import kotlinx.coroutines.Dispatchers

class AlumnoViewModel (private val repository: AlumnoRepository) : ViewModel() {

    fun fetchAlumnos() = liveData(Dispatchers.IO){

        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.getAlumnos()))
        }catch (exception:Exception){
            emit(Resource.Failure(exception))
        }
    }

    fun saveAlumno(alumno: Alumno?) = liveData(Dispatchers.IO){

        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.saveAlumno(alumno)))
        }catch (exception:Exception){
            emit(Resource.Failure(exception))
        }
    }

}

class AlumnoViewModelFactory(private val repository: AlumnoRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AlumnoRepository::class.java).newInstance(repository)
    }
}