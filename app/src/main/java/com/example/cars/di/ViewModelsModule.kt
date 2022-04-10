package com.example.cars.di

import androidx.lifecycle.ViewModel
import com.example.cars.app.presentation.MainActivityViewModel
import com.example.cars.app.presentation.addPost.AddPostFragmentViewModel
import com.example.cars.app.presentation.addPost.bottomSheet.CarModelsBottomFragmentViewModel
import com.example.cars.app.presentation.carModelsPage.CarModelsFragmentViewModel
import com.example.cars.app.presentation.favouritePosts.FavouritePostsFragmentViewModel
import com.example.cars.app.presentation.mainPage.MainPageFragmentViewModel
import com.example.cars.app.presentation.personalPage.PersonalPageFragmentViewModel
import com.example.cars.app.presentation.userPosts.UserPostsFragmentViewModel
import com.example.cars.registration.presentation.login.LoginActivityViewModel
import com.example.cars.registration.presentation.register.RegisterActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(RegisterActivityViewModel::class)
    fun provideRegisterActivityViewModel(registerActivityViewModel: RegisterActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginActivityViewModel::class)
    fun provideLoginActivityViewModel(loginActivityViewModel: LoginActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AddPostFragmentViewModel::class)
    fun provideAddCarFragmentViewModel(addPostFragmentViewModel: AddPostFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CarModelsBottomFragmentViewModel::class)
    fun provideCarModelsBottomFragmentViewModel(carModelsBottomFragmentViewModel: CarModelsBottomFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CarModelsFragmentViewModel::class)
    fun provideCarModelsFragmentViewModel(carModelsFragmentViewModel: CarModelsFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavouritePostsFragmentViewModel::class)
    fun provideFavouritePostsFragmentViewModel(favouritePostsFragmentViewModel: FavouritePostsFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun provideMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainPageFragmentViewModel::class)
    fun provideMainPageFragmentViewModel(mainPageFragmentViewModel: MainPageFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PersonalPageFragmentViewModel::class)
    fun providePersonalPageFragmentViewModel(personalPageFragmentViewModel: PersonalPageFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserPostsFragmentViewModel::class)
    fun providePUserPostsFragmentViewModel(userPostsFragmentViewModel: UserPostsFragmentViewModel): ViewModel

}