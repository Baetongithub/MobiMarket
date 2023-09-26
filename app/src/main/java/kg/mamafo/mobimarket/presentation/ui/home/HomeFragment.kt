package kg.mamafo.mobimarket.presentation.ui.home

import android.os.Build
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import kg.mamafo.mobimarket.R
import kg.mamafo.mobimarket.presentation.extensions.toast
import kg.mamafo.mobimarket.data.model.GoodsModel
import kg.mamafo.mobimarket.databinding.FragmentMainBinding
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment
import kg.mamafo.mobimarket.presentation.utils.Constants
import java.io.Serializable

class HomeFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val goodsAdapter: HomeAdapter by lazy { HomeAdapter(this::onItemClick) }
    private val list = arrayListOf<GoodsModel>()

    override fun setUpUI() {
        super.setUpUI()

            list.add(GoodsModel(1, "BMW M4 Coupe: A Two Door","$ 23 000", "100","https://images.wsj.net/im-310515?width=1280&size=1"))
            list.add(GoodsModel(2, "BMW M5 Coupe: A Three Door","$ 23 000", "100","https://images.wsj.net/im-310515?width=1280&size=1"))
            list.add(GoodsModel(3, "BMW M6 Coupe: A Four Door","$ 23 000", "100","https://images.wsj.net/im-310515?width=1280&size=1"))
            list.add(GoodsModel(4, "BMW M7 Coupe: A Five Door","$ 23 000", "100","https://images.wsj.net/im-310515?width=1280&size=1"))
            list.add(GoodsModel(5, "BMW M8 Coupe: A Six Door","$ 23 000", "100","https://images.wsj.net/im-310515?width=1280&size=1"))
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
        findNavController().navigate(
            R.id.action_navigation_home_to_detailedGoodsViewFragment,
            bundle
        )
    }
}