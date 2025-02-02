package ir.mehdisekoba.sample.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ir.mehdisekoba.sample.data.ItemImage
import ir.mehdisekoba.sample.databinding.ItemSplashBinding
import ir.mehdisekoba.sample.utils.BaseDiffUtils
import ir.mehdisekoba.sample.utils.loadImage

class SplashAdapter : RecyclerView.Adapter<SplashAdapter.ViewHolder>() {
    private var items = emptyList<ItemImage>()
    private val dataMultiplier = 100
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSplashBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actualPosition = position % items.size
        holder.bind(items[actualPosition])
    }

    override fun getItemCount(): Int {
        return items.size * dataMultiplier
    }
    inner class ViewHolder(private val binding: ItemSplashBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ItemImage) {
            binding.itemImage.loadImage(item.url)
        }
    }

    fun setData(data: List<ItemImage>) {
        val adapterDiffUtils = BaseDiffUtils(items, data)
        val diffUtils = DiffUtil.calculateDiff(adapterDiffUtils)
        items = data
        diffUtils.dispatchUpdatesTo(this)
    }
}