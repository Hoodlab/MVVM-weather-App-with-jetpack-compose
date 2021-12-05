package hoods.com.dailyweather.data.api.models.mappers

import hoods.com.dailyweather.data.api.models.ApiWeather
import hoods.com.dailyweather.domain.models.Weather
import javax.inject.Inject

class ApiWeatherMapper @Inject constructor(
    private val apiDailyMapper: ApiDailyMapper,
    private val apiCurrentWeatherMapper: CurrentWeatherMapper,
) : ApiMapper<Weather, ApiWeather> {
    override fun mapToDomain(apiEntity: ApiWeather): Weather {
        return Weather(
            currentWeather = apiCurrentWeatherMapper.mapToDomain(apiEntity.currentWeather),
            daily = apiDailyMapper.mapToDomain(apiEntity.daily)
        )
    }
}