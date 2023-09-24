package kg.mamafo.mobimarket.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kg.mamafo.mobimarket.data.model.Model
import kg.mamafo.mobimarket.databinding.ItemMainGoodsBinding
import kg.mamafo.mobimarket.presentation.extensions.glide

class MainAdapter(
    private val onItemClick: (Model) -> Unit
) : ListAdapter<Model, MainAdapter.MainViewHolder>(ProverbsDiffUtil()){

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

        fun bind(model: Model) {
            vb.tvNameOfProduct.text = model.name
            vb.tvPriceOfProduct.text = model.price
            vb.tvAmountOfLike.text = model.amountOfLikes
            vb.imageLike.glide(model.image)
        }
    }

    private class ProverbsDiffUtil : DiffUtil.ItemCallback<Model>() {
        override fun areItemsTheSame(
            oldItem: Model,
            newItem: Model
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Model,
            newItem: Model
        ): Boolean {
            return oldItem == newItem
        }
    }
}