package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import com.example.dessertclicker.data.DessertUiState
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UiLogicViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    fun desserClicked(){
        setRevenue()
        val dessertToShow = determineDessertToShow()
        setDessert(dessertToShow)
    }

    private fun determineDessertToShow(
        dessertsSold: Int = _uiState.value.dessertSold
    ): Dessert {
        val desserts = Datasource.dessertList
        var dessertToShow = desserts.first()
        for (dessert in desserts) {
            if (dessertsSold >= dessert.startProductionAmount){
                dessertToShow = dessert
            }else{
                break
            }
        }
        return dessertToShow
    }

    private fun setRevenue(){
        _uiState.update {currentState ->
            currentState.copy(
                revenue = _uiState.value.revenue + _uiState.value.currentDessertPrice,
                dessertSold = _uiState.value.dessertSold + 1
            )
        }
    }

    private fun setDessert(dessert: Dessert){
        _uiState.update {currentState ->
            currentState.copy(
                currentDessertImageId = dessert.imageId,
                currentDessertPrice = dessert.price
            )
        }
    }

}