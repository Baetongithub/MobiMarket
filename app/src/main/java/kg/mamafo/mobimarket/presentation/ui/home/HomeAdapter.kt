package kg.mamafo.mobimarket.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.mamafo.mobimarket.data.model.GoodsModel
import kg.mamafo.mobimarket.databinding.ItemMainGoodsBinding
import kg.mamafo.mobimarket.presentation.extensions.glide

class HomeAdapter(
    private val onItemClick: (GoodsModel) -> Unit,
    private val onLikeClick: (GoodsModel) -> Unit,
) : ListAdapter<GoodsModel, HomeAdapter.MainViewHolder>(ProverbsDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemMainGoodsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { onItemClick(getItem(holder.adapterPosition)) }
    }

    inner class MainViewHolder(
        private val vb: ItemMainGoodsBinding
    ) : RecyclerView.ViewHolder(vb.root) {

        fun bind(goodsModel: GoodsModel) {
            vb.tvNameOfProduct.text = goodsModel.name
            vb.tvPriceOfProduct.text = goodsModel.price
            vb.tvAmountOfLike.text = goodsModel.amountOfLikes
            vb.mainImageView.glide(goodsModel.image)
            vb.imageLike.setOnClickListener { onLikeClick(getItem(adapterPosition)) }
        }
    }

    private class ProverbsDiffUtil : DiffUtil.ItemCallback<GoodsModel>() {
        override fun areItemsTheSame(
            oldItem: GoodsModel,
            newItem: GoodsModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: GoodsModel,
            newItem: GoodsModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}