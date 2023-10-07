package kg.mamafo.mobimarket.presentation.ui.sign_up

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kg.mamafo.mobimarket.data.model.Registration
import kg.mamafo.mobimarket.data.remote.MobiMarketAPI
import kg.mamafo.mobimarket.data.remote.Resource
import kotlinx.coroutines.Dispatchers

class SignUpRepo(private val loginAPi: MobiMarketAPI) {

    fun signUp(registration: Registration): LiveData<Resource<Registration>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val response = loginAPi.registration(registration)
            emit(
                if (response.isSuccessful) Resource.success(response.body())
                else Resource.error(response.message(), response.body(), response.code())
            )
        }
    }
}