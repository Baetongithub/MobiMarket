package kg.mamafo.mobimarket.di

import kg.mamafo.mobimarket.presentation.ui.login.LoginRepository
import org.koin.dsl.module

val repoModule = module { single { LoginRepository(get()) } }