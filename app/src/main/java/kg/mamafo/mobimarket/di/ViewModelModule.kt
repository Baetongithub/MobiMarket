package kg.mamafo.mobimarket.di

import kg.mamafo.mobimarket.presentation.ui.login.LoginViewModel
import kg.mamafo.mobimarket.presentation.ui.profile.ProfileViewModel
import kg.mamafo.mobimarket.presentation.ui.profile.finish_registration.SendOTPViewModel
import kg.mamafo.mobimarket.presentation.ui.sign_up.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { SendOTPViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
}