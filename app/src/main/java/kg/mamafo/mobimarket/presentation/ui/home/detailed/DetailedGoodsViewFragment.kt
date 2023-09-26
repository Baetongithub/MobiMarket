package kg.mamafo.mobimarket.presentation.ui.home.detailed

import android.os.Build
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import kg.mamafo.mobimarket.databinding.FragmentDetailedGoodsViewBinding
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment
import java.io.Serializable

class DetailedGoodsViewFragment :
    BaseFragment<FragmentDetailedGoodsViewBinding>(FragmentDetailedGoodsViewBinding::inflate) {

    override fun setUpUI() {
        super.setUpUI()
        vb.btnBack.setOnClickListener { findNavController().navigateUp() }
        
    }

    @Suppress("DEPRECATION")
    inline fun <reified T : Serializable> Bundle.customGetSerializable(key: String): T? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            getSerializable(key, T::class.java)
        } else {
            getSerializable(key) as? T
        }
    }
}