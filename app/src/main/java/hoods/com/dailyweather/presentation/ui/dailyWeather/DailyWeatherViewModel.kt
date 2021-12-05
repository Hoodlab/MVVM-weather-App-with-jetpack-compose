package hoods.com.dailyweather.presentation.ui.dailyWeather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hoods.com.dailyweather.domain.models.Weather
import hoods.com.dailyweather.domain.repository.State
import hoods.com.dailyweather.domain.repository.WeatherRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DailyWeatherViewModel @Inject constructor(private val repositoryImpl: WeatherRepositoryImpl)
    : ViewModel() {
    var state by mutableStateOf(DailyWeatherState())
        private set
    init {
        viewModelScope.launch {
            state = DailyWeatherState(repositoryImpl.getWeatherData())
        }
    }



}

data class DailyWeatherState(
    val weather:State<Weather> = State.Loading()
)