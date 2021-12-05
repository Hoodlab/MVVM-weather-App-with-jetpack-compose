package hoods.com.dailyweather.domain.repository

import hoods.com.dailyweather.data.api.WeatherApi
import hoods.com.dailyweather.data.api.models.mappers.ApiWeatherMapper
import hoods.com.dailyweather.domain.models.Weather
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val apiWeatherMapper: ApiWeatherMapper,
) : WeatherRepository {
    override suspend fun getWeatherData(): State<Weather> {
        return try {
            val apiWeather = weatherApi.getWeatherData()
            val weather = apiWeatherMapper.mapToDomain(apiWeather)
            State.Success(weather)
        } catch (e: Exception) {
            e.printStackTrace()
            State.Error(e.message.orEmpty())
        }
    }


}