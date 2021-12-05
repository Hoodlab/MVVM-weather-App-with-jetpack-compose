package hoods.com.dailyweather.domain.repository

import hoods.com.dailyweather.domain.models.Weather

interface WeatherRepository {
    suspend fun getWeatherData(): State<Weather>
}