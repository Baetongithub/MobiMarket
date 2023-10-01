package kg.mamafo.mobimarket.presentation.ui.profile

import android.net.Uri
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import kg.mamafo.mobimarket.R
import kg.mamafo.mobimarket.databinding.FragmentProfileBinding
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    override fun setUpUI() {
        vb.cardProfileImage.setOnClickListener { uploadProfilePhoto(vb.imageProfile) }

        vb.btnFavoriteProducts.setOnClickListener { navigate(R.id.action_profileFragment_to_likedProductsFragment) }
    }

    private fun uploadProfilePhoto(imageView: ImageView) {
        var uri: Uri
        val imageFromGallery =
            registerForActivityResult(ActivityResultContracts.GetContent()) { galleryUri ->
                if (galleryUri != null) {
                    uri = galleryUri
                    imageView.setImageURI(uri)
                }
            }
        vb.cardProfileImage.setOnClickListener {
            imageFromGallery.launch("image/*")

        }
    }
}