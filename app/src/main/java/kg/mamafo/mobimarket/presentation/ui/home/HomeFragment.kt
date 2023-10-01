package kg.mamafo.mobimarket.presentation.ui.home

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kg.mamafo.mobimarket.R
import kg.mamafo.mobimarket.data.model.GoodsModel
import kg.mamafo.mobimarket.databinding.FragmentMainBinding
import kg.mamafo.mobimarket.presentation.extensions.toast
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment
import kg.mamafo.mobimarket.presentation.utils.Constants

class HomeFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val goodsAdapter: HomeAdapter by lazy {
        HomeAdapter(
        this::onItemClick,
        this::onLikeClick,
        context)
    }
    private val list = arrayListOf<GoodsModel>()

    override fun setUpUI() {
            list.add(GoodsModel(1, "BMW M4 Coupe: A Two Door","ВПВАЫВМВЫ ЫФВАЫВ ЯЫВМВМЫ ЯЫВМВЫЯ","$ 23 000", "100","https://www.bmw-m.com/content/dam/bmw/marketBMW_M/common/topics/magazine-article-pool/2018/bmw-m-colours-vol-2/bmw-m-colours-vol-2-si.jpg"))
            list.add(GoodsModel(2, "BMW M5 Coupe: A Three Door","ВПВАЫВМВЫ ЫФВАЫВ ЯЫВМВМЫ ЯЫВМВЫЯ","$ 23 000", "100","https://www.bmw-m.com/content/dam/bmw/marketBMW_M/common/topics/magazine-article-pool/2018/bmw-m-colours-vol-2/bmw-m-colours-vol-2-ig-05.jpg"))
            list.add(GoodsModel(3, "BMW M6 Coupe: A Four Door","ВПВАЫВМВЫ ЫФВАЫВ ЯЫВМВМЫ ЯЫВМВЫЯ", "100","10000","https://www.bmw-m.com/content/dam/bmw/marketBMW_M/common/topics/magazine-article-pool/2018/bmw-m-colours-vol-2/bmw-m-colours-vol-2-ig-05.jpg"))
            list.add(GoodsModel(4, "BMW M7 Coupe: A Five Door","ВПВАЫВМВЫ ЫФВАЫВ ЯЫВМВМЫ ЯЫВМВЫЯ", "100","10000","https://i.pinimg.com/1200x/d1/54/ce/d154ce9ba34ac188511c491464ea30dc.jpg"))
            list.add(GoodsModel(5, "BMW M8 Coupe: A Six Door","ВПВАЫВМВЫ ЫФВАЫВ ЯЫВМВМЫ ЯЫВМВЫЯ", "10000","оздаво","https://www.bmw-m.com/content/dam/bmw/marketBMW_M/common/topics/magazine-article-pool/2018/bmw-m-colours-vol-2/bmw-m-colours-vol-2-ai-s.jpg"))
        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        vb.recyclerView.apply {
            layoutManager = GridLayoutManager(this.context,2)
            adapter = goodsAdapter
        }
        goodsAdapter.submitList(list)
    }

    private fun onItemClick(goodsModel:GoodsModel) {
        val bundle = Bundle()
        bundle.putSerializable(Constants.DETAILED_VIEW_OF_PRODUCTS_BUNDLE, goodsModel)
        navigate(R.id.action_navigation_home_to_detailedGoodsViewFragment, bundle)
    }

    private fun onLikeClick(goodsModel: GoodsModel) {
        toast(goodsModel.name)
    }
}
