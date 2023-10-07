package kg.mamafo.mobimarket.presentation.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kg.mamafo.mobimarket.data.model.ProfileRegistration
import kg.mamafo.mobimarket.data.remote.Resource

class ProfileViewModel(private val profileRepo: ProfileRepo) : ViewModel() {

    fun getProfile(): LiveData<Resource<ProfileRegistration>> {
        return profileRepo.getProfile()
    }

}