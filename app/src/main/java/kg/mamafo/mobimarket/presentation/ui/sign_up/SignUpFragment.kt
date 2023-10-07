package kg.mamafo.mobimarket.presentation.ui.sign_up

import android.annotation.SuppressLint
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Patterns
import android.view.MotionEvent
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.viewModels
import kg.mamafo.mobimarket.data.model.Registration
import kg.mamafo.mobimarket.data.remote.Status
import kg.mamafo.mobimarket.databinding.FragmentSignUpBinding
import kg.mamafo.mobimarket.presentation.extensions.toast
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment
import kg.mamafo.mobimarket.presentation.utils.KeyboardHelper
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

    private val viewModel: SignUpViewModel by viewModel()

    override fun setUpUI() {
        vb.btnBack.setOnClickListener { navigateUp() }

        vb.btnSignIn.setOnClickListener {
            if (Patterns.EMAIL_ADDRESS.matcher(vb.etEmail.text.toString())
                    .matches() && vb.etUserName.text.isNotEmpty()
            ) {
                vb.rlUsernameEmail.visibility = GONE
                vb.btnHidePassword.visibility = VISIBLE
                vb.rlPassword.visibility = VISIBLE
                KeyboardHelper.showKeyboard(this.context, vb.etPassword)
            } else {
                vb.etEmail.error = "Enter email here"
                vb.etUserName.error = "Enter your name please"
//                vb.rlUsernameEmail.visibility = VISIBLE
//                vb.btnHidePassword.visibility = GONE
//                vb.rlPassword.visibility = GONE
            }
        }
        createPasswordLayout()
        showPassword()
    }

    private fun createPasswordLayout() {

        vb.etPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                vb.btnFurther.isEnabled = p0.toString().length == 8
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        vb.etPasswordConfirm.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                vb.btnFurther.isEnabled = p0.toString().length == 8

                if (p0.toString().length == 8) vb.btnFurther.text = "Готово"
                else vb.btnFurther.text = "Далее"
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        vb.btnFurther.setOnClickListener {
            if (vb.btnFurther.text == "Готово"
                && isValidPassword(vb.etPasswordConfirm.text.toString())
            ) {
                signUp(
                    Registration(
                        vb.etUserName.text.toString(),
                        vb.etEmail.text.toString(),
                        vb.etPassword.text.toString(),
                        vb.etPasswordConfirm.text.toString()
                    )
                )
            } else {
                vb.etPassword.error = "incorrect password"
                vb.etPasswordConfirm.error = "incorrect password"
                vb.btnFurther.text = "Далее"
            }
        }
    }

    private fun signUp(registration: Registration) {
        viewModel.signUp(registration).observe(this) { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    navigateUp()
                    toast("Success")
                }
                Status.LOADING -> toast("Загрузка")
                Status.ERROR -> toast("Произошла ошибка${resource.code}+ ${resource.message}")
            }
        }
    }

    private fun isValidPassword(password: String): Boolean {
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        val pattern: Pattern = Pattern.compile(passwordPattern)
        val matcher: Matcher = pattern.matcher(password)
        return matcher.matches()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun showPassword() {
        vb.btnHidePassword.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_UP -> {
                    vb.etPassword.inputType =
                        InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                    vb.etPasswordConfirm.inputType =
                        InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                }
                MotionEvent.ACTION_DOWN -> {
                    vb.etPassword.inputType = InputType.TYPE_CLASS_TEXT
                    vb.etPasswordConfirm.inputType = InputType.TYPE_CLASS_TEXT
                }
            }
            true
        }
    }
}