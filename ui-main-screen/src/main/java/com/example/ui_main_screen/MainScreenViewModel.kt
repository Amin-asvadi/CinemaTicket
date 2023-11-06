package com.example.ui_main_screen

import androidx.lifecycle.viewModelScope
import com.example.base_android.utils.BaseViewModel
import com.example.domain.chair.BuyTicketUseCase
import com.example.domain.chair.GetChairUseCase
import com.example.domain.chair.GetDaysUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getChairUseCase: GetChairUseCase,
    private val daysUseCase: GetDaysUseCase,
    private val buyTicketUseCase: BuyTicketUseCase
) : BaseViewModel<MainScreenState, MainScreenAction>(
    MainScreenState()
) {
    init {
        initialData()
        onEachAction { action ->
            when (action) {
                is MainScreenAction.OnChairClick -> {
                    setState {
                        copy(
                            chair = state.chair.toMutableList().map { chair ->
                                if (chair.id == action.id) {
                                    chair.copy(isSelected = !chair.isSelected)
                                } else {
                                    chair
                                }
                            }
                        )
                    }
                }

                is MainScreenAction.SelectedItem -> setState { copy(isSelectedDay = action.id) }
                is MainScreenAction.SelectedTimeItem -> setState { copy(isSelectedTime = action.id) }
                is MainScreenAction.OnBuyItemClick -> buyTicket()
                else -> throw IllegalArgumentException("unknown action: $action")
            }
        }
        onAsyncResult(
            MainScreenState::chairResponseData,
            onSuccess = {
                setState { copy(chair = it) }
            },
            onFail = {
                val errorMessage = it.message
            }
        )
        onAsyncResult(
            MainScreenState::daysResponseData,
            onSuccess = {
                setState { copy(daysOfMonth = it) }
            },
            onFail = {
                val errorMessage = it.message
            }
        )
    }

    private fun buyTicket() {
        viewModelScope.launch {
            suspend {
                val param = BuyTicketUseCase.Param(
                    seat_id = "1",
                    hour = "1:00",
                    day = "8"
                )
                buyTicketUseCase(param)
            }.execute {
                copy(buyTicketResponse = it)
            }
        }
    }

    private fun initialData() {
        getChair()
        getDays()
    }

    private fun getChair() {
        viewModelScope.launch {
            suspend {

                getChairUseCase(Unit)
            }.execute {
                copy(chairResponseData = it)
            }
        }
    }

    private fun getDays() {
        viewModelScope.launch {
            suspend {

                daysUseCase(Unit)
            }.execute {
                copy(daysResponseData = it)
            }
        }
    }
}