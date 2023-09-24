package kg.mamafo.mobimarket.presentation.ui.main

import androidx.recyclerview.widget.GridLayoutManager
import kg.mamafo.mobimarket.presentation.extensions.toast
import kg.mamafo.mobimarket.data.model.Model
import kg.mamafo.mobimarket.databinding.FragmentMainBinding
import kg.mamafo.mobimarket.presentation.ui.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val goodsAdapter: MainAdapter by lazy { MainAdapter(this::onItemClick) }
    private val list = arrayListOf<Model>()

    override fun setUpUI() {
        super.setUpUI()

            list.add(Model(1, "BMW M4 Coupe: A Two Door","$ 23 000", "100","https://images.wsj.net/im-310515?width=1280&size=1"))
            list.add(Model(2, "BMW M5 Coupe: A Three Door","$ 23 000", "100","https://images.wsj.net/im-310515?width=1280&size=1"))
            list.add(Model(3, "BMW M6 Coupe: A Four Door","$ 23 000", "100","https://images.wsj.net/im-310515?width=1280&size=1"))
            list.add(Model(4, "BMW M7 Coupe: A Five Door","$ 23 000", "100","https://images.wsj.net/im-310515?width=1280&size=1"))
            list.add(Model(5, "BMW M8 Coupe: A Six Door","$ 23 000", "100","https://images.wsj.net/im-310515?width=1280&size=1"))
        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        vb.recyclerView.apply {
            layoutManager = GridLayoutManager(this.context,2)
            adapter = goodsAdapter
        }
        goodsAdapter.submitList(list)
    }

    private fun onItemClick(model:Model) {
        toast(model.name)
    }
}