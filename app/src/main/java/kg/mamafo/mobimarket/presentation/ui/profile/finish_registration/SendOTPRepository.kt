package kg.mamafo.mobimarket.presentation.ui.profile.finish_registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kg.mamafo.mobimarket.data.model.CodeSend
import kg.mamafo.mobimarket.data.remote.MobiMarketAPI
import kg.mamafo.mobimarket.data.remote.Resource
import kotlinx.coroutines.Dispatchers

class SendOTPRepository(private val loginAPi: MobiMarketAPI) {

    fun sendOTP(phoneNumber: CodeSend): LiveData<Resource<CodeSend>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading(null))
            val response = loginAPi.sendOTP(phoneNumber)
            emit(
                if (response.isSuccessful) Resource.success(response.body())
                else Resource.error(response.message(), response.body(), response.code())
            )
        }
    }
}