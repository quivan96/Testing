package com.anushka.circlecalc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Exception

class CalcViewModel(
    private val calculations: Calculations
) : ViewModel() {

    var radius = MutableLiveData<String>()

    private var _area = MutableLiveData<String?>()
    val area = _area

    private var _circumference = MutableLiveData<String?>()
    val circumference = _circumference


    fun calculate() {

        try {

            val radiusDoubleValue = radius.value?.toDouble()
            if (radiusDoubleValue != null) {
                calculateArea(radiusDoubleValue)
                calculateCircumference(radiusDoubleValue)
            } else {
                _area.value = null
                _circumference.value = null
            }

        } catch (e: Exception) {
            Log.i("MYTAG", e.message.toString())
            _area.value = null
            _circumference.value = null
        }

    }

    fun calculateArea(radius: Double) {
        val calculatedArea = calculations.calculateArea(radius)
        _area.value = calculatedArea.toString()
    }

    fun calculateCircumference(radius: Double) {
        val calculatedCircumference = calculations.calculateCircumference(radius)
        _circumference.value = calculatedCircumference.toString()
    }

}