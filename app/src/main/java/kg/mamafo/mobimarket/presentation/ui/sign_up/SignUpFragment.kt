package kg.mamafo.mobimarket.presentation.ui.sign_up

import android.annotation.SuppressLint
import android.text.InputType
import android.util.Patterns
import android.view.MotionEvent
import android.view.View.GONE
import android.view.View.VISIBLE
import kg.mamafo.mobimarket.databinding.FragmentSignUpBinding
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment
import kg.mamafo.mobimarket.presentation.utils.KeyboardHelper

class SignUpFragment : BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {

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
                vb.etEmail.error = "Enter email mazafaka"
                vb.etUserName.error = "Enter your name please"
//                vb.rlUsernameEmail.visibility = VISIBLE
//                vb.btnHidePassword.visibility = GONE
//                vb.rlPassword.visibility = GONE
            }
        }
        showPassword()
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