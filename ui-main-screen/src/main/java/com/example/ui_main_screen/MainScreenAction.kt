package com.example.ui_main_screen

sealed class MainScreenAction{
    data class OnChairClick(val id:Int): MainScreenAction()
    data class SelectedItem(val id:Int): MainScreenAction()
    data class SelectedTimeItem(val id:Int): MainScreenAction()
    data object OnBuyItemClick:MainScreenAction()


}
