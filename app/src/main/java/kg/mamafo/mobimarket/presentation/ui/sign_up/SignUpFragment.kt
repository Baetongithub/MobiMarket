package kg.mamafo.mobimarket.presentation.ui.sign_up

import androidx.navigation.fragment.findNavController
import kg.mamafo.mobimarket.databinding.FragmentSignUpBinding
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    override fun setUpUI() {
        super.setUpUI()
        vb.btnBack.setOnClickListener { findNavController().navigateUp() }
    }
}