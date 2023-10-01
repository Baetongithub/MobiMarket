package kg.mamafo.mobimarket.presentation.ui.home.detailed

import kg.mamafo.mobimarket.data.model.GoodsModel
import kg.mamafo.mobimarket.databinding.FragmentDetailedGoodsViewBinding
import kg.mamafo.mobimarket.presentation.extensions.customGetSerializable
import kg.mamafo.mobimarket.presentation.extensions.glide
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment
import kg.mamafo.mobimarket.presentation.utils.Constants

class DetailedGoodsViewFragment :
    BaseFragment<FragmentDetailedGoodsViewBinding>(FragmentDetailedGoodsViewBinding::inflate) {

    override fun setUpUI() {
        vb.btnBack.setOnClickListener { navigateUp() }

        val goodsModel =
            arguments?.customGetSerializable<GoodsModel>(Constants.DETAILED_VIEW_OF_PRODUCTS_BUNDLE)

        if (goodsModel != null) {
            vb.imageMainImageView.glide(goodsModel.photo)
            vb.tvNameOfProduct.text = goodsModel.name
            vb.tvAmountOfLike.text = goodsModel.amountOfLikes
        }
    }
}