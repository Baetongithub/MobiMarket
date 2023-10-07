package kg.mamafo.mobimarket.presentation.ui.my_products

import kg.mamafo.mobimarket.databinding.FragmentMyProductsBinding
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment

class MyProductsFragment :
    BaseFragment<FragmentMyProductsBinding>(FragmentMyProductsBinding::inflate) {

    override fun setUpUI() {
        vb.btnBack.setOnClickListener { navigateUp() }
    }
}