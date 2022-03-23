package com.example.cars.di

import dagger.Module

@Module(
    includes = [
        InteractorsBindModule::class
    ]
)
class InteractorsModule