package hoods.com.dailyweather.domain.models

data class CurrentWeather(
    val temperature: Double,
    val time: String,
    val weatherStatus: String,
    val windDirection: String,
    val windSpeed: Double,
)
