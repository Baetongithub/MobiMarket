package kg.mamafo.mobimarket.presentation.ui.profile

import kg.mamafo.mobimarket.databinding.FragmentEditProfileBinding
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment

class EditProfileFragment : BaseFragment<FragmentEditProfileBinding>(FragmentEditProfileBinding::inflate) {

    override fun setUpUI() {
      vb.btnBack.setOnClickListener { navigateUp() }
    }
}