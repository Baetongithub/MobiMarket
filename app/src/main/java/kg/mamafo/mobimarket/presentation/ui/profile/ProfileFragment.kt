package kg.mamafo.mobimarket.presentation.ui.profile

import kg.mamafo.mobimarket.R
import kg.mamafo.mobimarket.data.remote.Status
import kg.mamafo.mobimarket.databinding.FragmentProfileBinding
import kg.mamafo.mobimarket.presentation.extensions.glide
import kg.mamafo.mobimarket.presentation.extensions.toast
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val viewModel: ProfileViewModel by viewModel()

    override fun setUpUI() {

        vb.tvFavoriteProducts.setOnClickListener { navigate(R.id.action_profileFragment_to_likedProductsFragment) }
        vb.tvMyGoods.setOnClickListener { navigate(R.id.action_profileFragment_to_myProductsFragment) }
        vb.btnFinishRegistration.setOnClickListener { navigate(R.id.action_profileFragment_to_finishRegistrationFragment) }
    }

    override fun setData() {
        super.setData()
        getProfileData()
    }

    private fun getProfileData() {
        viewModel.getProfile().observe(this) { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    resource.data?.avatar?.let { vb.imageProfile.glide(it) }
                    resource.data?.email?.let { toast(it) }
                    resource.data?.firstName?.let { toast(it) }
                }
                Status.LOADING -> toast("Загрузка")
                Status.ERROR -> toast("Произошла ошибка${resource.code}+ ${resource.message}")
            }
        }
    }
}