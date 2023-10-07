package kg.mamafo.mobimarket.presentation.ui.sign_up

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kg.mamafo.mobimarket.data.model.Registration
import kg.mamafo.mobimarket.data.remote.Resource

class SignUpViewModel(private val signUpRepo: SignUpRepo) : ViewModel() {

    fun signUp(registration: Registration): LiveData<Resource<Registration>> {
        return signUpRepo.signUp(registration)
    }

}