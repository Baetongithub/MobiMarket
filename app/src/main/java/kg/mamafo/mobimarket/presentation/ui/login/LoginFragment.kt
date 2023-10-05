package kg.mamafo.mobimarket.presentation.ui.login

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import kg.mamafo.mobimarket.R
import kg.mamafo.mobimarket.data.model.Login
import kg.mamafo.mobimarket.data.remote.Status
import kg.mamafo.mobimarket.databinding.FragmentLoginBinding
import kg.mamafo.mobimarket.presentation.extensions.toast
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment
import kg.mamafo.mobimarket.presentation.utils.Constants
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
                    vb.etPassword.text.toString().trim()
                )
            )
        }
    }

    private fun login(login: Login) {
        viewModel.login(login).observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    navigateUp()
                    val sharedPreferences: SharedPreferences? =
                        activity?.getSharedPreferences(
                            Constants.SHARED_PREFS_SIGNED_UP,
                            MODE_PRIVATE
                        )
                    val myEdit = sharedPreferences?.edit()

                    myEdit?.putBoolean(Constants.PREFS_SIGNED_UP, true)
                    myEdit?.apply()
                }
                Status.LOADING -> toast("Загрузка")
                Status.ERROR -> toast("Произошла ошибка")
            }
        }
    }
}