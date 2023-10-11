package kg.mamafo.mobimarket.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kg.mamafo.mobimarket.data.model.Login
import kg.mamafo.mobimarket.data.model.TokenObtainPair
import kg.mamafo.mobimarket.data.remote.Resource

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    fun login(login: Login): LiveData<Resource<Login>> {
        return loginRepository.login(login)
    }

    fun token(tokenObtainPair: TokenObtainPair): LiveData<Resource<TokenObtainPair>> {
        return loginRepository.token(tokenObtainPair)
    }
}