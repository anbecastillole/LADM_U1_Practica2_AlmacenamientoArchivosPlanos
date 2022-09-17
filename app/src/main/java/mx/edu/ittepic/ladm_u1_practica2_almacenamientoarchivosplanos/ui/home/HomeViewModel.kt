package mx.edu.ittepic.ladm_u1_practica2_almacenamientoarchivosplanos.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Frutería y Verdulería La Huerta"
    }
    val text: LiveData<String> = _text
}