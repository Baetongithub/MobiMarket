package kg.mamafo.mobimarket.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kg.mamafo.mobimarket.data.model.Login
import kg.mamafo.mobimarket.data.model.TokenObtainPair
import kg.mamafo.mobimarket.data.remote.MobiMarketAPI
import kg.mamafo.mobimarket.data.remote.Resource
import kotlinx.coroutines.Dispatchers

class LoginRepository(private val loginAPi: MobiMarketAPI) {

    fun login(login: Login): LiveData<Resource<Login>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val response = loginAPi.login(login)
            emit(
                if (response.isSuccessful) Resource.success(response.body())
                else Resource.error(response.message(), response.body(), response.code())
            )
        }
    }

    fun token(tokenObtainPair: TokenObtainPair): LiveData<Resource<TokenObtainPair>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val response = loginAPi.token(tokenObtainPair)
            emit(
                if (response.isSuccessful) Resource.success(response.body())
                else Resource.error(response.message(), response.body(), response.code())
            )
        }
    }
}