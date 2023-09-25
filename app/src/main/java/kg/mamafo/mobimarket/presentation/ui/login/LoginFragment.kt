package kg.mamafo.mobimarket.presentation.ui.login

import androidx.navigation.fragment.findNavController
import kg.mamafo.mobimarket.R
import kg.mamafo.mobimarket.databinding.FragmentLoginBinding
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override fun setUpUI() {
        super.setUpUI()
        vb.btnTemporary.setOnClickListener {
            findNavController().navigateUp()
        }
        vb.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }
}