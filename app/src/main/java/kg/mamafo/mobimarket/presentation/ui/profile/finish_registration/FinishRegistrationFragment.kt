package kg.mamafo.mobimarket.presentation.ui.profile.finish_registration

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.net.Uri
import androidx.activity.result.contract.ActivityResultContracts
import kg.mamafo.mobimarket.R
import kg.mamafo.mobimarket.databinding.FragmentFinishRegistrationBinding
import kg.mamafo.mobimarket.presentation.extensions.toast
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment
import java.text.SimpleDateFormat
import java.util.*

class FinishRegistrationFragment :
    BaseFragment<FragmentFinishRegistrationBinding>(FragmentFinishRegistrationBinding::inflate) {

    private val myCalendar = Calendar.getInstance()

    override fun setUpUI() {
        vb.btnCancelInToolbar.setOnClickListener { navigateUp() }
        vb.tvEmail.setOnClickListener { toast(vb.tvEmail.text.toString()) }

        vb.tvAddPhoneNumber.setOnClickListener { navigate(R.id.action_finishRegistrationFragment_to_addPhoneNumberFragment) }

        setUpBirthDay()
        uploadProfilePhoto()
    }

    private fun uploadProfilePhoto() {
        var uri: Uri
        val imageFromGallery =
            registerForActivityResult(ActivityResultContracts.GetContent()) { galleryUri ->
                if (galleryUri != null) {
                    uri = galleryUri
                    vb.imageProfile.setImageURI(uri)
                }
            }
        vb.tvChoosePhoto.setOnClickListener {
            imageFromGallery.launch("image/*")
        }
    }

    private fun setUpBirthDay() {
        val date =
            OnDateSetListener { view, year, month, day ->
                myCalendar.set(Calendar.YEAR, year)
                myCalendar.set(Calendar.MONTH, month)
                myCalendar.set(Calendar.DAY_OF_MONTH, day)
                updateLabel()
            }
        vb.etBirthday.setOnClickListener {
            DatePickerDialog(
                this.requireContext(),
                date,
                myCalendar[Calendar.YEAR],
                myCalendar[Calendar.MONTH],
                myCalendar[Calendar.DAY_OF_MONTH]
            ).show()
        }
    }

    private fun updateLabel() {
        val myFormat = "dd/MM/yyyy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.getDefault())
        vb.etBirthday.setText(dateFormat.format(myCalendar.time))
    }
}