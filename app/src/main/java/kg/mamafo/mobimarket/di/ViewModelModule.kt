package kg.mamafo.mobimarket.di

import kg.mamafo.mobimarket.presentation.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModule = module { viewModel { LoginViewModel(get()) } }