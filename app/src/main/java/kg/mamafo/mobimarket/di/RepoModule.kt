package kg.mamafo.mobimarket.di

import kg.mamafo.mobimarket.presentation.ui.login.LoginRepository
import kg.mamafo.mobimarket.presentation.ui.profile.ProfileRepo
import kg.mamafo.mobimarket.presentation.ui.profile.finish_registration.SendOTPRepository
import kg.mamafo.mobimarket.presentation.ui.sign_up.SignUpRepo
import org.koin.dsl.module

val repoModule = module {
    single { LoginRepository(get()) }
    single { ProfileRepo(get()) }
    single { SendOTPRepository(get()) }
    single { SignUpRepo(get()) }
}