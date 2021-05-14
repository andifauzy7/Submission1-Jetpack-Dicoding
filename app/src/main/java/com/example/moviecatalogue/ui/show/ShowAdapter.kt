package com.example.moviecatalogue.ui.show

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.databinding.ItemShowBinding
import com.example.moviecatalogue.model.ContentEntity
import com.example.moviecatalogue.ui.detail.DetailActivity

class ShowAdapter : RecyclerView.Adapter<ShowAdapter.ShowViewHolder>() {

    private var listShow = ArrayList<ContentEntity>()

    fun setShow(show : List<ContentEntity>){
        this.listShow.clear()
        this.listShow.addAll(show)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        val itemShowBinding = ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShowViewHolder(itemShowBinding)
    }

    override fun onBindViewHolder(holder: ShowViewHolder, position: Int) {
        val show = listShow[position]
        holder.bind(show)
    }

    override fun getItemCount(): Int = listShow.size

    class ShowViewHolder(private val binding: ItemShowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: ContentEntity) {
            with(binding) {
                tvItemNameShow.text = show.name
                tvItemCategoryShow.text = show.category
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.ID_CONTENT, show.id)
                    intent.putExtra(DetailActivity.TYPE_CONTENT, "SHOW")
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(show.image)
                    .into(imgPosterShow)
            }
        }
    }
}