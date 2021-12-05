package hoods.com.dailyweather.data.api.models.mappers

import hoods.com.dailyweather.data.api.models.ApiDaily
import hoods.com.dailyweather.domain.models.Daily
import hoods.com.dailyweather.utils.Util
import javax.inject.Inject

class ApiDailyMapper @Inject constructor() : ApiMapper<Daily, ApiDaily> {
    override fun mapToDomain(apiEntity: ApiDaily): Daily {
        return Daily(
            temperatureMax = apiEntity.temperatureMax,
            temperatureMin = apiEntity.temperatureMin,
            time = parseTime(apiEntity.time),
            weatherStatus = parseWeatherStatus(apiEntity.weatherCode),
            windDirection = parseWindDirection(apiEntity.windDirection),
            windSpeed = apiEntity.windSpeed
        )
    }

    private fun parseTime(time: List<Long>): List<String> {
        return time.map {
            Util.formatDate("E", it)
        }
    }

    private fun parseWeatherStatus(code: List<Int>): List<String> {
        return code.map {
            Util.getWeatherInfo(it)
        }
    }

    private fun parseWindDirection(windDirections: List<Double>): List<String> {
        return windDirections.map {
            Util.getWindDirection(it)
        }
    }


}