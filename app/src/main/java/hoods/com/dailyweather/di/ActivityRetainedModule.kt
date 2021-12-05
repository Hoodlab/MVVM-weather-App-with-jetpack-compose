package hoods.com.dailyweather.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import hoods.com.dailyweather.domain.repository.WeatherRepository
import hoods.com.dailyweather.domain.repository.WeatherRepositoryImpl


@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ActivityRetainedModule {


    @Binds
    @ActivityRetainedScoped
    abstract fun bindWeatherRepository(weatherRepositoryImpl: WeatherRepositoryImpl):WeatherRepository










}