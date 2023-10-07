package kg.mamafo.mobimarket.presentation.ui.profile.finish_registration

import kg.mamafo.mobimarket.data.model.CodeSend
import kg.mamafo.mobimarket.data.remote.Status
import kg.mamafo.mobimarket.databinding.FragmentAddPhoneNumberBinding
import kg.mamafo.mobimarket.presentation.extensions.toast
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddPhoneNumberFragment :
    BaseFragment<FragmentAddPhoneNumberBinding>(FragmentAddPhoneNumberBinding::inflate) {

    private val viewModel: SendOTPViewModel by viewModel()

    override fun setUpUI() {
        vb.btnBack.setOnClickListener { navigateUp() }
    }

    override fun setData() {
        super.setData()
        vb.btnFurther.setOnClickListener {
            sendOTP(
                CodeSend(
                    vb.etAddPhoneNumber.text.toString().trim()
                )
            )
        }
    }

    private fun sendOTP(phoneNumber: CodeSend) {
        viewModel.sendOTP(phoneNumber).observe(this) { resource ->
            when (resource.status) {
                Status.SUCCESS -> {
                    toast("Success")
                }
                Status.LOADING -> toast("Загрузка")
                Status.ERROR -> toast("Произошла ошибка${resource.code}+ ${resource.message}")
            }
        }
    }
}