package kg.mamafo.mobimarket.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kg.mamafo.mobimarket.data.model.ProfileRegistration
import kg.mamafo.mobimarket.data.remote.MobiMarketAPI
import kg.mamafo.mobimarket.data.remote.Resource
import kotlinx.coroutines.Dispatchers

class ProfileRepo(private val loginAPi: MobiMarketAPI) {

    fun getProfile(): LiveData<Resource<ProfileRegistration>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val response = loginAPi.getProfileDetails()
            emit(
                if (response.isSuccessful) Resource.success(response.body())
                else Resource.error(response.message(), response.body(), response.code())
            )
        }
    }
}