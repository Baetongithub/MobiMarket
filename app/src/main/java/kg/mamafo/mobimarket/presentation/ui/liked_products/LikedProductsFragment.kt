package kg.mamafo.mobimarket.presentation.ui.liked_products

import kg.mamafo.mobimarket.databinding.FragmentLikedProductsBinding
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment

class LikedProductsFragment :
    BaseFragment<FragmentLikedProductsBinding>(FragmentLikedProductsBinding::inflate) {

    override fun setUpUI() {
        vb.btnBack.setOnClickListener { navigateUp() }
    }
}