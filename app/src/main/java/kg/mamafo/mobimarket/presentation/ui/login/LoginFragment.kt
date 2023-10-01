package kg.mamafo.mobimarket.presentation.ui.login

import kg.mamafo.mobimarket.R
import kg.mamafo.mobimarket.data.model.Login
import kg.mamafo.mobimarket.data.remote.Status
import kg.mamafo.mobimarket.databinding.FragmentLoginBinding
import kg.mamafo.mobimarket.presentation.extensions.toast
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    private val viewModel: LoginViewModel by viewModel()

    override fun setUpUI() {
        vb.btnTemporary.setOnClickListener { navigateUp() }
        vb.btnSignUp.setOnClickListener {
            navigate(R.id.action_loginFragment_to_signUpFragment)
        }
    }

    override fun setData() {
        super.setData()

        vb.btnSignIn.setOnClickListener {
            login(
                Login(
                    vb.etUserName.text.toString().trim(),
                    vb.etPassword.text.toString().trim(),
                    null
                )
            )
        }
    }

    private fun login(login: Login) {
        viewModel.login(login).observe(this) {
            when (it.status) {
                Status.SUCCESS -> navigateUp()
                Status.LOADING -> toast("Загрузка")
                Status.ERROR -> toast("Произошла ошибка")
            }
        }
    }
}