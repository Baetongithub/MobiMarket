package kg.mamafo.mobimarket.presentation.ui.profile.finish_registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kg.mamafo.mobimarket.data.model.CodeSend
import kg.mamafo.mobimarket.data.remote.Resource

class SendOTPViewModel(private val profileRepo: SendOTPRepository) : ViewModel() {

    fun sendOTP(phoneNumber: CodeSend): LiveData<Resource<CodeSend>> {
        return profileRepo.sendOTP(phoneNumber)
    }
}